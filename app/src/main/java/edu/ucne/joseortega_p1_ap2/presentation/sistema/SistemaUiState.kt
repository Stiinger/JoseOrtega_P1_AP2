package edu.ucne.joseortega_p1_ap2.presentation.sistema

import edu.ucne.joseortega_p1_ap2.data.local.entity.Sistema

data class SistemaUiState(
    val sistemaId: Int? = null,
    val nombre: String = "",
    val precio: String = "",
    val errorMessage: String? = null,
    val sistemas: List<Sistema> = emptyList()
)