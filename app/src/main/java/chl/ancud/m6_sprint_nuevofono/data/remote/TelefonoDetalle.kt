package chl.ancud.m6_sprint_nuevofono.data.remote

data class TelefonoDetalle (
    val id: Int,
    val name: String,
    val price: Long,
    val image: String,
    val description: String,
    val lastPrice: Long,
    val credit: Boolean
)