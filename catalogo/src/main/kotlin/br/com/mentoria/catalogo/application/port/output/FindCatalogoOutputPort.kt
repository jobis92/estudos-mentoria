package br.com.mentoria.catalogo.application.port.output

import br.com.mentoria.catalogo.application.core.domain.Catalogo

interface FindCatalogoOutputPort {

    fun findById(id: String): Catalogo
}