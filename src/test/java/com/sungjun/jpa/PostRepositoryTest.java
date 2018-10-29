package com.sungjun.jpa;

import com.sungjun.jpa.test2.Post;
import com.sungjun.jpa.test2.PostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest //@DataJpaTest : data access 만 Test, 따라서 Repository만 등록 됨, Test datasource h2용으로 설정됨.<dependncy 설정 필요>
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    @Rollback(false)
    public void crudRepository() {

        //Given
        Post post = new Post();
        post.setTitle("hello spring boot common");
        assertThat(post.getId()).isNull();

        //When
        Post newPost = postRepository.save(post);

        //Then
        assertThat(newPost.getId()).isNotNull();

        //When
        List<Post> posts = postRepository.findAll();

        //Then
        assertThat(posts.size()).isEqualTo(1);
        assertThat(posts).contains(newPost);

        //When
        Page<Post> page = postRepository.findAll(PageRequest.of(0, 10));

        //Then
        assertThat(page.getTotalElements()).isEqualTo(1);
        assertThat(page.getNumber()).isEqualTo(0);
        assertThat(page.getSize()).isEqualTo(10); // 요청했던 size
        assertThat(page.getNumberOfElements()).isEqualTo(1);

        //When
        page = postRepository.findByTitleContains("spring", PageRequest.of(0, 10));

        //Then
        assertThat(page.getTotalElements()).isEqualTo(1);
        assertThat(page.getNumber()).isEqualTo(0);
        assertThat(page.getSize()).isEqualTo(10); // 요청했던 size
        assertThat(page.getNumberOfElements()).isEqualTo(1);

    }
}
