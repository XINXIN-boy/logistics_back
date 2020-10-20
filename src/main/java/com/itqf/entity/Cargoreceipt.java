package com.itqf.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

public class Cargoreceipt {

  private String goodsRevertBillCode;
  private String acceptStation;
  private double allCarriage;
  @JsonFormat(timezone = "GMT+8", shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private java.sql.Date arriveTime;
  private String backBillState;
  private String carriageBanlanceMode;
  private String carriageMode;
  private double carryGoodsBillDeposit;
  private double carryGoodsInsurance;
  private String dealGoodsStation;
  private double dispatchServiceFee;
  private String driverId;
  private String ifBalance;
  private double insurance;
  private String linkmanPhone;
  private String loadStation;
  private String receiveGoodsDetailAddr;
  private String receiveGoodsLinkman;
  private String remark;
  @JsonFormat(timezone = "GMT+8", shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private java.sql.Date signTime;
  private double startAdvance;
  @JsonFormat(timezone = "GMT+8", shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private java.sql.Date startCarryTime;


  public String getGoodsRevertBillCode() {
    return goodsRevertBillCode;
  }

  public void setGoodsRevertBillCode(String goodsRevertBillCode) {
    this.goodsRevertBillCode = goodsRevertBillCode;
  }


  public String getAcceptStation() {
    return acceptStation;
  }

  public void setAcceptStation(String acceptStation) {
    this.acceptStation = acceptStation;
  }


  public double getAllCarriage() {
    return allCarriage;
  }

  public void setAllCarriage(double allCarriage) {
    this.allCarriage = allCarriage;
  }


  public java.sql.Date getArriveTime() {
    return arriveTime;
  }

  public void setArriveTime(java.sql.Date arriveTime) {
    this.arriveTime = arriveTime;
  }


  public String getBackBillState() {
    return backBillState;
  }

  public void setBackBillState(String backBillState) {
    this.backBillState = backBillState;
  }


  public String getCarriageBanlanceMode() {
    return carriageBanlanceMode;
  }

  public void setCarriageBanlanceMode(String carriageBanlanceMode) {
    this.carriageBanlanceMode = carriageBanlanceMode;
  }


  public String getCarriageMode() {
    return carriageMode;
  }

  public void setCarriageMode(String carriageMode) {
    this.carriageMode = carriageMode;
  }


  public double getCarryGoodsBillDeposit() {
    return carryGoodsBillDeposit;
  }

  public void setCarryGoodsBillDeposit(double carryGoodsBillDeposit) {
    this.carryGoodsBillDeposit = carryGoodsBillDeposit;
  }


  public double getCarryGoodsInsurance() {
    return carryGoodsInsurance;
  }

  public void setCarryGoodsInsurance(double carryGoodsInsurance) {
    this.carryGoodsInsurance = carryGoodsInsurance;
  }


  public String getDealGoodsStation() {
    return dealGoodsStation;
  }

  public void setDealGoodsStation(String dealGoodsStation) {
    this.dealGoodsStation = dealGoodsStation;
  }


  public double getDispatchServiceFee() {
    return dispatchServiceFee;
  }

  public void setDispatchServiceFee(double dispatchServiceFee) {
    this.dispatchServiceFee = dispatchServiceFee;
  }


  public String getDriverId() {
    return driverId;
  }

  public void setDriverId(String driverId) {
    this.driverId = driverId;
  }


  public String getIfBalance() {
    return ifBalance;
  }

  public void setIfBalance(String ifBalance) {
    this.ifBalance = ifBalance;
  }


  public double getInsurance() {
    return insurance;
  }

  public void setInsurance(double insurance) {
    this.insurance = insurance;
  }


  public String getLinkmanPhone() {
    return linkmanPhone;
  }

  public void setLinkmanPhone(String linkmanPhone) {
    this.linkmanPhone = linkmanPhone;
  }


  public String getLoadStation() {
    return loadStation;
  }

  public void setLoadStation(String loadStation) {
    this.loadStation = loadStation;
  }


  public String getReceiveGoodsDetailAddr() {
    return receiveGoodsDetailAddr;
  }

  public void setReceiveGoodsDetailAddr(String receiveGoodsDetailAddr) {
    this.receiveGoodsDetailAddr = receiveGoodsDetailAddr;
  }


  public String getReceiveGoodsLinkman() {
    return receiveGoodsLinkman;
  }

  public void setReceiveGoodsLinkman(String receiveGoodsLinkman) {
    this.receiveGoodsLinkman = receiveGoodsLinkman;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }


  public java.sql.Date getSignTime() {
    return signTime;
  }

  public void setSignTime(java.sql.Date signTime) {
    this.signTime = signTime;
  }


  public double getStartAdvance() {
    return startAdvance;
  }

  public void setStartAdvance(double startAdvance) {
    this.startAdvance = startAdvance;
  }


  public java.sql.Date getStartCarryTime() {
    return startCarryTime;
  }

  public void setStartCarryTime(java.sql.Date startCarryTime) {
    this.startCarryTime = startCarryTime;
  }

}
