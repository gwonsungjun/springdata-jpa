package com.sungjun.jpa.test1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Study {

    @Id @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private Account owner;
    // 여러개의 스터디를 만들 수 있으므로 스터디 입장에서는 ManyToOne (account 하나, 콜렉션이 아니므로 One)
    // Study 테이블안에 Account PK를 참조하는 FK를 생성해서 갖고 있게 됨.

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
