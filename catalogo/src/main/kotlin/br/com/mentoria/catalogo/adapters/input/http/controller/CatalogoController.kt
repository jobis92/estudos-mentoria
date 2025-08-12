package br.com.mentoria.catalogo.adapters.input.http.controller

import br.com.mentoria.catalogo.adapters.input.http.request.CatalogoRequest
import br.com.mentoria.catalogo.adapters.input.http.request.CatalogoUpdateRequest
import br.com.mentoria.catalogo.adapters.input.http.response.CatalogoResponse
import br.com.mentoria.catalogo.adapters.input.http.response.toDomain
import br.com.mentoria.catalogo.adapters.input.http.response.toResponse
import br.com.mentoria.catalogo.application.port.input.CreateCatalogoInputPort
import br.com.mentoria.catalogo.application.port.input.DeleteCatalogoInputPort
import br.com.mentoria.catalogo.application.port.input.FindCatalogoInputPort
import br.com.mentoria.catalogo.application.port.input.UpdateCatalogoInputPort
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/catalogos")
class CatalogoController(
    private val findCatologoInputPort: FindCatalogoInputPort,
    private val createCatalogoInputPort: CreateCatalogoInputPort,
    private val updateCatalogoInputPort: UpdateCatalogoInputPort,
    private val deleteCatalogoInputPort: DeleteCatalogoInputPort
) {

    @GetMapping()
    @ResponseStatus(value = HttpStatus.OK)
    fun getAll(
        @RequestParam(required = false, name = "nome") nome: String?,
        @RequestParam(required = false, value = "tipo") tipo: String?,
        @RequestParam(required = false, value = "diretor") diretor: String?,
        @RequestParam(required = false, value = "genero") genero: String?
    ): List<CatalogoResponse> {
        return findCatologoInputPort.findByFilters(nome, tipo, diretor, genero).map { it.toResponse() }
    }

    @PostMapping(
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    @ResponseStatus(HttpStatus.CREATED)
    fun create(
        @RequestBody @Valid catalogoRequest: CatalogoRequest
    ): CatalogoResponse {
        return createCatalogoInputPort.create(catalogoRequest.toDomain()).toResponse()
    }

    @PatchMapping("/{itemId}")
    @ResponseStatus(HttpStatus.OK)
    fun update(
        @PathVariable itemId: String,
        @RequestBody catalogoUpdateRequest: CatalogoUpdateRequest
    ): CatalogoResponse {
        return updateCatalogoInputPort.update(itemId, catalogoUpdateRequest.toDomain()).toResponse()
    }

    @DeleteMapping("/{itemId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(
        @PathVariable itemId: String
    ) {
        deleteCatalogoInputPort.delete(itemId)
    }
}