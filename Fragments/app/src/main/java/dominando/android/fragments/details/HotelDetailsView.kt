package dominando.android.fragments.details

import dominando.android.fragments.model.Hotel

interface HotelDetailsView {
    fun showHotelDetails(hotel: Hotel)
    fun errorHotelNotFound()
}