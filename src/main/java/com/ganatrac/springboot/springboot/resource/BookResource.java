package com.ganatrac.springboot.springboot.resource;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/book")
public class BookResource {

    @GetMapping(value = "/{count}", produces = "application/json")
    @ResponseBody
    public List<Book> getBooks(@PathVariable final int count) {
        return createBooks(count);
    }


    private List<Book> createBooks(int count) {
        List<Book> bookList = new ArrayList<>(count);
        for(int i = 0; i < count; i++) {
            bookList.add(new Book("MyBook"+i, "ISBN"+i));
        }
        return bookList;
    }
}

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String ISBN;

    public Book(String name, String ISBN) {
        this.name = name;
        this.ISBN = ISBN;
    }
}
