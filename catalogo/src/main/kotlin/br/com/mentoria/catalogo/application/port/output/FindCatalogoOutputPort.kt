package br.com.mentoria.catalogo.application.port.output

import br.com.mentoria.catalogo.application.core.domain.Catalogo

interface FindCatalogoOutputPort {

    fun findByFilters(
        nome: String?,
        tipo: String?,
        diretor: String?,
        genero: String?
    ): List<Catalogo>

    fun findByNomeAndTipo(
        nome: String?,
        tipo: String?,
    ): List<Catalogo>

    fun findById(
        itemId: String,
    ): Catalogo

}