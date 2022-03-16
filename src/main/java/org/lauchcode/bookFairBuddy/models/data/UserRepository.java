package org.lauchcode.bookFairBuddy.models.data;

import org.lauchcode.bookFairBuddy.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends CrudRepository <User, Integer> {

    User findByUserName(String userName);

}
