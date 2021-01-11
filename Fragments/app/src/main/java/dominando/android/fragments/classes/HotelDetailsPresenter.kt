package dominando.android.fragments.classes

import dominando.android.fragments.interfaces.HotelDetailsView
import dominando.android.fragments.interfaces.HotelRepository

class HotelDetailsPresenter(
    private val view: HotelDetailsView,
    private val repository: HotelRepository
) {
    fun loadHotelDetails(id: Long){
        repository.hotelById(id) { hotel ->
            if (hotel != null) {
                view.showHotelDetails(hotel)
            } else {
                view.errorHotelNotFound()
            }
        }
    }
}