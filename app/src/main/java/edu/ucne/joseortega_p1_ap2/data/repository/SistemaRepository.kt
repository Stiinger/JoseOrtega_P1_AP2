package edu.ucne.joseortega_p1_ap2.data.repository

import edu.ucne.joseortega_p1_ap2.data.local.dao.SistemaDao
import edu.ucne.joseortega_p1_ap2.data.local.entity.Sistema
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SistemaRepository @Inject constructor(
    private val sistemaDao: SistemaDao,
) {
    suspend fun save(sistema: Sistema) = sistemaDao.save(sistema)

    suspend fun find(id: Int) = sistemaDao.find(id)

    fun getAll(): Flow<List<Sistema>> = sistemaDao.getAll()

    suspend fun delete(sistema: Sistema) = sistemaDao.delete(sistema)
}