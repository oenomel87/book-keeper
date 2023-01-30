package io.oenomel.keeperserver.controller

import io.oenomel.keeperserver.domain.dto.Pagination
import io.oenomel.keeperserver.domain.model.BookModel
import io.oenomel.keeperserver.exception.NotFoundException
import io.oenomel.keeperserver.service.BookService
import org.springframework.data.domain.Page
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class BookController(
    var bookService: BookService
) {

    @QueryMapping
    fun allBooks(@Argument page: Pagination): Page<BookModel> {
        return this.bookService.fetchAllBooks(page)
    }

    fun book(@Argument id: String): BookModel {
        try {
            return this.bookService.fetchBook(id)
        } catch (e: Exception) {
            throw NotFoundException()
        }
    }
}
