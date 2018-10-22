package com.sungjun.jpa;

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
    EntityManager entityManager; // 가장 핵심적인 API ( hibernate에서는 Session이 가장 핵심적인 API )
    // Session session = entityManager.unwrap(Session.class);
    // session.save(account);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setUsername("gwonsungjun");
        account.setPassword("jpa");

        entityManager.persist(account);
    }
}
