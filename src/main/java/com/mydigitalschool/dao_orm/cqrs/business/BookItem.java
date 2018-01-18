package com.mydigitalschool.dao_orm.cqrs.business;

import javax.persistence.*;

import com.mydigitalschool.dao_orm.cqrs.business.Book;

@Entity
public class BookItem {
    @Id
    @GeneratedValue
    public Long id;
    
    public String itemCode;

    @ManyToOne
    @JoinColumn
    public Book book;
}
