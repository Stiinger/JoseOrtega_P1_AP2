package edu.ucne.joseortega_p1_ap2.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import edu.ucne.joseortega_p1_ap2.data.local.entity.Entity
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Upsert()
    suspend fun save(entidad: Entity)

    @Query(
        """
            SELECT *
            FROM Entidad WHERE entityId == :id limit 1"""
    )
    suspend fun find(id: Int): Entity?

    @Delete
    suspend fun delete(ticket: Entity)

    @Query("SELECT * FROM entidad")
    fun getAll(): Flow<List<Entity>>
}