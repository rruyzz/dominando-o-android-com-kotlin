package dominando.android.fragments.repository.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class HotelSqlHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(sqLiteDatabase: SQLiteDatabase?) {
        sqLiteDatabase?.execSQL(
            "CREATE TABLE $TABLE_HOTEL (" +
                    "$COLUMN_ID  INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "$COLUMN_NAME  TEXT NOT NULL, " +
                    "$COLUMN_ADDRESS  TEXT, " +
                    "$COLUMN_RATING REAL)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

}