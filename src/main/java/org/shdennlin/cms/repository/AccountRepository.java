package org.shdennlin.cms.repository;

import org.shdennlin.cms.model.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountModel, Long> {

}
