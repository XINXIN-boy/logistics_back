package com.itqf.dao;

import com.itqf.entity.Customerinfo;
import com.itqf.entity.Customerreceiptinfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/619:56
 * description:
 */
@Repository
public interface CustomerDao {

    int insertCustomer(Customerinfo customerinfo);

    List<Customerinfo> findAll();

    int deleteCustomer(String customerCode);

    int updateCustomerInfo(Customerinfo customerinfo);

    Customerinfo findCustomerByCode(String customerCode);

    int insertCustomerReceiptInfo(Customerreceiptinfo customerReceiptInfo);

}
