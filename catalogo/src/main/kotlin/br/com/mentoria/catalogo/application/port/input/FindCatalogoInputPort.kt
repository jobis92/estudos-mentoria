package br.com.mentoria.catalogo.application.port.input

import br.com.mentoria.catalogo.application.core.domain.Catalogo

interface FindCatalogoInputPort {


    fun findByFilters(
        nome: String?,
        tipo: String?,
        diretor: String?,
        genero: String?,
    ): List<Catalogo>
}
