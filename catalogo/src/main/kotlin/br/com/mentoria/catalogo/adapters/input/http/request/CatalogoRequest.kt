package br.com.mentoria.catalogo.adapters.input.http.request

import jakarta.validation.constraints.NotNull

data class CatalogoRequest(

    @NotNull
    val nome: String?,

    @NotNull
    val tipo: String?,

    @NotNull
    val diretor: String?,

    @NotNull
    val genero: String?
)


