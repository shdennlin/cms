package org.shdennlin.cms.model;

import javax.persistence.*;

/* @Table > @Entity */
@Entity(name = "account")
@Table(name = "account")
public class AccountModel {
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
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public AccountModel setId(Long id) {
        this.id = id;
        return this;
    }

    public AccountModel setName(String name) {
        this.name = name;
        return this;
    }
}
