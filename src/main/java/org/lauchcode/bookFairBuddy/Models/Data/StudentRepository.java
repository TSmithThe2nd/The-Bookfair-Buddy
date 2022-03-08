package org.lauchcode.bookFairBuddy.Models.Data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface StudentRepository extends CrudRepository {

}
