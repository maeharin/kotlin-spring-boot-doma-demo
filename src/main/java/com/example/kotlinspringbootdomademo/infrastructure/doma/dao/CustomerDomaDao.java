package com.example.kotlinspringbootdomademo.infrastructure.doma.dao;

import com.example.kotlinspringbootdomademo.infrastructure.doma.entity.CustomerDomaEntity;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@ConfigAutowireable
@Dao
public interface CustomerDomaDao {
    @Select
    List<CustomerDomaEntity> selectAll();

    @Select
    CustomerDomaEntity selectById(int id);
}
