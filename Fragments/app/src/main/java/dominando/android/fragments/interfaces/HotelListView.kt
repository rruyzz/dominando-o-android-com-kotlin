package dominando.android.fragments.interfaces

import dominando.android.fragments.classes.Hotel

interface HotelListView {
    fun showHotels(hotels: List<Hotel>)
    fun showHotelDetails(hotel: Hotel)
}