package br.com.mentoria.catalogo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CatalogoApplication

fun main(args: Array<String>) {
    runApplication<CatalogoApplication>(*args)
}
