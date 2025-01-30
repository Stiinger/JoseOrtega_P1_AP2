package edu.ucne.joseortega_p1_ap2.data.repository

import edu.ucne.joseortega_p1_ap2.data.local.dao.Dao
import edu.ucne.joseortega_p1_ap2.data.local.entity.Entity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EntidadRepository @Inject constructor(
    private val dao: Dao,
) {
    suspend fun save(entity: Entity) = dao.save(entity)

    suspend fun find(id: Int) = dao.find(id)

    fun getAll(): Flow<List<Entity>> = dao.getAll()

    suspend fun delete(entity: Entity) = dao.delete(entity)
}