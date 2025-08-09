package br.com.mentoria.catalogo.adapters.output.repository.adapter.catalogo

import br.com.mentoria.catalogo.adapters.output.repository.entity.toDomain
import br.com.mentoria.catalogo.adapters.output.repository.entity.toEntity
import br.com.mentoria.catalogo.application.core.domain.Catalogo
import br.com.mentoria.catalogo.application.port.output.CreateCatalogoOutputPort
import br.com.mentoria.catalogo.application.port.output.FindCatalogoOutputPort
import org.springframework.stereotype.Repository

@Repository
class CatalogoRepository(
    private val crudRepository: CatalogoJpaRepository
) : FindCatalogoOutputPort, CreateCatalogoOutputPort {
    override fun findByFilters(
        nome: String?,
        tipo: String?,
        diretor: String?,
        genero: String?
    ): List<Catalogo> {
        try {
            return crudRepository.findByFilters(nome, tipo, diretor, genero)
                .map { it.toDomain() }
        } catch (ex: Exception) {
            throw ex
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


    override fun create(catalogo: Catalogo): Catalogo {
        try {
            return crudRepository.save(catalogo.toEntity()).toDomain()

        } catch (ex: Exception) {
            throw ex
        }
    }


}