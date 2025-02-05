package edu.ucne.joseortega_p1_ap2.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.ucne.joseortega_p1_ap2.data.local.dao.SistemaDao
import edu.ucne.joseortega_p1_ap2.data.local.entity.Sistema

@Database(
    entities = [
        Sistema::class,
    ],
    version = 2,
    exportSchema = false
)
abstract class JoseOrtegaP1Db : RoomDatabase() {
    abstract fun sistemaDao(): SistemaDao
}