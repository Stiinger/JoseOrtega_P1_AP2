package edu.ucne.joseortega_p1_ap2.data.local.database

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase
import edu.ucne.joseortega_p1_ap2.data.local.dao.Dao

@Database(
    entities = [
        Entity::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class JoseOrtega_P1_AP2Db : RoomDatabase() {
    abstract fun dao(): Dao
}