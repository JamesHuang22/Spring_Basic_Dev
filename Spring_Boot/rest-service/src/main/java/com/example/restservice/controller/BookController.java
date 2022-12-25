package com.example.restservice.controller;


import com.example.restservice.model.Book;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
/*
    @RequestMapping :上面的示例中没有指定 GET 与 PUT、POST 等，因为**@RequestMapping默认映射所有HTTP Action**，你可以使用@RequestMapping(method=ActionType)来缩小这个映射。
 */
public class BookController {
    private List<Book> books = new ArrayList<>();

    @PostMapping("/book")
    public ResponseEntity<List<Book>> addBook(@RequestBody Book book) {
        books.add(book);
        //ResponseEntity: 表示整个HTTP Response：状态码，标头和正文内容。我们可以使用它来自定义HTTP Response 的内容。
        return ResponseEntity.ok(books);
    }

    @GetMapping("/book/all")
    public ResponseEntity<List<Book>> getAllBooks() {
            return ResponseEntity.ok(books);
    }

    @GetMapping("/book")
    public ResponseEntity getBookByName (@RequestParam("name") String name) {
        List<Book> results = books.stream().filter(book -> book.getName().equals(name)).collect(Collectors.toList());
        return ResponseEntity.ok(results);
    }



}
