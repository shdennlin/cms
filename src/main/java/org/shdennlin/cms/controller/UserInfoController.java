package org.shdennlin.cms.controller;


import org.shdennlin.cms.model.postgres.UserInfo;
import org.shdennlin.cms.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/userinfo", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/{id}")
    public ResponseEntity<UserInfo> getUserInfo(@PathVariable("id") Long id) {
        UserInfo userInfo = userInfoService.getUserInfo(id);
        return ResponseEntity.ok(userInfo);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserInfo> createUserInfo(@RequestBody UserInfo userInfo) {
        userInfo = userInfoService.createUserInfo(userInfo);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userInfo.getId())
                .toUri();

        return ResponseEntity.created(location).body(userInfo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserInfo> replaceUserInfo(
            @PathVariable("id") Long id, @RequestBody UserInfo userInfo) {
        userInfo = userInfoService.replaceUserInfo(id, userInfo);
        return ResponseEntity.ok(userInfo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserInfo> deleteUserInfo(@PathVariable("id") Long id) {
        userInfoService.deleteUserInfo(id);
        return ResponseEntity.noContent().build();
    }

}
