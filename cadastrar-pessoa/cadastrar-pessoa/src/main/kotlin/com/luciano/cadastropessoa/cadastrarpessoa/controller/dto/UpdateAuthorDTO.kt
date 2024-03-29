package com.luciano.cadastropessoa.cadastrarpessoa.controller.dto

import com.luciano.cadastropessoa.cadastrarpessoa.model.Author
import com.luciano.cadastropessoa.cadastrarpessoa.model.Book
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

class UpdateAuthorDTO(
    @field:NotBlank(message = "O nome não pode estar em branco")
    private val name: String,
    @field:Email(message = "O e-mail deve ser válido")
    private val email: String,
    @field:NotBlank(message = "A descrição não pode estar em branco")
    @field:Size(max = 255, message = "A descrição deve ter no máximo 255 caracteres")
    private val description: String,
    private val book: List<Book> = emptyList()
) {
    fun toEntity() = Author(
        idAuthor = 0,
        name = this.name,
        email = this.email,
        description = this.description,
        books = this.book
    )

    companion object {
        fun fromEntity(author: Author) =
            UpdateAuthorDTO(
                name = author.name,
                email = author.email,
                description = author.description,
                book = author.books
            )
        }

}
