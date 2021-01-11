package dominando.android.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dominando.android.fragments.classes.Hotel
import dominando.android.fragments.fragments.HotelListFragment

class MainActivity : AppCompatActivity(), HotelListFragment.OnHotelClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel)
    }


    override fun onHotelClick(hotel: Hotel) {
        showDetailsActivity(hotel.id)
    }

    private fun showDetailsActivity(hotelId: Long) {
        HotelDetailsActivity.open(this, hotelId)

    }
}