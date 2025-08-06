package br.com.mentoria.locadora.adapters.input.http.controller

import br.com.mentoria.locadora.adapters.input.http.response.CatalogoResponse
import br.com.mentoria.locadora.adapters.output.repository.adapter.locadora.CatalogoRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/catalogos")
class CatalogoController(
    locadoraRepository: CatalogoRepository
) {

    @GetMapping("/{itemId}")
    @ResponseStatus(value = HttpStatus.OK)
    fun getBydId(
        @PathVariable itemId: String
    ): CatalogoResponse {
        return CatalogoResponse(nome = "", tipo = "", diretor = "", genero = "")
    }
}