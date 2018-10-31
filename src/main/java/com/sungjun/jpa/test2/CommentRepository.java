package com.sungjun.jpa.test2;

import java.util.List;

public interface CommentRepository extends MyRepository<Comment, Long> {

    List<Comment> findByCommentContainsIgnoreCaseAndLikeCountGreaterThan(String keyword, int likeCount);
    //IgnoreCase : upper(comment0_.comment) like upper(?)

}
