package com.example.demo.controller;

import com.example.demo.vo.CityVO;
import com.example.demo.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by kewuwei on 2017/6/6.
 */
@Controller
public class CityController {

   @Autowired
   @Qualifier("cityService")
    private ICityService iCityService;

    /**
     * 首页
     * @return 欢迎界面
     */
    @RequestMapping("/")
    String index(Model model){
        return "index";
    }

    /**
     * 城市列表
     * @param model model
     * @return 城市列表页面
     */
    @RequestMapping("cityList")
    String table(Model model){
        List<CityVO> cities = iCityService.selectCity(null);
        model.addAttribute("cities",cities);
        return "table";
    }

    /**
     * 查询城市信息
     * @param cityName 城市名称
     * @param model model
     * @return 城市信息页面
     */
    @RequestMapping(value = "/cityList/query", method = RequestMethod.GET)
    String query(String cityName,Model model){
        List<CityVO> cities = iCityService.selectCity(cityName);
        model.addAttribute("cities",cities);
        return "queryCity";
    }

    /**
     * 新增城市
     * @param cityName 城市名称
     * @param provinceId 所属省编号
     * @param description 城市描述
     * @return 城市列表页面
     */
    @RequestMapping(value = "/city/add",method = RequestMethod.POST)
    @ResponseBody
    boolean add(String cityName,int provinceId, String description){
        return  iCityService.insertCity(provinceId,cityName,description);
    }

    /**
     * 删除城市
     * @param id 城市id
     * @return 是否删除成功
     */
    @RequestMapping(value = "/city/drop", method = RequestMethod.POST)
    @ResponseBody
    boolean drop(int id) {
        return iCityService.dropCity(id);
    }

    /**
     * 修改城市信息
     * @param id 城市id
     * @param provinceId 所属省编号
     * @param cityName 城市名称
     * @param description 城市描述
     * @return 是否修改成功
     */
    @RequestMapping(value = "/city/update",method = RequestMethod.POST)
    @ResponseBody
    boolean update(int id,int provinceId,String cityName,String description) {
        return iCityService.updateCity(id,provinceId,cityName,description);
    }
}
