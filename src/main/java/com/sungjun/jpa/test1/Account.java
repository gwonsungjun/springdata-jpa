package com.sungjun.jpa.test1;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @OneToMany(mappedBy = "owner")
    private Set<Study> studies = new HashSet<>();

    public Set<Study> getStudies() {
        return studies;
    }

    public void setStudies(Set<Study> studies) {
        this.studies = studies;
    }

    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    // convenient method
    public void addStudy(Study study) {
        // 한 묶음으로 사용. account.getStudies().add(study); 만 하면 DB에 반영되지 않음.
        // study.setOwner(account);만 해도되지만 객체지향적으로 생각했을때 (서로의 레퍼런스를 가지고 있어야함) 두개를 같이 설정
        this.getStudies().add(study);
        study.setOwner(this);
        //
    }

    public void removeStudy(Study study) {
        this.getStudies().remove(study);
        study.setOwner(null);
    }
}
