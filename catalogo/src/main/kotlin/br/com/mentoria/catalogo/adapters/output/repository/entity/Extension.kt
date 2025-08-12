package br.com.mentoria.catalogo.adapters.output.repository.entity

import br.com.mentoria.catalogo.application.core.domain.Catalogo


fun CatalogoEntity.toDomain() = Catalogo(
    id = id.toString(),
    nome = nome,
    tipo = tipo,
    diretor = diretor,
    genero = genero
)

fun Catalogo.toEntity() = CatalogoEntity(
    id= id?.toLong(),
    nome = nome,
    tipo = tipo,
    diretor = diretor,
    genero = genero
)