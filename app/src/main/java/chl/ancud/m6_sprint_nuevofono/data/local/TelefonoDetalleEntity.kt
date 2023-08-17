package chl.ancud.m6_sprint_nuevofono.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_telefono")
class TelefonoDetalleEntity (
    @PrimaryKey val id: Int,
    val name: String,
    val price: Long,
    val image: String,
    val description: String,
    val lastPrice: Long,
    val credit: Boolean
)