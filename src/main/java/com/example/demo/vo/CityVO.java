package com.example.demo.vo;

import com.example.demo.entity.City;

/**
 * Created by kewuwei on 2017/6/9.
 */
public class CityVO {

    private Integer id;             //城市id

    private Integer provinceId;     //所属省id

    private String cityName;        //城市名称

    private String description;     //城市描述

    public CityVO() {

    }

    public CityVO(City city) {
        this.id = city.getId();
        this.provinceId = city.getProvinceId();
        this.cityName = city.getCityName();
        this.description = city.getDescription();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
