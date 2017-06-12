package com.example.demo.dao;

import com.example.demo.entity.City;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by kewuwei on 2017/6/7.
 */
public interface ICityDao {

    boolean insertCity(int provinceId, String cityName,String description);

    boolean dropCity(int id);

    boolean updateCity(int id, int provinceId, String cityName, String description);

    List<City> selectCity(String cityName);

}
