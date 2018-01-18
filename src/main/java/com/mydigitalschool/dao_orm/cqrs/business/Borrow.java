package com.mydigitalschool.dao_orm.cqrs.business;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Borrow {
    @Id
    @GeneratedValue
    public Long id;
    public String borrowerName;
    public Date borrowStart;
    public Date borrowEnd;
    
    @ManyToOne
    @JoinColumn
    public BookItem borrowed;
}
