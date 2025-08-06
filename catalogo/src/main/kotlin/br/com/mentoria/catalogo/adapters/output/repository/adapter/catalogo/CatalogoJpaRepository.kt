package br.com.mentoria.catalogo.adapters.output.repository.adapter.catalogo

import br.com.mentoria.catalogo.adapters.output.repository.entity.CatalogoEntity
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import java.util.Optional

interface CatalogoJpaRepository: CrudRepository<CatalogoEntity, Long> {

    @Query("SELECT c FROM Catalogo c WHERE c.nome = :name")
    fun findByNome(name: String): Optional<CatalogoEntity>

}