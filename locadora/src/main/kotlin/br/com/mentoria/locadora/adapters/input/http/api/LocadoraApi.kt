package br.com.mentoria.locadora.adapters.input.http.api

import br.com.mentoria.locadora.adapters.input.http.response.CatalogoResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/catalogos")
interface LocadoraApi {

    @GetMapping("/{itemId}")
    @ResponseStatus(value = HttpStatus.OK)
    fun getBydId(
        @RequestParam itemId: String
    ): CatalogoResponse

}