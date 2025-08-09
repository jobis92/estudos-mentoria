package br.com.mentoria.catalogo.application.port.output

import br.com.mentoria.catalogo.application.core.domain.Catalogo

interface CreateCatalogoOutputPort {

    fun create(
        catalogo: Catalogo
    ): Catalogo
}