package br.com.mentoria.catalogo.adapters.output.repository.adapter.catalogo

import br.com.mentoria.catalogo.adapters.output.repository.entity.toDomain
import br.com.mentoria.catalogo.application.core.domain.Catalogo
import br.com.mentoria.catalogo.application.port.output.FindCatalogoOutputPort
import org.springframework.stereotype.Repository

@Repository
class CatalogoRepository(
    private val crudRepository: CatalogoJpaRepository
) : FindCatalogoOutputPort {
    override fun findByFilters(
        nome: String?,
        tipo: String?,
        diretor: String?,
        genero: String?
    ): List<Catalogo> {
        try {
            return crudRepository.findByFilters(nome, tipo, diretor, genero)
                .map { it.toDomain() }
        } catch (e: Exception) {
            throw e
        }
    }
}