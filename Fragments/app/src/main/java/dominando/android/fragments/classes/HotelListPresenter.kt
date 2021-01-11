package dominando.android.fragments.classes

import dominando.android.fragments.classes.Hotel
import dominando.android.fragments.interfaces.HotelListView
import dominando.android.fragments.interfaces.HotelRepository

class HotelListPresenter(
    private val view: HotelListView,
    private val repository: HotelRepository
) {
    fun searchHotels(term: String) {
        repository.search(term){hotels ->
            view.showHotels(hotels)
        }
    }
    fun showHotelDetails(hotel: Hotel){
        view.showHotelDetails(hotel)
    }
}