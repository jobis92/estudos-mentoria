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

    @GetMapping()
    @ResponseStatus(value = HttpStatus.OK)
    fun getAll(
        @RequestParam(required = false, name = "nome") nome: String?,
        @RequestParam(required = false, value = "tipo") tipo: String?,
        @RequestParam(required = false, value = "diretor") diretor: String?,
        @RequestParam(required = false, value = "genero") genero: String?
    ): List<CatalogoResponse> {
        return findCatologoInputPort.findByFilters(nome, tipo, diretor, genero).map { it.toDomain() }
    }
}