package com.itqf.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

public class Goodsbillevent {

  private String goodsBillId;
  private String eventName;
  @JsonFormat(timezone = "GMT+8", shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private java.sql.Timestamp occurTime;
  private String remark;


  public String getGoodsBillId() {
    return goodsBillId;
  }

  public void setGoodsBillId(String goodsBillId) {
    this.goodsBillId = goodsBillId;
  }


  public String getEventName() {
    return eventName;
  }

  public void setEventName(String eventName) {
    this.eventName = eventName;
  }


  public java.sql.Timestamp getOccurTime() {
    return occurTime;
  }

  public void setOccurTime(java.sql.Timestamp occurTime) {
    this.occurTime = occurTime;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

}
