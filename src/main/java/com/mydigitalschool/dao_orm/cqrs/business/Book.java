package com.mydigitalschool.dao_orm.cqrs.business;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue
    public Long id;
    
    public String title;

    @ManyToOne
    @JoinColumn
    public Editor editor;
}
