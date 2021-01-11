package dominando.android.fragments.interfaces

import dominando.android.fragments.classes.Hotel

interface HotelDetailsView {
    fun showHotelDetails(hotel: Hotel)
    fun errorHotelNotFound()
}