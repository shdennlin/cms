package org.shdennlin.cms.repository;

import org.shdennlin.cms.model.postgres.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author shdennlin
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

//    public UserInfo findByUsernameAndPassword(String username, String password);
//
//    public List<UserInfo> findByUsername(String username);

}
