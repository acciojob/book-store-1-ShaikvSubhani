package com.driver;

import java.util.ArrayList;
import java.util.List;

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
        bookList.add(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    // get request /get-book-by-id/{id}
    // pass id as path variable
    // getBookById()
    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String id){
        for(Book book : bookList){
            if(book.getId()==Integer.parseInt(id)) return new ResponseEntity<>(book,HttpStatus.OK);
        }
        return null;
    }


    // delete request /delete-book-by-id/{id}
    // pass id as path variable
    // deleteBookById()
    @DeleteMapping("/delete-book-by-id/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable String id){
        String message="Book Not Available";
        for(Book book : bookList) {
            if (book.getId() == Integer.parseInt(id)) {
                bookList.remove(book);
                message="Book With Id "+id+" Deleted Successfully";
                break;
            }
        }
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    // get request /get-all-books
    // getAllBooks()
    @GetMapping("/get-all-books")
    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<>(bookList,HttpStatus.OK);
    }

    // delete request /delete-all-books
    // deleteAllBooks()
    @DeleteMapping("/delete-all-books")
    public ResponseEntity<String> deleteAllBooks(){
        bookList.clear();
        return new ResponseEntity<>("All Books Removed",HttpStatus.OK);
    }

    // get request /get-books-by-author
    // pass author name as request param
    // getBooksByAuthor()
    @GetMapping("/get-books-by-author")
    public ResponseEntity<List<Book>> getBooksByAuthor(@RequestParam String author){
        List<Book> ls= new ArrayList<>();
        for(Book book : bookList){
            if(book.getAuthor().equals(author)) ls.add(book);
        }
        return new ResponseEntity<>(ls,HttpStatus.OK);
    }

    // get request /get-books-by-genre
    // pass genre name as request param
    // getBooksByGenre()
    @GetMapping("/get-books-by-genre")
    public ResponseEntity<List<Book>> getBooksByGenre(@RequestParam String genre){
        List<Book> ls= new ArrayList<>();
        for(Book book : bookList){
            if(book.getGenre().equals(genre)) ls.add(book);
        }
        return new ResponseEntity<>(ls,HttpStatus.OK);
    }
}
/*
Make an MVC architecture, with Book as your only model class, which will have id, name, author and genre as properties. Then make a controller class with appropriate annotations. Since you want to keep it simple, you don’t need to use any database. You can use a List of Books in the controller layer itself to store the records.
You need to implement the logic for following functionalities:
Save a book: /books/create-book - Return created book object as response
Get book object by Id: /books/get-book-by-id/{id} - Return book object as response
Get all books: /books/get-all-books - Return book object as response
Get books by author: /books/get-books-by-author?author=author+name
Get books by genre: /books/get-books-by-genre?genre=genre+name
Delete book by id: /books/delete-book-by-id/{id}
Delete all books: /books/delete-all-books\
*/