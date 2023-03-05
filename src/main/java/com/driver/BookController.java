package com.driver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    BookService bookService;
    private List<Book> bookList;
    private int id;

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BookController(){
        this.bookList = new ArrayList<Book>();
        this.id = 1;
    }

    // post request /create-book
    // pass book as request body
    @PostMapping("/create-book")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        // Your code goes here.
        bookService.saveBook(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    // get request /get-book-by-id/{id}
    // pass id as path variable
    // getBookById()
    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id){
        // Your code goes here.
        Book book=bookService.getBook(id);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    // delete request /delete-book-by-id/{id}
    // pass id as path variable
    // deleteBookById()

    @DeleteMapping("/delete-book-by-id/{id}")
    public void deleteBookById(@PathVariable int id){
        // Your code goes here.
        bookService.deleteBook(id);
    }

    // get request /get-all-books
    // getAllBooks()
    @GetMapping("/get-all-books")
    public ResponseEntity getAllBooks(){
        // Your code goes here.
        List<Book> ans=bookService.getBooks();
        return new ResponseEntity<>(ans,HttpStatus.CREATED);
    }


    // delete request /delete-all-books
    // deleteAllBooks()
    @DeleteMapping("/delete-all-books")
    public void deleteAllBooks(){
        // Your code goes here.
        bookService.deleteAllBook();
    }


    // get request /get-books-by-author
    // pass author name as request param
    // getBooksByAuthor()
    @GetMapping("/get-books-by-author")
    public ResponseEntity getBooksByAuthor(@RequestParam String name){
        // Your code goes here.
       List<Book> a=bookService.getBookByAuthor(name);
       return new ResponseEntity<>(a,HttpStatus.CREATED);
    }


    // get request /get-books-by-genre
    // pass genre name as request param
    // getBooksByGenre()
    @GetMapping("/get-books-by-genre")
    public ResponseEntity getBooksByGenre(@RequestParam String genre){
        // Your code goes here.
        List<Book> a=bookService.getBookByGenre(genre);
        return new ResponseEntity<>(a,HttpStatus.CREATED);
    }
}
