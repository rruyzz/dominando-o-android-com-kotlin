package dominando.android.fragments.di

import dominando.android.fragments.details.HotelDetailsPresenter
import dominando.android.fragments.details.HotelDetailsView
import dominando.android.fragments.form.HotelFormPresenter
import dominando.android.fragments.form.HotelFormView
import dominando.android.fragments.list.HotelListPresenter
import dominando.android.fragments.list.HotelListView
import dominando.android.fragments.repository.HotelRepository
import dominando.android.fragments.repository.sqlite.SQLiteRepository
import org.koin.dsl.module.module

val androidModule = module{
    single { this }
    
    single{ 
        SQLiteRepository(ctx = get()) as HotelRepository
    }
    
    factory { (view : HotelListView) -> 
        HotelListPresenter(
            view,
            repository = get()
        )
    }
    factory { (view: HotelDetailsView) -> 
        HotelDetailsPresenter(
            view, repository = get()
        )
    }
    factory { (view: HotelFormView) ->
        HotelFormPresenter(view,repository = get())
    }
}