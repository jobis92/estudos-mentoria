package br.com.mentoria.catalogo.adapters.output.repository.adapter.catalogo

import br.com.mentoria.catalogo.adapters.output.repository.entity.toDomain
import br.com.mentoria.catalogo.application.core.domain.Catalogo
import br.com.mentoria.catalogo.application.port.output.FindCatalogoOutputPort
import org.springframework.stereotype.Repository

@Repository
class CatalogoRepository(
    private val crudRepository: CatalogoJpaRepository
) : FindCatalogoOutputPort {
    override fun findById(id: String): Catalogo {
        try {
            return crudRepository.findById(id.toLong()).get().toDomain()
        } catch (e: Exception) {
            throw e
        }
    }
}