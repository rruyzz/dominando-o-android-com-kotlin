package dominando.android.fragments.classes

data class Hotel(
    var id: Long = 0,
    var name: String = "",
    var address: String = "",
    var ratting: Float = 0.0F
) {
    override fun toString(): String = name
}