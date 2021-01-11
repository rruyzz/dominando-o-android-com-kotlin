package dominando.android.basico


import org.parceler.Parcel
import org.parceler.ParcelConstructor
@org.parceler.Parcel

class Cliente(var codigo: Int , var nome: String) {
    @ParcelConstructor constructor() : this(0, "")
}
