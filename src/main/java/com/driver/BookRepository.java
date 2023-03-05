package com.driver;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    private List<Book> bookList;
    private int id;
    public BookRepository()
    {
        bookList=new ArrayList<>();
        id=1;
    }

    public Book saveBook(Book book)
    {
        book.setId(id);
        bookList.add(book);
        id++;
        return book;
    }

    public Book getBook(int id)
    {
        return bookList.get(id);
    }

    public void deleteBook(int id)
    {
        bookList.remove(id);
    }

    public List<Book> getBooks()
    {
        List<Book> newlist=new ArrayList<>();
        for(Book book : bookList)
        {
            newlist.add(book);
        }
        return newlist;
    }

    public void deleteAllBooks()
    {
        bookList.clear();
    }

    public List<Book> getBookByAuthor(String name)
    {
        List<Book> l=new ArrayList<>();
        for(Book book : bookList)
        {
            if(book.getName().equals(name))
            {
                l.add(book);
            }
        }

        return l;
    }

    public List<Book> getBookByGenre(String genre)
    {
        List<Book> l=new ArrayList<>();
        for(Book book : bookList)
        {
            if(book.getGenre().equals(genre))
            {
                l.add(book);
            }
        }

        return l;
    }

}
