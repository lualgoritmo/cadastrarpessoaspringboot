package com.luciano.cadastropessoa.cadastrarpessoa.controller.dto

import com.luciano.cadastropessoa.cadastrarpessoa.model.Author
import com.luciano.cadastropessoa.cadastrarpessoa.model.Book
import com.luciano.cadastropessoa.cadastrarpessoa.model.Category
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import org.jetbrains.annotations.NotNull

data class UpdateBookDTO(
    @field:NotBlank(message = "O nome não pode estar em branco")
    @field:NotNull("O nome não pode ser nulo")
    val title: String,

    @field:NotNull("O ISBN não pode ser nulo")
    @field:NotBlank(message = "O ISBN não pode estar em branco")
    val isbnBook: String,

    @field:NotBlank(message = "O resume não pode estar em branco")
    @field:NotNull("O resume não pode ser nulo")
    @field:Size(max = 500, message = "A descrição deve ter no máximo 400 caracteres")
    val resume: String,

    val summary: String? = null,

    @field:NotNull("O preço não pode ser nulo")
    val price: Double = 20.0,

    @field:NotBlank(message = "A data não pode estar em branco")
    @field:NotNull("A data não pode ser nulo")
    val datePost: String,

    val authorId: Author,
    val categoryId: Category
) {
    fun toEntity() = Book(
        0,
        title = this.title,
        isbnBook = this.isbnBook,
        resume = this.resume,
        summary = this.summary,
        price = this.price,
        datePost = this.datePost,
        authorId = this.authorId,
        categoryId = this.categoryId
    )

    companion object {
        fun fromEntity(book: Book) = UpdateBookDTO(
            title = book.title,
            isbnBook = book.isbnBook,
            resume = book.resume,
            summary = book.summary,
            price = book.price,
            datePost = book.datePost,
            authorId = book.authorId,
            categoryId = book.categoryId
        )
    }
}