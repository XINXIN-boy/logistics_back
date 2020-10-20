package com.itqf.entity;


public class Cargoreceiptdetail {

  private String goodsRevertBillId;
  private String goodsBillDetailId;
  private double goodsValue;
  private long pieceAmount;
  private String priceMode;
  private String priceStandard;
  private double volume;
  private double weight;


  public String getGoodsRevertBillId() {
    return goodsRevertBillId;
  }

  public void setGoodsRevertBillId(String goodsRevertBillId) {
    this.goodsRevertBillId = goodsRevertBillId;
  }


  public String getGoodsBillDetailId() {
    return goodsBillDetailId;
  }

  public void setGoodsBillDetailId(String goodsBillDetailId) {
    this.goodsBillDetailId = goodsBillDetailId;
  }


  public double getGoodsValue() {
    return goodsValue;
  }

  public void setGoodsValue(double goodsValue) {
    this.goodsValue = goodsValue;
  }


  public long getPieceAmount() {
    return pieceAmount;
  }

  public void setPieceAmount(long pieceAmount) {
    this.pieceAmount = pieceAmount;
  }


  public String getPriceMode() {
    return priceMode;
  }

  public void setPriceMode(String priceMode) {
    this.priceMode = priceMode;
  }


  public String getPriceStandard() {
    return priceStandard;
  }

  public void setPriceStandard(String priceStandard) {
    this.priceStandard = priceStandard;
  }


  public double getVolume() {
    return volume;
  }

  public void setVolume(double volume) {
    this.volume = volume;
  }


  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

}
