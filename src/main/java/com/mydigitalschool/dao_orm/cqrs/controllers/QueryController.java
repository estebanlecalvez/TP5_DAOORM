package com.mydigitalschool.dao_orm.cqrs.controllers;

import com.mydigitalschool.dao_orm.cqrs.business.EditorRepository;
import com.mydigitalschool.dao_orm.cqrs.business.Editor;
import com.mydigitalschool.dao_orm.cqrs.business.BookRepository;
import com.mydigitalschool.dao_orm.cqrs.business.Book;
import com.mydigitalschool.dao_orm.cqrs.business.BookItemRepository;
import com.mydigitalschool.dao_orm.cqrs.business.BookItem;
import com.mydigitalschool.dao_orm.cqrs.business.Borrow;
import com.mydigitalschool.dao_orm.cqrs.business.BorrowRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(QueryController.QUERIES_ENDPOINT)
public class QueryController {
    protected static final String QUERIES_ENDPOINT = "/api/queries";

    @Autowired
    BookRepository BookRepository;

    @Autowired
    EditorRepository EditorRepository;
    
    @Autowired
    BookItemRepository BookItemRepository;
    
    @Autowired
    BorrowRepository BorrowRepository;

    // retourne liste des éditeurs et leur nombre de livres
    @GetMapping("/editors")
    Iterable<Editor> getEditorsWithNbBooks() {
        return this.EditorRepository.findAllWithNbBooks();
    }

    // liste des livres avec leur nom d'éditeur, le nombre d'emprunts en cours et finis
    @GetMapping("/borrowed-books")
    Iterable<Book> getBorrowedBooks() {
        return this.BookRepository.findAllWithEditorNameAndBorrows();
    }

    // liste les emprunts avec les noms du livre et de l'éditeur
    @GetMapping("/borrows")
    Iterable<Borrow> getBorrows(@RequestParam String name) {
        return this.BorrowRepository.findAllWithBookAndEditorName(name);
    }
    
    // fiche détaillée du livre donné (@PathVariable), nom d'éditeur, nombres d'emprunts en cours
    @GetMapping("/book/{bookId}")
    Book getById(@PathVariable Book aBook) {
        return this.BookRepository.findOneDetails(aBook);
    }
}
