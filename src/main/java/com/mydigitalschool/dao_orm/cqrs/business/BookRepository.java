package com.mydigitalschool.dao_orm.cqrs.business;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
}
