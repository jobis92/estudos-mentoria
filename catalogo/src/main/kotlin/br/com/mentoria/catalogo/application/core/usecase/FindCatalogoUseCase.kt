package br.com.mentoria.catalogo.application.core.usecase

import br.com.mentoria.catalogo.application.core.domain.Catalogo
import br.com.mentoria.catalogo.application.port.input.FindCatalogoInputPort
import br.com.mentoria.catalogo.application.port.output.FindCatalogoOutputPort
import org.springframework.stereotype.Service

@Service
class FindCatalogoUseCase(
    private val findCatalogoOutputPort: FindCatalogoOutputPort
) : FindCatalogoInputPort {

    override fun findByFilters(
        nome: String?,
        tipo: String?,
        diretor: String?,
        genero: String?,
    ): List<Catalogo> {
        return findCatalogoOutputPort.findByFilters(nome, tipo, diretor, genero)
    }
}