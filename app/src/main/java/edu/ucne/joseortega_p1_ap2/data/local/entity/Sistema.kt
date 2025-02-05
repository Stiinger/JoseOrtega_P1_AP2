package edu.ucne.joseortega_p1_ap2.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Sistemas")
data class Sistema(
    @PrimaryKey
    val sistemaId: Int? = null,
    val nombre: String = "",
    val precio: Double? = 0.0
)