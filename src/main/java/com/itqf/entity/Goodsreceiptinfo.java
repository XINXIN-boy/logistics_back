package com.itqf.entity;


public class Goodsreceiptinfo {

  private long id;
  private String checkGoodsRecord;
  private String driverName;
  private String goodsRevertCode;
  private java.sql.Date rceiveGoodsDate;
  private String receiveGoodsPerson;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getCheckGoodsRecord() {
    return checkGoodsRecord;
  }

  public void setCheckGoodsRecord(String checkGoodsRecord) {
    this.checkGoodsRecord = checkGoodsRecord;
  }


  public String getDriverName() {
    return driverName;
  }

  public void setDriverName(String driverName) {
    this.driverName = driverName;
  }


  public String getGoodsRevertCode() {
    return goodsRevertCode;
  }

  public void setGoodsRevertCode(String goodsRevertCode) {
    this.goodsRevertCode = goodsRevertCode;
  }


  public java.sql.Date getRceiveGoodsDate() {
    return rceiveGoodsDate;
  }

  public void setRceiveGoodsDate(java.sql.Date rceiveGoodsDate) {
    this.rceiveGoodsDate = rceiveGoodsDate;
  }


  public String getReceiveGoodsPerson() {
    return receiveGoodsPerson;
  }

  public void setReceiveGoodsPerson(String receiveGoodsPerson) {
    this.receiveGoodsPerson = receiveGoodsPerson;
  }

}
