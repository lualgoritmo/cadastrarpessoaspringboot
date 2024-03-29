package com.luciano.cadastropessoa.cadastrarpessoa.controller.dto

import com.luciano.cadastropessoa.cadastrarpessoa.util.UniqueValue
import com.luciano.cadastropessoa.cadastrarpessoa.model.Author
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class RequestAuthorDTO(
    @field:NotBlank(message = "O nome não pode estar em branco")
    @field:NotNull(message = "O nome não pode ser nulo")
    val name: String,

    @field:Email(message = "O e-mail deve ser válido")

    @field:UniqueValue(
        message = "Este Email já está sendo usado!",
        fieldName = "email",
        domainClass = Author::class
    )
    val email: String,

    @field:NotBlank(message = "A descrição não pode estar em branco")
    @field:Size(max = 255, message = "A descrição deve ter no máximo 255 caracteres")
    val description: String,
) {
    fun toEntity() = Author(
        idAuthor = 0,
        name = this.name,
        email = this.email,
        description = this.description
    )

    companion object {
        fun fromEntity(author: Author) = RequestAuthorDTO(
            name = author.name,
            email = author.email,
            description = author.description,
        )
    }
}
