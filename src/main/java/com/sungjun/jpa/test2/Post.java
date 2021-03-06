package com.sungjun.jpa.test2;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Post {

    @Id @GeneratedValue
    private Long id;

    private String title;

    @OneToMany(mappedBy ="post", cascade = {CascadeType.ALL}) // child에 해당하는 객체들도 Persistent 상태가 되면서 같이 저장.
   // fetch 아무것도 없으면 기본적으로 lazy 따라서 cooment제외한 post 정보만 가져온다.
    private Set<Comment>  comments = new HashSet<>();

    public void addComment(Comment comment) {
        this.getComments().add(comment);
        comment.setPost(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
