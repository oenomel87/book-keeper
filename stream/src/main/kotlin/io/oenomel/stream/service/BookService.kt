package io.oenomel.stream.service

import io.oenomel.stream.domain.dto.Pagination
import io.oenomel.stream.domain.entity.Book
import io.oenomel.stream.domain.model.BookModel
import io.oenomel.stream.domain.repository.BookRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class BookService(
    var bookRepository: BookRepository
) {

    fun fetchAllBooks(pagination: Pagination): Mono<Page<BookModel>> {
        val pageRequest = PageRequest.of(pagination.page, pagination.size)
        return this.bookRepository.findAll()
            .collectList()
            .map { list -> PageImpl(
                this.createPagination(list, pagination),
                pageRequest,
                list.size.toLong()
            ) }
    }

    private fun createPagination(rawList: List<Book>, pagination: Pagination): List<BookModel> {
        return rawList.stream()
                .skip((pagination.page * pagination.size).toLong())
                .limit(pagination.size.toLong())
                .map { BookModel.convert(it) }
                .toList()
    }

    fun fetchBook(id: String): Mono<BookModel> {
        return this.bookRepository.findById(id.toLong())
            .map { BookModel.convert(it) }
    }
}
