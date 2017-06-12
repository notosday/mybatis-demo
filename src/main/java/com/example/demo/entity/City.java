package com.example.demo.entity;

/**
 * 城市实体类
 * Created by kewuwei on 2017/6/6.
 */
public class City {

    private Integer id;             //城市id

    private Integer provinceId;     //所属省id

    private String cityName;        //城市名称

    private String description;     //城市描述

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
