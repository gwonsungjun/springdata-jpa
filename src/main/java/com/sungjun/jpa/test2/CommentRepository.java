package com.sungjun.jpa.test2;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentRepository extends MyRepository<Comment, Long> {

    Page<Comment> findByCommentContainsIgnoreCase(String keyword, Pageable pageable);
    //IgnoreCase : upper(comment0_.comment) like upper(?)

}
