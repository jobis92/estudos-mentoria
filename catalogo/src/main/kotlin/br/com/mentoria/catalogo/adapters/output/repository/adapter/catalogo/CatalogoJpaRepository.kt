package br.com.mentoria.catalogo.adapters.output.repository.adapter.catalogo

import br.com.mentoria.catalogo.adapters.output.repository.entity.CatalogoEntity
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface CatalogoJpaRepository : CrudRepository<CatalogoEntity, Long> {

    @Query(
        """
        SELECT c FROM Catalogo c
        WHERE (:nome IS NULL OR c.nome = :nome)
          AND (:tipo IS NULL OR c.tipo = :tipo)
          AND (:diretor IS NULL OR c.diretor = :diretor)
          AND (:genero IS NULL OR c.genero = :genero)
    """
    )
    fun findByFilters(
        nome: String?,
        tipo: String?,
        diretor: String?,
        genero: String?
    ): List<CatalogoEntity>


}