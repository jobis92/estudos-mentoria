package br.com.mentoria.locadora.adapters.input.http.controller

import br.com.mentoria.locadora.adapters.input.http.api.LocadoraApi
import br.com.mentoria.locadora.adapters.input.http.response.CatalogoResponse
import br.com.mentoria.locadora.adapters.output.repository.jpaLocadoraAdapter.LocadoraRepository
import org.springframework.http.ResponseEntity

class LocadoraController(
    locadoraRepository: LocadoraRepository
) : LocadoraApi {

    override fun getBydId(itemId: String): CatalogoResponse {

        return CatalogoResponse(nome = "", tipo = "", diretor = "", genero = "")
    }

}