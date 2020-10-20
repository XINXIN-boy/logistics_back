package com.itqf.dao;

import com.itqf.entity.Transfercominfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/1718:53
 * description:
 */
@Repository
public interface TransferComInfoDao {


    void addTransferconinfo(Transfercominfo transfercominfo);

    List<Transfercominfo> findByPage();


    Transfercominfo findById(String id);
}
