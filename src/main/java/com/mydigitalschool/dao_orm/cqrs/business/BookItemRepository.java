package com.mydigitalschool.dao_orm.cqrs.business;

import org.springframework.data.repository.CrudRepository;

public interface BookItemRepository extends CrudRepository<Book, Long> {
}
