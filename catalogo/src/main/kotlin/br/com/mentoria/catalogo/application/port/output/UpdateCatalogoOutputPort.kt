package br.com.mentoria.catalogo.application.port.output

import br.com.mentoria.catalogo.application.core.domain.Catalogo

interface UpdateCatalogoOutputPort {

    fun update(
        itemId:String,
        catalogo: Catalogo
    ): Catalogo
}