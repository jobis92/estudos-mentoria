package br.com.mentoria.catalogo.adapters.input.http.controller

import br.com.mentoria.catalogo.adapters.input.http.response.CatalogoResponse
import br.com.mentoria.catalogo.adapters.input.http.response.toDomain
import br.com.mentoria.catalogo.application.port.input.FindCatalogoInputPort
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/catalogos")
class CatalogoController(
    private val findCatologoInputPort: FindCatalogoInputPort
) {

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    fun getById(
        @PathVariable id: String
    ): CatalogoResponse {

        return findCatologoInputPort.findById(id).toDomain()

    }
}