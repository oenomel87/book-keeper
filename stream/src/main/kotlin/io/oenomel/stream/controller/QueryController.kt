package io.oenomel.stream.controller

import io.oenomel.stream.domain.dto.Pagination
import io.oenomel.stream.domain.model.BookModel
import io.oenomel.stream.service.BookService
import org.springframework.data.domain.Page
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import reactor.core.publisher.Mono

@Controller
class QueryController(
    var bookService: BookService
) {

    @QueryMapping
    fun allBooks(@Argument page: Pagination): Mono<Page<BookModel>> {
        return this.bookService.fetchAllBooks(page)
    }

    @QueryMapping
    fun book(@Argument id: String): Mono<BookModel> {
        return this.bookService.fetchBook(id)
    }
}
