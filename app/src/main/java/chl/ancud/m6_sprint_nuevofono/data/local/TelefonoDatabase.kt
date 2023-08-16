package chl.ancud.m6_sprint_nuevofono.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase

@Database(entities = [TelefonoListadoEntity::class], version = 1)
abstract class TelefonoDatabase: RoomDatabase() {

    abstract fun getITelefonoDao(): TelefonoDao

    companion object {
        @Volatile
        private var INSTANCIA: TelefonoDatabase? = null

        fun getDatabase(context: Context): TelefonoDatabase {
            val tempInstancia = INSTANCIA
            if (tempInstancia != null) {
                return tempInstancia
            }
            synchronized(this) {
                val instancia = databaseBuilder(
                    context.applicationContext,
                    TelefonoDatabase::class.java,
                    "telefonos_database"
                ).build()

                INSTANCIA = instancia
                return instancia
            }
        }

    }

}