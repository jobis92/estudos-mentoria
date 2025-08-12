package br.com.mentoria.catalogo.application.port.output

interface DeleteCatalogoOutputPort {

    fun delete(
        itemId: String
    )
}
