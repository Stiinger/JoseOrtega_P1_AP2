package edu.ucne.joseortega_p1_ap2.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import edu.ucne.joseortega_p1_ap2.data.local.entity.Sistema
import kotlinx.coroutines.flow.Flow

@Dao
interface SistemaDao {
    @Upsert()
    suspend fun save(sistema: Sistema)

    @Query(
        """
            SELECT *
            FROM Sistemas WHERE sistemaId == :id limit 1"""
    )
    suspend fun find(id: Int): Sistema?

    @Delete
    suspend fun delete(sistema: Sistema)

    @Query("SELECT * FROM Sistemas")
    fun getAll(): Flow<List<Sistema>>
}