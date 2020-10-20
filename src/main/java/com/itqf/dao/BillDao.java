package com.itqf.dao;

import com.itqf.entity.Billinfo;
import com.itqf.entity.Billrelease;
import com.itqf.entity.Goodsbillevent;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/810:42
 * description:
 */
@Repository
public interface BillDao {
    void insertBillinfo(Billinfo billinfo);

    int insertRelease(Billrelease billRelease);

    int  updateBillInfo(Billinfo billinfo) ;

    List<Billinfo> findAll();

    List<Billinfo> findNotRelease();

    Billinfo findBillInfoByBillCode(String billCode);
}
