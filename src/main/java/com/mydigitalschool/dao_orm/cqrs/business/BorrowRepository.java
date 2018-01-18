package com.mydigitalschool.dao_orm.cqrs.business;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BorrowRepository extends CrudRepository<Book, Long> {
}
