package com.example.demo.service;

import com.example.demo.vo.CityVO;

import java.util.List;

/**
 * Created by kewuwei on 2017/6/6.
 */
public interface ICityService {

    boolean insertCity(int provinceId,String cityName,String description);

    boolean dropCity(int id);

    boolean updateCity(int id,int provinceId,String cityName,String description);

    List<CityVO> selectCity(String cityName);

}
