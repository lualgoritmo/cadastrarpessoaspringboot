package com.luciano.cadastropessoa.cadastrarpessoa.controller

import com.luciano.cadastropessoa.cadastrarpessoa.controller.dto.ResponseCEPDTO
import com.luciano.cadastropessoa.cadastrarpessoa.service.impl.ConsulteCepImpl
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/cepaddress")
//@Api(tags = ["consulteCep"])
class ConsulteCepController(private val consulteCep: ConsulteCepImpl) {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    suspend fun consulteCep(@RequestParam("cep")cep: String): ResponseCEPDTO {
        return consulteCep.consulteViaCep(cep)
    }
}
