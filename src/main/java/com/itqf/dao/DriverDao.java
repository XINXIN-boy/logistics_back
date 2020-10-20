package com.itqf.dao;

import com.itqf.entity.Driverinfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/621:56
 * description:
 */
@Repository
public interface DriverDao {

    int insertDriver(Driverinfo driverinfo);

    List<Driverinfo> findAll();

    int deleteDriver(String id);

    Driverinfo findDriverByCode(String id);

    int updateDriver(Driverinfo driverinfo);

}
