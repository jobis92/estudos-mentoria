package br.com.mentoria.catalogo.application.core.usecase

import br.com.mentoria.catalogo.application.core.domain.Catalogo
import br.com.mentoria.catalogo.application.core.exceptions.NotFoundException
import br.com.mentoria.catalogo.application.port.input.UpdateCatalogoInputPort
import br.com.mentoria.catalogo.application.port.output.FindCatalogoOutputPort
import br.com.mentoria.catalogo.application.port.output.UpdateCatalogoOutputPort
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.stereotype.Service

@Service
class UpdateCatalogoUseCase(
    private val findCatalogoOutputPort: FindCatalogoOutputPort,
    private val catalogoOutputPort: UpdateCatalogoOutputPort
) : UpdateCatalogoInputPort {


    override fun update(itemId: String, catalogo: Catalogo): Catalogo {
        try {
            val getCatalogo = findCatalogoOutputPort.findById(
                itemId
            )
            if (getCatalogo == null) {
                throw NotFoundException(
                    "Catalogo com o id: $itemId nao encontrado."
                )
            } else {
                return catalogoOutputPort.update(
                    itemId = itemId, Catalogo(
                        id = itemId,
                        nome = catalogo.nome ?: getCatalogo.nome,
                        tipo = catalogo.tipo ?: getCatalogo.tipo,
                        diretor = catalogo.diretor ?: getCatalogo.diretor,
                        genero = catalogo.genero ?: getCatalogo.genero
                    )
                )
            }
        } catch (ex: Exception) {
            throw ex
        }
    }
}