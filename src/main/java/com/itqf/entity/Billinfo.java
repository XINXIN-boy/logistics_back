package com.itqf.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

public class Billinfo {

  private long id;
  private String acceptStation;
  private String billCode;
  private String billState;
  private String billType;
  @JsonFormat(timezone = "GMT+8", shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private java.sql.Timestamp writeDate;


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


  public String getBillState() {
    return billState;
  }

  public void setBillState(String billState) {
    this.billState = billState;
  }


  public String getBillType() {
    return billType;
  }

  public void setBillType(String billType) {
    this.billType = billType;
  }


  public java.sql.Timestamp getWriteDate() {
    return writeDate;
  }

  public void setWriteDate(java.sql.Timestamp writeDate) {
    this.writeDate = writeDate;
  }

}
