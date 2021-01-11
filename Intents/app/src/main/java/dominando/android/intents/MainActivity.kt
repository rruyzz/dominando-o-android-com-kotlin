package dominando.android.intents

import android.app.SearchManager
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.Settings
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val listView = ListView(this)
        setContentView(listView)
        val adapter = ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                resources.getStringArray(R.array.intent_actions))
        listView.adapter = adapter
        listView.setOnItemClickListener{_, _, position, _ -> openIntentAtPosition(position)
        }
    }
    private fun callNumber(){
        val uri = Uri.parse("tel:123456789")
        val intent = Intent(Intent.ACTION_CALL, uri)
        openIntent(intent)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(grantResults.first() == PackageManager.PERMISSION_GRANTED){
            callNumber()
        }
    }

    private fun openIntentAtPosition(position: Int) {
        val uri: Uri?
        val intent: Intent?
        when (position){
            0 -> { // abrindo url
                uri = Uri.parse("http://www.nglauber.com.br")
                intent = Intent(Intent.ACTION_DIAL, uri)
                openIntent(intent)
            }
            1 -> { // realiza chamada
                if(ActivityCompat.checkSelfPermission(this,
                        android.Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(this,
                            arrayOf<String>(android.Manifest.permission.CALL_PHONE),
                            0)
                } else {
                    callNumber()
                }
            }
            2 -> { //Pesquisa uma posição no mapa
                uri = Uri.parse("geo:0,0?q=Rua+Amarela+")
                intent = Intent(Intent.ACTION_DIAL, uri)
                openIntent(intent)
            }
            3 -> { //Abre o editor de sms
                uri = Uri.parse("sms: 1234")
                intent = Intent(Intent.ACTION_DIAL, uri).putExtra("Sms_body", "Corpo do SMS")
                openIntent(intent)
            }
            4 -> { //Compartilha
                intent = Intent()
                        .setAction(Intent.ACTION_SEND)
                        .putExtra(Intent.EXTRA_TEXT, "Compartilhando via Intent")
                        .setType("text/plain")
                openIntent(intent)
            }
            5 -> { //Alarme
            intent = Intent()
                    .putExtra(AlarmClock.EXTRA_MESSAGE, "Estudar Android")
                    .putExtra(AlarmClock.EXTRA_HOUR, 19)
                    .putExtra(AlarmClock.EXTRA_MINUTES, 0)
                    .putExtra(AlarmClock.EXTRA_SKIP_UI, true)
                    .putExtra(AlarmClock.EXTRA_DAYS, arrayListOf(
                            Calendar.MONDAY,
                            Calendar.WEDNESDAY,
                            Calendar.FRIDAY)
                    )
            openIntent(intent)
            } //Busca na WEB
            6 -> {
            intent = Intent(Intent.ACTION_SEARCH)
                    .putExtra(SearchManager.QUERY, "Novatec")
            openIntent(intent)
            }
            7 -> { //Configuração do Aparelho
                intent = Intent(Settings.ACTION_SECURITY_SETTINGS)
                openIntent(intent)
            }
            8 -> { //Ação Customizada 1
                intent = Intent("dominando.android.CUSTOM_ACTION")
                openIntent(intent)
            }
            9 -> { //Ação Customizada 2
                uri = Uri.parse("produto://Notebook/Slim")
                intent = Intent(Intent.ACTION_VIEW, uri)
                openIntent(intent)
            }
            else -> finish()
        }

    }

    private fun openIntent(intent: Intent) {
        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        } else {
            Toast.makeText(this, R.string.error_intent, Toast.LENGTH_SHORT).show()
        }

    }
}