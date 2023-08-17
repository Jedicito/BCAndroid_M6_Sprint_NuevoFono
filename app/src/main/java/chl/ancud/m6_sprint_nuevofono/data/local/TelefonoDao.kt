package chl.ancud.m6_sprint_nuevofono.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TelefonoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTelefonos(telefonoListadoEntity: List<TelefonoListadoEntity>)

    @Query("Select * from tbl_telefonos")
    fun getTelefonos(): LiveData<List<TelefonoListadoEntity>>

    @Query("Select * from tbl_telefono where id = :id")
    fun getTelefonoDetalle(id: Long): LiveData<TelefonoDetalleEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTelefonoDetalle(telefonoDetalleEntity: TelefonoDetalleEntity: )


}