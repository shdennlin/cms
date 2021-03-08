package org.shdennlin.cms.controller;

import org.apache.catalina.User;
import org.shdennlin.cms.model.postgres.UserInfo;
import org.shdennlin.cms.service.UserInfoService;
import org.shdennlin.cms.service.userJWT.JWTEncrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    UserInfoService userInfoService;

    @GetMapping("/{id}")
    public ResponseEntity<UserInfo> userLogin(@PathVariable("id") Long id){

        UserInfo userInfo = userInfoService.getUserInfo(id);

        JWTEncrypt JWTEncrypt = new JWTEncrypt();

        Map<String, String> claimMap = new HashMap<>();
        claimMap.put("username", userInfo.getUsername());
        claimMap.put("password", userInfo.getPassword());
        String token = JWTEncrypt.getToken(claimMap);
        userInfo.setJwt(token);

        userInfo = userInfoService.updateUserinfoJWT(id, userInfo);

        return ResponseEntity.ok(userInfo);
    }

}
