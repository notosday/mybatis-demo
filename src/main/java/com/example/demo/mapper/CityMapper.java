package com.example.demo.mapper;

import com.example.demo.entity.City;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * MySQL CRUD
 * Created by kewuwei on 2017/6/6.
 */
@Mapper
@Component(value = "cityMapper")
public interface CityMapper {

    @Insert("insert into city ( province_id, city_name, description) values (#{provinceId}, #{cityName}, #{description})")
    boolean insertCity(@Param("provinceId") int provinceId, @Param("cityName") String cityName, @Param("description") String description);

    @Delete("delete from city where id = #{id} ")
    boolean dropCity(@Param("id") int id);

    @Update("update city set province_id = #{provinceId}, city_name = #{cityName}, description = #{description} where id = #{id}")
    boolean updateCity(@Param("id") int id, @Param("provinceId") int provinceId, @Param("cityName") String cityName, @Param("description") String description);

    @Select("select id,province_id as provinceId,city_name as cityName, description  from city where city_name = #{cityName}")
    List<City> selectCity(@Param("cityName") String cityName);

    @Select("select id,province_id as provinceId,city_name as cityName, description from city ")
    List<City> selectAll();
}
