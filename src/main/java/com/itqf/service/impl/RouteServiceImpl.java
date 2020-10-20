package com.itqf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itqf.commen.JsonMessage;
import com.itqf.dao.RouteDao;
import com.itqf.entity.Cityexpand;
import com.itqf.entity.Region;
import com.itqf.entity.Routeinfo;
import com.itqf.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springfox.documentation.spring.web.json.Json;

import java.util.ArrayList;
import java.util.List;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/716:16
 * description:
 */
@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteDao routeDao ;

    @Transactional
    @Override
    public void insertCityexpand(Cityexpand cityexpand) {
        String rangeCity = cityexpand.getRangeCity();
        String[] split = rangeCity.split(",");
        ArrayList<Integer> endCityIds = new ArrayList<>();

        for (String s : split) {
            endCityIds.add(Integer.parseInt(s));
        }
        long startCityId = cityexpand.getCityId();

        for (Integer endCityId : endCityIds) {
            if(routeDao.findRouteInfoByStartStationAndEndStation(startCityId, endCityId) == null){
                Routeinfo routeinfo = new Routeinfo();

                routeinfo.setStartStation(startCityId);
                routeinfo.setEndStation(endCityId);
                routeinfo.setDistance(100);
                routeinfo.setFetchTime(20);

                routeDao.insertRouteinfo(routeinfo);
            }
        }


        int rows =  routeDao.insertCityexpand(cityexpand);

        if (rows> 0){
            //success
        }else {
            throw new RuntimeException("添加失败");
        }

    }


    @Override
    public List<Region> findAllRegions() {
       List<Region> list = routeDao.findAllRegions();
        return list ;
    }

    @Override
    public JsonMessage findAllExpands(int page , int limit) {
        if (page == 0){
            page = 1 ;
        }
        if (limit == 0){
            limit = 10 ;
        }
        JsonMessage jsonMessage = new JsonMessage();

        PageHelper.startPage(page, limit) ;

        List<Cityexpand> list = routeDao.findAllExpands();

        if (list != null && list.size()>0) {
            jsonMessage.setData(list);
            jsonMessage.setMsg("查询成功");
            jsonMessage.setCode(0);
            jsonMessage.setCount(((Page)list).getTotal());
        }else {
            jsonMessage.setMsg("未查询到数据");
            jsonMessage.setCode(1);
        }
        return jsonMessage ;
    }

    @Override
    public List<Region> findLeftRegions() {
        List<Region> list = routeDao.findLeftRegions();
        return list ;
    }

    @Override
    public List<Routeinfo> findAll() {
        List<Routeinfo> list = routeDao.findAll();
        return list ;

    }
    @Transactional
    @Override
    public void updateCityexpand(Cityexpand cityexpand) {
        int rows =  routeDao.updateCityexpand(cityexpand);

        if (rows> 0){
            //success
        }else {
            throw new RuntimeException("修改失败");
        }
    }

    @Override
    public Cityexpand findExpand(int id) {
        Cityexpand cityexpand =  routeDao.findExpand(id);

            return cityexpand ;

    }
    @Transactional
    @Override
    public void deleteRegions(int id) {
        int rows =  routeDao.deleteRegions(id);

        if (rows> 0){
            //success
        }else {
            throw new RuntimeException("删除失败");
        }
    }
}
