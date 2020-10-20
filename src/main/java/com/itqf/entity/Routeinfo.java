package com.itqf.entity;


public class Routeinfo {

  private long id;
  private double distance;
  private long endStation;
  private double fetchTime;
  private String passStation;
  private long startStation;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public double getDistance() {
    return distance;
  }

  public void setDistance(double distance) {
    this.distance = distance;
  }


  public long getEndStation() {
    return endStation;
  }

  public void setEndStation(long endStation) {
    this.endStation = endStation;
  }


  public double getFetchTime() {
    return fetchTime;
  }

  public void setFetchTime(double fetchTime) {
    this.fetchTime = fetchTime;
  }


  public String getPassStation() {
    return passStation;
  }

  public void setPassStation(String passStation) {
    this.passStation = passStation;
  }


  public long getStartStation() {
    return startStation;
  }

  public void setStartStation(long startStation) {
    this.startStation = startStation;
  }

}
