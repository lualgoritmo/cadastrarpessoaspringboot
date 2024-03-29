package com.luciano.cadastropessoa.cadastrarpessoa.service

import com.luciano.cadastropessoa.cadastrarpessoa.controller.dto.CreateBookDTO
import com.luciano.cadastropessoa.cadastrarpessoa.model.Book

interface BookService {
    fun createBook(bookDTO: CreateBookDTO): Book
    fun getAllBooks(): List<Book>
    fun getByIdBook(idBook: Long): Book
    fun updateWithBookId(idBook: Long, book: Book): Book
    fun deleteByIdBook(idBook: Long)

}
