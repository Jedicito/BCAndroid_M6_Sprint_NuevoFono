package chl.ancud.m6_sprint_nuevofono.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TelefonoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTelefono(telefonoListadoEntity: List<TelefonoListadoEntity>)

}