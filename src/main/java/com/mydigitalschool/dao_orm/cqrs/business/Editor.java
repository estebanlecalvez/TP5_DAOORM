package com.mydigitalschool.dao_orm.cqrs.business;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Editor {
    @Id
    @GeneratedValue
    public static Long id;

    public static String name;
}
