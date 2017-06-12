package com.example.demo.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * Created by kewuwei on 2017/6/12.
 */
@NoRepositoryBean
public interface CustomRepository<T,ID extends Serializable> extends PagingAndSortingRepository<T,ID> {

    public void doSomeThing();
}
