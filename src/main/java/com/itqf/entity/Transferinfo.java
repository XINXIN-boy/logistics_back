package com.itqf.entity;


public class Transferinfo {

  private int id;
  private String afterTransferBill;
  private java.sql.Date checkTime;
  private String description;
  private String goodsBillCode;
  private String transferAddr;
  private String transferCheck;
  private String transferCompany;
  private double transferFee;
  private String transferStation;
  private String transferStationTel;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getAfterTransferBill() {
    return afterTransferBill;
  }

  public void setAfterTransferBill(String afterTransferBill) {
    this.afterTransferBill = afterTransferBill;
  }


  public java.sql.Date getCheckTime() {
    return checkTime;
  }

  public void setCheckTime(java.sql.Date checkTime) {
    this.checkTime = checkTime;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public String getGoodsBillCode() {
    return goodsBillCode;
  }

  public void setGoodsBillCode(String goodsBillCode) {
    this.goodsBillCode = goodsBillCode;
  }


  public String getTransferAddr() {
    return transferAddr;
  }

  public void setTransferAddr(String transferAddr) {
    this.transferAddr = transferAddr;
  }


  public String getTransferCheck() {
    return transferCheck;
  }

  public void setTransferCheck(String transferCheck) {
    this.transferCheck = transferCheck;
  }


  public String getTransferCompany() {
    return transferCompany;
  }

  public void setTransferCompany(String transferCompany) {
    this.transferCompany = transferCompany;
  }


  public double getTransferFee() {
    return transferFee;
  }

  public void setTransferFee(double transferFee) {
    this.transferFee = transferFee;
  }


  public String getTransferStation() {
    return transferStation;
  }

  public void setTransferStation(String transferStation) {
    this.transferStation = transferStation;
  }


  public String getTransferStationTel() {
    return transferStationTel;
  }

  public void setTransferStationTel(String transferStationTel) {
    this.transferStationTel = transferStationTel;
  }

}
