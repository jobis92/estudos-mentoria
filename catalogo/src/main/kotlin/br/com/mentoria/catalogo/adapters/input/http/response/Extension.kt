package br.com.mentoria.catalogo.adapters.input.http.response

import br.com.mentoria.catalogo.application.core.domain.Catalogo

fun Catalogo.toDomain() = CatalogoResponse(
    nome = nome,
    tipo = tipo,
    diretor = diretor,
    genero = genero
)