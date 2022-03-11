package org.lauchcode.bookFairBuddy.models.data;

import org.lauchcode.bookFairBuddy.models.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AuthorRepository extends CrudRepository <Author, Integer> {
}
