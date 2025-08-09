package br.com.mentoria.catalogo.application.port.input

import br.com.mentoria.catalogo.application.core.domain.Catalogo

interface CreateCatalogoInputPort {

    fun create(catalogo: Catalogo): Catalogo
}
