package com.db.api.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.db.api.model.Book;
import com.db.api.repository.BookRepository;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "http://localhost:8080")
public class BookController {
	private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createBook(@RequestBody Book book) throws URISyntaxException {
        Book savedBook = bookRepository.save(book);
        return ResponseEntity.created(new URI("/bookss/" + savedBook.getId())).body(savedBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book currentBook = bookRepository.findById(id).orElseThrow(RuntimeException::new);
        currentBook.setName(book.getName());
        currentBook = bookRepository.save(book);

        return ResponseEntity.ok(currentBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
