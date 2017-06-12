package com.example.demo.dao;

import com.example.demo.entity.City;
import com.example.demo.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by kewuwei on 2017/6/7.
 */
@Repository(value = "cityDao")
public class CityDao implements ICityDao {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public boolean insertCity(int provinceId, String cityName, String description) {

        return cityMapper.insertCity(provinceId,cityName,description);

    }

    @Override
    public boolean dropCity(int id) {

        return cityMapper.dropCity(id);

    }

    @Override
    public boolean updateCity(int id, int provinceId, String cityName, String description) {

        return cityMapper.updateCity(id,provinceId,cityName,description);

    }

    @Override
    public List<City> selectCity(String cityName) {

        if(StringUtils.isEmpty(cityName))
            return cityMapper.selectAll();
        else
            return cityMapper.selectCity(cityName);

    }
}
