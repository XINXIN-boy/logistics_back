package com.itqf.entity;


public class Customerreceiptinfo {

  private int id;
  private int carryBillEventId;
  private String checkGoodsRecord;
  private String customer;
  private String goodsBillCode;
  private java.sql.Date receiveGoodsDate;
  private String receiveGoodsPerson;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public int getCarryBillEventId() {
    return carryBillEventId;
  }

  public void setCarryBillEventId(int carryBillEventId) {
    this.carryBillEventId = carryBillEventId;
  }


  public String getCheckGoodsRecord() {
    return checkGoodsRecord;
  }

  public void setCheckGoodsRecord(String checkGoodsRecord) {
    this.checkGoodsRecord = checkGoodsRecord;
  }


  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }


  public String getGoodsBillCode() {
    return goodsBillCode;
  }

  public void setGoodsBillCode(String goodsBillCode) {
    this.goodsBillCode = goodsBillCode;
  }


  public java.sql.Date getReceiveGoodsDate() {
    return receiveGoodsDate;
  }

  public void setReceiveGoodsDate(java.sql.Date receiveGoodsDate) {
    this.receiveGoodsDate = receiveGoodsDate;
  }


  public String getReceiveGoodsPerson() {
    return receiveGoodsPerson;
  }

  public void setReceiveGoodsPerson(String receiveGoodsPerson) {
    this.receiveGoodsPerson = receiveGoodsPerson;
  }

}
