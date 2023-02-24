package net.seniorsteps.senior.spring.dal;

import net.seniorsteps.senior.spring.dal.entity.City;
import net.seniorsteps.senior.spring.dal.repo.CityRepo;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mostafa.Gazzar
 */
@Component
public class TestCityRepo {

    @Transactional
    public void addCity(ApplicationContext appCon) {
        try {
            CityRepo cityRepo = appCon.getBean("cityRepoImpl", CityRepo.class);
            System.out.println("Interface correct");
            City city = new City("Spring 2 Ar", "Spring 2 En");
            City returnedCity = cityRepo.add(city);
            System.out.println("ADDED | " + returnedCity.getId());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println("END");
    }
}
