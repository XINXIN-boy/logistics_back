package com.itqf.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.context.annotation.Bean;

public class Goodsbill {

  private String goodsBillCode;
  private String acceptProcedureRate;
  private String acceptStation;
  private double carriage;
  private double carryGoodsFee;
  private String employeeCode;
  @JsonFormat(timezone = "GMT+8", shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private java.sql.Date factDealDate;
  private String fetchGoodsMode;
  private double helpAcceptPayment;
  private boolean ifAudit;
  private boolean ifSettleAccounts;
  private double insurance;
  private double moneyOfChangePay;
  private double payKickback;
  private String payMode;
  @JsonFormat(timezone = "GMT+8", shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private java.sql.Date predeliveryDate;
  private String receiveGoodsAddr;
  private String receiveGoodsCustomer;
  private String receiveGoodsCustomerAddr;
  private String receiveGoodsCustomerCode;
  private String receiveGoodsCustomerTel;
  private double reduceFund;
  private String remark;
  private String sendGoodsAddr;
  private String sendGoodsCustomer;
  private String sendGoodsCustomerAddr;
  private String sendGoodsCustomerNo;
  private String sendGoodsCustomerTel;
  @JsonFormat(timezone = "GMT+8", shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private java.sql.Date sendGoodsDate;
  private double transferFee;
  private String transferStation;
  private boolean validity;
  private String writeBillPerson;
  private java.sql.Date writeDate;


  public String getGoodsBillCode() {
    return goodsBillCode;
  }

  public void setGoodsBillCode(String goodsBillCode) {
    this.goodsBillCode = goodsBillCode;
  }


  public String getAcceptProcedureRate() {
    return acceptProcedureRate;
  }

  public void setAcceptProcedureRate(String acceptProcedureRate) {
    this.acceptProcedureRate = acceptProcedureRate;
  }


  public String getAcceptStation() {
    return acceptStation;
  }

  public void setAcceptStation(String acceptStation) {
    this.acceptStation = acceptStation;
  }


  public double getCarriage() {
    return carriage;
  }

  public void setCarriage(double carriage) {
    this.carriage = carriage;
  }


  public double getCarryGoodsFee() {
    return carryGoodsFee;
  }

  public void setCarryGoodsFee(double carryGoodsFee) {
    this.carryGoodsFee = carryGoodsFee;
  }


  public String getEmployeeCode() {
    return employeeCode;
  }

  public void setEmployeeCode(String employeeCode) {
    this.employeeCode = employeeCode;
  }


  public java.sql.Date getFactDealDate() {
    return factDealDate;
  }

  public void setFactDealDate(java.sql.Date factDealDate) {
    this.factDealDate = factDealDate;
  }


  public String getFetchGoodsMode() {
    return fetchGoodsMode;
  }

  public void setFetchGoodsMode(String fetchGoodsMode) {
    this.fetchGoodsMode = fetchGoodsMode;
  }


  public double getHelpAcceptPayment() {
    return helpAcceptPayment;
  }

  public void setHelpAcceptPayment(double helpAcceptPayment) {
    this.helpAcceptPayment = helpAcceptPayment;
  }


  public boolean isIfSettleAccounts() {
    return ifSettleAccounts;
  }

  public void setIfSettleAccounts(boolean ifSettleAccounts) {
    this.ifSettleAccounts = ifSettleAccounts;
  }

  public double getInsurance() {
    return insurance;
  }

  public void setInsurance(double insurance) {
    this.insurance = insurance;
  }


  public double getMoneyOfChangePay() {
    return moneyOfChangePay;
  }

  public void setMoneyOfChangePay(double moneyOfChangePay) {
    this.moneyOfChangePay = moneyOfChangePay;
  }


  public double getPayKickback() {
    return payKickback;
  }

  public void setPayKickback(double payKickback) {
    this.payKickback = payKickback;
  }


  public String getPayMode() {
    return payMode;
  }

  public void setPayMode(String payMode) {
    this.payMode = payMode;
  }


  public java.sql.Date getPredeliveryDate() {
    return predeliveryDate;
  }

  public void setPredeliveryDate(java.sql.Date predeliveryDate) {
    this.predeliveryDate = predeliveryDate;
  }


  public String getReceiveGoodsAddr() {
    return receiveGoodsAddr;
  }

  public void setReceiveGoodsAddr(String receiveGoodsAddr) {
    this.receiveGoodsAddr = receiveGoodsAddr;
  }


  public String getReceiveGoodsCustomer() {
    return receiveGoodsCustomer;
  }

  public void setReceiveGoodsCustomer(String receiveGoodsCustomer) {
    this.receiveGoodsCustomer = receiveGoodsCustomer;
  }


  public String getReceiveGoodsCustomerAddr() {
    return receiveGoodsCustomerAddr;
  }

  public void setReceiveGoodsCustomerAddr(String receiveGoodsCustomerAddr) {
    this.receiveGoodsCustomerAddr = receiveGoodsCustomerAddr;
  }


  public String getReceiveGoodsCustomerCode() {
    return receiveGoodsCustomerCode;
  }

  public void setReceiveGoodsCustomerCode(String receiveGoodsCustomerCode) {
    this.receiveGoodsCustomerCode = receiveGoodsCustomerCode;
  }


  public String getReceiveGoodsCustomerTel() {
    return receiveGoodsCustomerTel;
  }

  public void setReceiveGoodsCustomerTel(String receiveGoodsCustomerTel) {
    this.receiveGoodsCustomerTel = receiveGoodsCustomerTel;
  }


  public double getReduceFund() {
    return reduceFund;
  }

  public void setReduceFund(double reduceFund) {
    this.reduceFund = reduceFund;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }


  public String getSendGoodsAddr() {
    return sendGoodsAddr;
  }

  public void setSendGoodsAddr(String sendGoodsAddr) {
    this.sendGoodsAddr = sendGoodsAddr;
  }


  public String getSendGoodsCustomer() {
    return sendGoodsCustomer;
  }

  public void setSendGoodsCustomer(String sendGoodsCustomer) {
    this.sendGoodsCustomer = sendGoodsCustomer;
  }


  public String getSendGoodsCustomerAddr() {
    return sendGoodsCustomerAddr;
  }

  public void setSendGoodsCustomerAddr(String sendGoodsCustomerAddr) {
    this.sendGoodsCustomerAddr = sendGoodsCustomerAddr;
  }


  public String getSendGoodsCustomerNo() {
    return sendGoodsCustomerNo;
  }

  public void setSendGoodsCustomerNo(String sendGoodsCustomerNo) {
    this.sendGoodsCustomerNo = sendGoodsCustomerNo;
  }


  public String getSendGoodsCustomerTel() {
    return sendGoodsCustomerTel;
  }

  public void setSendGoodsCustomerTel(String sendGoodsCustomerTel) {
    this.sendGoodsCustomerTel = sendGoodsCustomerTel;
  }


  public java.sql.Date getSendGoodsDate() {
    return sendGoodsDate;
  }

  public void setSendGoodsDate(java.sql.Date sendGoodsDate) {
    this.sendGoodsDate = sendGoodsDate;
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


  public boolean isIfAudit() {
    return ifAudit;
  }

  public void setIfAudit(boolean ifAudit) {
    this.ifAudit = ifAudit;
  }

  public boolean isValidity() {
    return validity;
  }

  public void setValidity(boolean validity) {
    this.validity = validity;
  }

  public String getWriteBillPerson() {
    return writeBillPerson;
  }

  public void setWriteBillPerson(String writeBillPerson) {
    this.writeBillPerson = writeBillPerson;
  }


  public java.sql.Date getWriteDate() {
    return writeDate;
  }

  public void setWriteDate(java.sql.Date writeDate) {
    this.writeDate = writeDate;
  }

}
