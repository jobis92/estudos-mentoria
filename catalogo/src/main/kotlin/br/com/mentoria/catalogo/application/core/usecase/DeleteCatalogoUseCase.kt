package br.com.mentoria.catalogo.application.core.usecase

import br.com.mentoria.catalogo.application.core.exceptions.NotFoundException
import br.com.mentoria.catalogo.application.port.input.DeleteCatalogoInputPort
import br.com.mentoria.catalogo.application.port.output.DeleteCatalogoOutputPort
import br.com.mentoria.catalogo.application.port.output.FindCatalogoOutputPort
import org.springframework.stereotype.Service

@Service
class DeleteCatalogoUseCase(
    private val findCatalogoOutputPort: FindCatalogoOutputPort,
    private val catalogoOutputPort: DeleteCatalogoOutputPort
) : DeleteCatalogoInputPort {


    override fun delete(itemId: String) {
        try {
            val getCatalogo = findCatalogoOutputPort.findById(
                itemId
            )
            if (getCatalogo == null) {
                throw NotFoundException(
                    "Catalogo com o id: $itemId nao encontrado."
                )
            } else {
                catalogoOutputPort.delete(itemId)
            }
        } catch (ex: Exception) {
            throw ex
        }
    }
}