package dominando.android.fragments.fragments

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.ShareActionProvider
import androidx.core.view.MenuItemCompat
import androidx.fragment.app.Fragment
import dominando.android.fragments.MemoryRepository
import dominando.android.fragments.R
import dominando.android.fragments.classes.Hotel
import dominando.android.fragments.classes.HotelDetailsPresenter
import dominando.android.fragments.interfaces.HotelDetailsView
import kotlinx.android.synthetic.main.fragment_hotel_details.*

class HotelDetailFragments: Fragment(), HotelDetailsView {
    private val presenter = HotelDetailsPresenter(this, MemoryRepository)
    private var hotel: Hotel? = null
    private var shareActionProvider: ShareActionProvider? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.hotel_details, menu)
        val shareItem = menu?.findItem(R.id.action_share)
        shareActionProvider = MenuItemCompat.getActionProvider(shareItem) as? ShareActionProvider
        setShareIntent()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hotel_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.loadHotelDetails(arguments?.getLong(EXTRA_HOTEL_ID, -1) ?: -1)
    }
    override fun showHotelDetails(hotel: Hotel){
        this.hotel = hotel
        txtName.text = hotel.name
        txtAdress.text = hotel.address
        rtbRatting.rating = hotel.ratting

    }
    override fun errorHotelNotFound(){
        txtName.text = getString(R.string.error_hotel_not_found)
        txtAdress.visibility = View.GONE
        rtbRatting.visibility = View.GONE
    }
    private fun setShareIntent() {
        val text = getString(R.string.share_text, hotel?.name, hotel?.ratting)
        shareActionProvider?.setShareIntent(Intent(Intent.ACTION_SEND).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT)
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, text)
        })
    }
    companion object{
        const val TAG_DATAILS = "tagDetalhe"
        private const val EXTRA_HOTEL_ID = "hotelId"

        fun newInstance(id: Long) = HotelDetailFragments().apply{
            arguments=Bundle().apply {
                putLong(EXTRA_HOTEL_ID, id)
            }
        }
    }
}