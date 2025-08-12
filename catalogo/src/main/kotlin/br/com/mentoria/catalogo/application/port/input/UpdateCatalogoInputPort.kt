package br.com.mentoria.catalogo.application.port.input

import br.com.mentoria.catalogo.application.core.domain.Catalogo

interface UpdateCatalogoInputPort {

    fun update(itemId: String, catalogo: Catalogo): Catalogo
}
