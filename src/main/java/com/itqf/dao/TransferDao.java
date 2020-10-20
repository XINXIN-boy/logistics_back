package com.itqf.dao;

import com.itqf.entity.Transferinfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/1718:52
 * description:
 */
@Repository
public interface TransferDao {


    void addTransferinfo(Transferinfo transferinfo);

    List<Transferinfo> findInfoByPage();


}
