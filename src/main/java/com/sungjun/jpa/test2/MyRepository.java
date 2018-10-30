package com.sungjun.jpa.test2;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface MyRepository<T, Id extends Serializable> extends Repository<T, Id> {

    <E extends T> E save(@NonNull E entity); // 파라매터에 적용

    List<T> findAll();

    @Nullable
    <E extends  T> Optional<E> fidById(Id id); // 메소드에 적용하면 메소드의 리턴값에 적용됨
}