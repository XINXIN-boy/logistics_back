package com.itqf.vo;

import java.util.Date;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/518:45
 * description:
 */
public class VoBill {
//    { title: 'ID', fixed: 'left', type: 'numbers', align: 'center' },
//    { field: 'billCode', title: '货运单编号', align: "center", sort: true },
//    { field: 'billState', title: '单据状态', align: "center", sort: true },
//    { field: 'writeDate', title: '填写日期', align: 'center', templet: '#createTime' },
//    { fixed: 'right', title:"操作", align: "center", toolbar: '#barDemo', width: 200 }
    private int id ;
    private String billCode ;
    private String billState ;
    private Date  writeDate ;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public String getBillState() {
        return billState;
    }

    public void setBillState(String billState) {
        this.billState = billState;
    }

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }
}
