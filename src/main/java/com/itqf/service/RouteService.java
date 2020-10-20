package com.itqf.service;

import com.itqf.commen.JsonMessage;
import com.itqf.entity.Cityexpand;
import com.itqf.entity.Region;
import com.itqf.entity.Routeinfo;

import java.util.List;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/716:16
 * description:
 */
public interface RouteService {
    List<Region> findAllRegions();

    JsonMessage findAllExpands(int page , int limit);

    void insertCityexpand(Cityexpand cityexpand);

    List<Region> findLeftRegions();


    List<Routeinfo> findAll();

    void updateCityexpand(Cityexpand cityexpand);

    Cityexpand findExpand(int id);

    void deleteRegions(int id);
}
