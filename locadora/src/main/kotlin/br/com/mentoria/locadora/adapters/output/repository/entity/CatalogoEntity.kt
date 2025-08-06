package br.com.mentoria.locadora.adapters.output.repository.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


@Entity(name = "Locadora")
data class LocadoraEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val nome: String,
    val tipo: String,
    val diretor: String,
    val genero: String
)
