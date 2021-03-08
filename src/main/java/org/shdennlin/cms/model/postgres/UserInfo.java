package org.shdennlin.cms.model.postgres;

import javax.persistence.*;

/* @Table > @Entity */

@Entity(name = "user_info")
@Table(name = "user_info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String jwt;

    public Long getId() {
        return id;
    }

    public Long setId(Long id) {
        this.id = id;
        return id;
    }

    public String getUsername() {
        return username;
    }

    public UserInfo setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserInfo setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getJwt() { return jwt; }

    public UserInfo setJwt(String jwt) {
        this.jwt = jwt;
        return this;
    }
}
