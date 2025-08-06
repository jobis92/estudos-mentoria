package br.com.mentoria.locadora.adapters.output.repository.adapter.locadora

import br.com.mentoria.locadora.adapters.output.repository.entity.LocadoraEntity
import org.springframework.data.repository.CrudRepository

interface CatalogoRepository : CrudRepository<LocadoraEntity, Long> {
}