package com.sungjun.jpa;

import com.sungjun.jpa.test1.Account;
import com.sungjun.jpa.test1.Study;
import com.sungjun.jpa.test2.Comment;
import com.sungjun.jpa.test2.Post;
import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class JpaRunner  implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager; // JPA 가장 핵심적인 API ( hibernate에서는 Session이 가장 핵심적인 API )

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setUsername("gwonsungjun");
        account.setPassword("jpa");

        Study study = new Study();
        study.setName("spring data JPA");

        account.addStudy(study);

        //entityManager.persist(account);
         Session session = entityManager.unwrap(Session.class);
         session.save(account);
         session.save(study);

         Account sungjun = session.load(Account.class, account.getId());
         sungjun.setUsername("sungjun2");
         sungjun.setUsername("sungjun"); // insert 2번 update 1번
         sungjun.setUsername("gwonsungjun"); // insert 2번 (Persistent 상태에서 commit 전이므로 이전 이름과 같다고 판단하며 update 수행 X)
        System.out.println("===================");
        System.out.println(sungjun.getUsername());

        Post post = new Post();
        post.setTitle("Spring data JPA 언제 보나...");

        Comment comment = new Comment();
        comment.setComment("빨리 보고 싶어요.");
        post.addComment(comment);

        Comment comment1 = new Comment();
        comment1.setComment("곧 보여드릴게요.");
        post.addComment(comment1);

        Session session1 = entityManager.unwrap(Session.class);
        session1.save(post);
    }
}
