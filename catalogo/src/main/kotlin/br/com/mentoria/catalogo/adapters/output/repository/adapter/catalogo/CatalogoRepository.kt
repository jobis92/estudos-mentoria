package br.com.mentoria.catalogo.adapters.output.repository.adapter.catalogo

import br.com.mentoria.catalogo.adapters.output.repository.entity.toDomain
import br.com.mentoria.catalogo.application.core.domain.Catalogo
import br.com.mentoria.catalogo.application.port.output.FindCatalogoOutputPort
import br.com.mentoria.catalogo.application.port.output.UpdateCatalogoOutputPort
import org.springframework.stereotype.Repository

@Repository
class CatalogoRepository(
    private val crudRepository: CatalogoJpaRepository
) : FindCatalogoOutputPort, CreateCatalogoOutputPort, UpdateCatalogoOutputPort {
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

    override fun findByNomeAndTipo(
        nome: String?,
        tipo: String?
    ): List<Catalogo> {
        try {
            return crudRepository.findByNomeAndTipo(nome, tipo).map { it.toDomain() }
        } catch (ex: Exception) {
            throw ex
        }
    }

    override fun findById(itemId: String): Catalogo {
        try {
            return crudRepository.findById(itemId.toLong()).get().toDomain()
        } catch (ex: Exception) {
            throw ex
        }
    }

    override fun create(catalogo: Catalogo): Catalogo {
        try {
            return crudRepository.save(catalogo.toEntity()).toDomain()

        } catch (ex: Exception) {
            throw ex
        }
    }

    override fun update(
        itemId: String,
        catalogo: Catalogo
    ): Catalogo {
        try {
            return crudRepository.save(catalogo.toEntity()).toDomain()

        } catch (ex: Exception) {
            throw ex
        }
    }


}