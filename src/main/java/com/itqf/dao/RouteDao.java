package com.itqf.dao;

import com.itqf.entity.Cityexpand;
import com.itqf.entity.Region;
import com.itqf.entity.Routeinfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/716:18
 * description:
 */
@Repository
public interface RouteDao {

    int insertCityexpand(Cityexpand cityexpand);

    void insertRouteinfo(Routeinfo routeinfo);

    int deleteRegions(int id);

    int updateCityexpand(Cityexpand cityexpand);

    List<Region> findAllRegions();

    List<Cityexpand> findAllExpands();

    List<Region> findLeftRegions();

    List<Routeinfo> findAll();

    List<Routeinfo> findRouteInfoByStartStationAndEndStation(@Param("startStation") long startStation,@Param("endStation") long endStation);

    Cityexpand findExpand(int id);

    Region findRegionByCity(String city);

    Region findRegionById(int id);

}
