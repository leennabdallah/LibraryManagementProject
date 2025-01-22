package com.libraryManagementSystem.service.impl;

import com.libraryManagementSystem.service.BookService;
import lombok.extern.slf4j.Slf4j;
import com.libraryManagementSystem.models.Book;
import com.libraryManagementSystem.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.libraryManagementSystem.repositories.BookRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book createBook(Book book) {
        log.info("Creating new book");
        return bookRepository.save(book);

    }
    @Override
    public Book viewBook(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isEmpty()) {
            log.error("Book with id: {} not found", id);
            throw new EntityNotFoundException("Book not found");
        }
        return book.get();
    }

    @Override
    public Book setBookUnavailable(long id) {
        if (bookRepository.findById(id).isEmpty()) {
            log.error("Book with id {} is not found", id );
            throw new EntityNotFoundException("Book with id " + id + " is not found");
        }
        bookRepository.setBookUnavailable(id);
        //bookRepository.save(bookRepository.findById(id).get());
        return bookRepository.findById(id).get();
    }
    @Override
    public Book setBookAvailable(long id) {
        if (bookRepository.findById(id).isEmpty()) {
            log.error("Book with id {} is not found", id );
            throw new EntityNotFoundException("Book with id " + id + " is not found");
        }
        bookRepository.setBookAvailable(id);
//        bookRepository.save(bookRepository.findById(id).get());
        log.info("Book with id {} found and its availability updated to true", id);
        return bookRepository.findById(id).get();
    }

    @Override
    public List<Book> getAllBooks() {
        log.info("Getting all books");
        if (bookRepository.findAll().isEmpty()) {
            log.error("No books found");
            throw new EntityNotFoundException("No books found");
        }
        return bookRepository.findAll();
    }

    @Override
    public Book findBookById(long id) {
        log.info("Getting book with id {}", id);
        Optional<Book> book = bookRepository.findById(id);
        if (book.isEmpty()) {
            log.error("Book with id {} is not found", id);
            throw new EntityNotFoundException("Book with id " + id + " is not found");
        }
        log.info("Book with id {} found", id);
        return book.get();
    }

    @Override
    public List<Book> findBookByTitle(String title) {
        log.info("Getting book with title {}", title);
        List<Book> books= bookRepository.findByTitleContainingIgnoreCase(title);
        if (books.isEmpty()) {
            log.error("No books found");
            throw new EntityNotFoundException("No books found");
        }
        log.info("Books containing title {} found", title);
        return books;
    }

    @Override
    public List<Book> findBookByCategory(Category category) {
        List<Book> books= bookRepository.findByCategory(category);
        if (books.isEmpty()) {
            log.error("No books found in the category: {}", category);
        }
        log.info("Books containing category {} found", category);
        return books;
    }

    @Override
    public String deleteBookByID(long id) {
        log.info("Deleting book with id {}", id);
        if (bookRepository.findById(id).isEmpty()) {
            log.error("Book with id {} is not found", id);
            throw new EntityNotFoundException("Book with id " + id + " is not found");
        }
        bookRepository.deleteById(id);
        return "Book with id " + id + " deleted";

    }

}
