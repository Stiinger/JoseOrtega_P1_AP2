package edu.ucne.joseortega_p1_ap2.presentation.sistema

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.joseortega_p1_ap2.data.local.entity.Sistema
import edu.ucne.joseortega_p1_ap2.data.repository.SistemaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SistemaViewModel @Inject constructor(
    private val repository: SistemaRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow(SistemaUiState())
    val uiState = _uiState.asStateFlow()

    init {
        getSistemas()
    }

    fun save() {
        viewModelScope.launch {
            if (isValid()) {
                repository.save(_uiState.value.toEntity())
            }
        }
    }

    fun onNombreChange(nombre: String) {
        _uiState.update {
            it.copy(
                nombre = nombre,
                errorMessage = if (nombre.isBlank()) "Debes rellenar el campo Nombre"
                else null
            )
        }
    }

    fun onPrecioChange(precio: String) {
        _uiState.update {
            val precioDouble = precio.toDoubleOrNull()
            it.copy(
                precio = precio,
                errorMessage = when {
                    precioDouble == null -> "Precio no numérico"
                    precioDouble <= 0 -> "El precio debe ser mayor a 0"
                    else -> null
                }
            )
        }
    }

    fun new() {
        _uiState.value = SistemaUiState()
    }

    fun delete() {
        viewModelScope.launch {
            repository.delete(uiState.value.toEntity())
        }
    }

    private fun getSistemas() {
        viewModelScope.launch {
            repository.getAll().collect { sistemas ->
                _uiState.update {
                    it.copy(sistemas = sistemas)
                }
            }
        }
    }

    fun find(id: Int) {
        viewModelScope.launch {
            if (id > 0) {
                val sistema = repository.find(id)
                if (sistema != null) {
                    _uiState.update {
                        it.copy(
                            sistemaId = sistema.sistemaId,
                            nombre = sistema.nombre,
                            precio = sistema.precio.toString()
                        )
                    }
                }
            }
        }
    }

    fun isValid(): Boolean {
        val nombreValid = _uiState.value.nombre.isNotBlank()
        val precioValid =_uiState.value.precio.toDoubleOrNull() != null
        _uiState.update {
            it.copy(
                errorMessage = when {
                    !nombreValid -> "Debes rellenar el campo Nombre"
                    !precioValid -> "Debes rellenar el campo Precio"
                    else -> null
                }
            )
        }

        return nombreValid && precioValid
    }
}

fun SistemaUiState.toEntity() = Sistema(
    sistemaId = this.sistemaId,
    nombre = this.nombre,
    precio = this.precio.toDouble()
)