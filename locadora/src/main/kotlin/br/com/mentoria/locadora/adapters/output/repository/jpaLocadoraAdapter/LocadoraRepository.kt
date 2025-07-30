package br.com.mentoria.locadora.adapters.output.repository.jpaLocadoraAdapter

import br.com.mentoria.locadora.adapters.output.repository.entity.LocadoraEntity
import org.springframework.data.repository.CrudRepository

interface LocadoraRepository : CrudRepository<LocadoraEntity, Long> {
}