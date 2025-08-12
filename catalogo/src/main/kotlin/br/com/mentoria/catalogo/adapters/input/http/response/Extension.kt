package br.com.mentoria.catalogo.adapters.input.http.response

import br.com.mentoria.catalogo.adapters.input.http.request.CatalogoRequest
import br.com.mentoria.catalogo.adapters.input.http.request.CatalogoUpdateRequest
import br.com.mentoria.catalogo.application.core.domain.Catalogo

fun Catalogo.toResponse() = CatalogoResponse(
    id = id,
    nome = nome,
    tipo = tipo,
    diretor = diretor,
    genero = genero
)

fun CatalogoRequest.toDomain() = Catalogo(
    nome = nome,
    tipo = tipo,
    diretor = diretor,
    genero = genero
)

fun CatalogoUpdateRequest.toDomain() = Catalogo(
    nome = nome,
    tipo = tipo,
    diretor = diretor,
    genero = genero
)