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
import java.util.Optional;

@RestController
@RequestMapping(CommandController.COMMAND_ENDPOINT)
public class CommandController {
    protected static final String COMMAND_ENDPOINT = "/api/commands";

    @Autowired
    BookRepository BookRepository;

    @Autowired
    EditorRepository EditorRepository;
    
    @Autowired
    BookItemRepository BookItemRepository;
    
    @Autowired
    BorrowRepository BorrowRepository;

    // créer l'éditeur (si besoin) et enregistre le livre
    @PostMapping("/create-book")
    ResponseEntity createBook(@RequestBody Book bookToCreate) {
        Optional.ofNullable(bookToCreate.editor).ifPresent(
                Editor -> bookToCreate.editor.id = this.EditorRepository.findOne(Editor.id)
                        .orElseGet(() -> this.EditorRepository.save(bookToCreate.editor)).id);

        this.BookRepository.save(bookToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(bookToCreate.id).toUri();

        return ResponseEntity.created(location).build();
    }
    
    // initie un prêt sur l'exemplaire de livre donné et le nom d'emprunteur donné (@RequestParam)
    @PostMapping("/borrow-book?bookItemId={}&userName={}")
    ResponseEntity createBorrow(@RequestParam Borrow borrowToCreate) {
        
    	return null;
    }
    
    // affecte une date de fin de prêt pour l'identifiant de prêt donné (@PutMapping, @RequestParam)
    @PutMapping("/return-book?borrowId={}")
    ResponseEntity updateBorrowEnd(@RequestParam Borrow borrowToUpdate) {
        
    	return null;
    }
}
