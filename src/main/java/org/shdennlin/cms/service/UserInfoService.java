package org.shdennlin.cms.service;

import org.shdennlin.cms.exception.NotFoundException;
import org.shdennlin.cms.model.postgres.UserInfo;
import org.shdennlin.cms.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    /**
     * Get UserInfo
     *
     * @param userInfoId
     * @return
     */
    public UserInfo getUserInfo(Long userInfoId) {
        return userInfoRepository.findById(userInfoId)
                .orElseThrow(() -> new NotFoundException("Can't find User."));
    }


    /**
     * Create UserInfo
     *
     * @param request
     * @return
     */
    public UserInfo createUserInfo(UserInfo request) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(request.getUsername());
        userInfo.setPassword(request.getPassword());

        return userInfoRepository.save(userInfo);
    }

    /**
     * Replace UserInfo
     *
     * @param id
     * @param request
     * @return
     */
    public UserInfo replaceUserInfo(Long id, UserInfo request) {
        UserInfo oldUserInfo = getUserInfo(id);

        UserInfo userInfo = new UserInfo();
        userInfo.setId(oldUserInfo.getId());
        userInfo.setUsername(request.getUsername());
        userInfo.setPassword(request.getPassword());

        return userInfoRepository.save(userInfo);
    }


    /**
     * Delete UserInfo
     *
     * @param userInfoId
     */
    public void deleteUserInfo(Long userInfoId) {
        userInfoRepository.deleteById(userInfoId);
    }

}