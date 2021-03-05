package org.shdennlin.cms.model;

import javax.persistence.*;

/* @Table > @Entity */

@Entity(name = "account")
@Table(name = "account")
public class Account {
    /*
    ==javax.persistence.GenerationType==
    AUTO: Indicates that the persistence provider should pick an appropriate strategy for the
          particular database.
    IDENTITY: Indicates that the persistence provider must assign primary keys for the entity using
              a database identity column.
    SEQUENCE: Indicates that the persistence provider must assign primary keys for the entity using
              a database sequence.
    TABLE: Indicates that the persistence provider must assign primary keys for the entity using an
           underlying database table to ensure uniqueness.
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

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

    public void setUsername(String username) {
        this.username = username;
//        return this;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
//        return this;
    }
}
