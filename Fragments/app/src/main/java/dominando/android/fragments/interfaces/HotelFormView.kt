package dominando.android.fragments.interfaces

import dominando.android.fragments.classes.Hotel

interface HotelFormView {
    fun showHotel(hotel: Hotel)
    fun errorInvalidHotel()
    fun errorSaveHotel()
}