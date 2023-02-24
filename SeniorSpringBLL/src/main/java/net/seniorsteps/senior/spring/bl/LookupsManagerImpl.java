/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.spring.bl;

import java.util.ArrayList;
import java.util.List;
import net.seniorsteps.senior.common.bean.CityBean;
import net.seniorsteps.senior.common.constant.SeniorConstant;
import net.seniorsteps.senior.spring.dal.entity.City;
import net.seniorsteps.senior.spring.dal.repo.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Senior Steps
 */
@Component
public class LookupsManagerImpl implements LookupsManager, SeniorConstant {

    @Autowired
    private CityTransformer cityTransformer;

    @Autowired
    private CityRepo cityRepo;

    @Override
    @Transactional
    public CityBean addCity(CityBean cityBean) {
        City cityEntity = cityTransformer.fromBeanToEntity(cityBean);
        cityEntity = cityRepo.add(cityEntity);
        CityBean resultCityBean = cityTransformer.fromEntityToBean(cityEntity, LANG_AR);
        return resultCityBean;
    }

    @Override
    @Transactional
    public List<CityBean> findCities() {
        List<City> citiesList = cityRepo.findList();
        List<CityBean> cityBeansList = new ArrayList<>();
        for (City iCity : citiesList) {
            CityBean iCityBean = cityTransformer.fromEntityToBean(iCity, LANG_AR);
            cityBeansList.add(iCityBean);
        }
        return cityBeansList;
    }

    @Override
    @Transactional
    public CityBean getCity(Integer id) {
        City foundCity = cityRepo.findById(id);
        CityBean cityBean = cityTransformer.fromEntityToBeanWithAreas(foundCity, LANG_EN);
        return cityBean;
    }

    // <editor-fold defaultstate="collapsed" desc="GETTERS & SETTERS">
    public CityTransformer getCityTransformer() {
        return cityTransformer;
    }

    public void setCityTransformer(CityTransformer cityTransformer) {
        this.cityTransformer = cityTransformer;
    }

    public CityRepo getCityRepo() {
        return cityRepo;
    }

    public void setCityRepo(CityRepo cityRepo) {
        this.cityRepo = cityRepo;
    }
    // </editor-fold>

}
