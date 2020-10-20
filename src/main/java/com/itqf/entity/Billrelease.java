package com.itqf.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

public class Billrelease {

  private long id;
  private String acceptStation;
  private String billCode;
  private String billType;
  private String receiveBillPerson;
  @JsonFormat(timezone = "GMT+8", shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private java.sql.Date receiveBillTime;
  private String releasePerson;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getAcceptStation() {
    return acceptStation;
  }

  public void setAcceptStation(String acceptStation) {
    this.acceptStation = acceptStation;
  }


  public String getBillCode() {
    return billCode;
  }

  public void setBillCode(String billCode) {
    this.billCode = billCode;
  }


  public String getBillType() {
    return billType;
  }

  public void setBillType(String billType) {
    this.billType = billType;
  }


  public String getReceiveBillPerson() {
    return receiveBillPerson;
  }

  public void setReceiveBillPerson(String receiveBillPerson) {
    this.receiveBillPerson = receiveBillPerson;
  }


  public java.sql.Date getReceiveBillTime() {
    return receiveBillTime;
  }

  public void setReceiveBillTime(java.sql.Date receiveBillTime) {
    this.receiveBillTime = receiveBillTime;
  }


  public String getReleasePerson() {
    return releasePerson;
  }

  public void setReleasePerson(String releasePerson) {
    this.releasePerson = releasePerson;
  }

}
