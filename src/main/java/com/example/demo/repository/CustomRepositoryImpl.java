package com.example.demo.repository;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by kewuwei on 2017/6/12.
 */
public class CustomRepositoryImpl<T,ID extends Serializable> extends SimpleJpaRepository<T,ID> implements CustomRepository<T,ID> {

    private final EntityManager entityManager;

    public CustomRepositoryImpl(Class domainClass, EntityManager em) {
        super(domainClass, em);
        this.entityManager = em;
    }

    @Override
    public void doSomeThing() {

    }
}
