package br.com.mentoria.catalogo.application.port.input

import br.com.mentoria.catalogo.application.core.domain.Catalogo

interface FindCatalogoInputPort {


    fun findById(id: String): Catalogo
}
