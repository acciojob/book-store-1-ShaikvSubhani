package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Book saveBook(Book book)
    {
        return bookRepository.saveBook(book);
    }

    public Book getBook(int id)
    {
        return bookRepository.getBook(id);
    }

    public void deleteBook(int id)
    {
        bookRepository.deleteBook(id);
    }

    public List<Book> getBooks()
    {
        return bookRepository.getBooks();
    }

    public void deleteAllBook()
    {
        bookRepository.deleteAllBooks();
    }

    public List<Book> getBookByAuthor(String name)
    {
       return bookRepository.getBookByAuthor(name);
    }

    public List<Book> getBookByGenre(String genre)
    {
        return bookRepository.getBookByGenre(genre);
    }


}
