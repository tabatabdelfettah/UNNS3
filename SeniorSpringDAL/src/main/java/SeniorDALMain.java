/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.spring.dal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Senior Steps
 */
public class SeniorDALMain {
    // 1 ..... 0
    // 2 ..... pageSize
    // 3 .... 

    private static int getFirstResultRelativeToPageNumber(int pageNumber, int pageSize) {
        return (pageNumber - 1) * pageSize;
    }

    public static void main(String[] args) {
        ApplicationContext appCon = new ClassPathXmlApplicationContext("dal-spring-context.xml");
        TestCityRepo testDal = appCon.getBean("testDal", TestCityRepo.class);
        testDal.addCity(appCon);

    }
}
