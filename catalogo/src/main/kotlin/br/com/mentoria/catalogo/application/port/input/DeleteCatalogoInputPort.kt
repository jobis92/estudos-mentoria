package br.com.mentoria.catalogo.application.port.input

interface DeleteCatalogoInputPort {

    fun delete(
        itemId: String
    )
}
