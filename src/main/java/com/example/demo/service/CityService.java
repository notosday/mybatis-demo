package com.example.demo.service;

import com.example.demo.dao.CityDao;
import com.example.demo.entity.City;
import com.example.demo.vo.CityVO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kewuwei on 2017/6/6.
 */
@Service(value = "cityService")
public class CityService implements ICityService {

    Log log = LogFactory.getLog(CityService.class);

    @Autowired
    private CityDao cityDao;

    /**
     * 新增城市
     * @param provinceId 所属省id
     * @param cityName 城市名称
     * @param description 城市描述
     * @return 是否新增成功
     */
    @Override
    public boolean insertCity(int provinceId, String cityName, String description) {

        try {
            return cityDao.insertCity(provinceId,cityName,description);
        } catch (Exception e) {
            log.error("insertCity error : ",e);
            return false;
        }
    }

    /**
     * 查询城市
     * @param cityName 城市名称
     * @return 城市列表
     */
    @Override
    public List<CityVO> selectCity(String cityName) {

        try {
            List<City> cities = cityDao.selectCity(cityName);

            ArrayList<CityVO> cityVOs = new ArrayList<>();

            for (City city:cities) {
                CityVO cityVO = new CityVO(city);
                cityVOs.add(cityVO);
            }

            return cityVOs;
        } catch (Exception e) {
            log.error("select City error : ",e);
            return null;
        }


    }

    /**
     * 修改城市信息
     * @param id 城市id
     * @param provinceId 所属省id
     * @param cityName 城市名称
     * @param description 城市描述
     * @return 是否修改成功
     */
    @Override
    public boolean updateCity(int id, int provinceId, String cityName, String description) {

        try {
            return cityDao.updateCity(id,provinceId,cityName,description);
        } catch (Exception e) {
            log.error("updateCity error : ",e);
            return false;
        }
    }


    /**
     * 删除城市
     * @param id 城市id
     * @return 是否删除成功
     */
    @Override
    public boolean dropCity(int id) {

        try {
            return cityDao.dropCity(id);
        } catch (Exception e) {
            log.error("dropCity : ",e);
            return false;
        }
    }
}
