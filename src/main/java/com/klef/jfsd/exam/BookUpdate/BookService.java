package com.klef.jfsd.exam.BookUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService 
{
    @Autowired
    private BookRepository bookRepository;

    public Book updateBook(Long id, Book updatedBook) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book existingBook = optionalBook.get();
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setGenre(updatedBook.getGenre());
            existingBook.setPrice(updatedBook.getPrice());
            existingBook.setPublishedYear(updatedBook.getPublishedYear());
            return bookRepository.save(existingBook);
        } else {
            throw new RuntimeException("Book not found with ID: " + id);
        }
    }
}
