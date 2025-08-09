package br.com.mentoria.catalogo.application.core.usecase

import br.com.mentoria.catalogo.application.core.domain.Catalogo
import br.com.mentoria.catalogo.application.port.input.CreateCatalogoInputPort
import br.com.mentoria.catalogo.application.port.output.CreateCatalogoOutputPort
import br.com.mentoria.catalogo.application.port.output.FindCatalogoOutputPort
import org.springframework.stereotype.Service

@Service
class CreateCatalogoUseCase(
    private val findCatalogoOutputPort: FindCatalogoOutputPort,
    private val catalogoOutputPort: CreateCatalogoOutputPort
) : CreateCatalogoInputPort {


    override fun create(catalogo: Catalogo): Catalogo {
        try {
            val getCatalogos = findCatalogoOutputPort.findByNomeAndTipo(
                nome = catalogo.nome,
                tipo = catalogo.tipo
            )
            if (getCatalogos.contains(catalogo)) {
                throw Exception()
                println("Item com o nome: ${catalogo.nome} e tipo: ${catalogo.tipo} ja existe.")
            } else {
                return catalogoOutputPort.create(catalogo)
            }
        } catch (ex: Exception) {
            throw ex
        }
    }
}