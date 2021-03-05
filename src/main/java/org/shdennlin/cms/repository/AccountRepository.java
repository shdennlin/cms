package org.shdennlin.cms.repository;

import org.shdennlin.cms.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author shdennlin
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

//    public Account findByUsernameAndPassword(String username, String password);
//
//    public List<Account> findByUsername(String username);

}
