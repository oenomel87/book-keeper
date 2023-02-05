package io.oenomel.keeperserver.service

import io.oenomel.keeperserver.domain.dto.Pagination
import io.oenomel.keeperserver.domain.model.BookModel
import io.oenomel.keeperserver.domain.repository.BookRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class BookService(
     var bookRepository: BookRepository
) {

    fun fetchAllBooks(pagination: Pagination): Page<BookModel> {
        val pageRequest = PageRequest.of(pagination.page, pagination.size)
        val payload = this.bookRepository.findAll(pageRequest)
        val books = payload.content.map { BookModel.convert(it) }
        return PageImpl(
            books,
            payload.pageable,
            payload.totalElements
        )
    }

    fun fetchBook(id: String): BookModel {
        val rawData = this.bookRepository.findById(id.toLong())
        return if (rawData.isEmpty) throw EntityNotFoundException()
            else BookModel.convert(rawData.get())
    }
}
