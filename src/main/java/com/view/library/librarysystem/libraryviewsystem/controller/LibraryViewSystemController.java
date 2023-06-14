package com.view.library.librarysystem.libraryviewsystem.controller;

import com.view.library.librarysystem.libraryviewsystem.api.view.LibraryBookEntryViewRequest;
import com.view.library.librarysystem.libraryviewsystem.service.LibraryViewService;
import com.view.library.librarysystem.libraryviewsystem.translator.LibraryViewSystemRequestTranslator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/library/books/view")
public class LibraryViewSystemController {

    @Autowired
    LibraryViewSystemRequestTranslator libraryViewSystemRequestTranslator;

    @PostMapping(value="/bookEntry", consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> setBookEntry(@RequestBody LibraryBookEntryViewRequest libraryBookEntryViewRequest){
        return libraryViewSystemRequestTranslator.libraryBookEntryViewRequestTranslator(libraryBookEntryViewRequest,null);
    }

    @GetMapping(value="/fetchAllBook", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllBookEntries(){
        return libraryViewSystemRequestTranslator.getAllLibraryBookEntriesViewRequestTranslator(null);
    }

    @GetMapping(value = "/fetchBookById/{id}", produces = "application/json")
    public ResponseEntity<?> fetchBookById(@PathVariable("id") String bookId){
        return libraryViewSystemRequestTranslator.getBookByIdViewRequestTranslator(bookId);
    }

    @DeleteMapping(value = "/deleteBookEntry/{id}", produces = "application/json")
    public ResponseEntity<?> deleteBookEntry(@PathVariable("id") String bookId){
        return libraryViewSystemRequestTranslator.deleteBookByIdViewRequestTranslator(bookId);
    }

    @PutMapping(value = "/bookUpdate/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateBookEntry(@RequestBody LibraryBookEntryViewRequest libraryBookEntryViewRequest
            ,@PathVariable("id") String bookId){
        ResponseEntity<String> response = libraryViewSystemRequestTranslator.updateBookEntryViewRequestTranslator(libraryBookEntryViewRequest,bookId);
        return response;
    }
}
