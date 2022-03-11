package org.lauchcode.bookFairBuddy.models.data;

import org.lauchcode.bookFairBuddy.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface StudentRepository extends CrudRepository<Student, Integer>{

}
