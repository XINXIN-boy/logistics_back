package com.itqf.service;

import com.itqf.commen.JsonMessage;
import com.itqf.entity.Driverinfo;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/621:51
 * description:
 */
public interface DriverService {
    void insertDriver(Driverinfo driverinfo);

    JsonMessage findAll(int page, int limit);

    void deleteDriver(String id);

    JsonMessage findDriverByCode(String id);

    void updateDriver(Driverinfo driverinfo);

}
