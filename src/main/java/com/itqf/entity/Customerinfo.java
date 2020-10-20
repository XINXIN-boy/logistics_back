package com.itqf.entity;


public class Customerinfo {

  private String customerCode;
  private String address;
  private String customer;
  private String customerType;
  private String email;
  private String enterpriseProperty;
  private String enterpriseSize;
  private String fax;
  private String linkman;
  private String linkmanMobile;
  private String phone;
  private String postCode;

  @Override
  public String toString() {
    return "Customerinfo{" +
            "customerCode='" + customerCode + '\'' +
            ", address='" + address + '\'' +
            ", customer='" + customer + '\'' +
            ", customerType='" + customerType + '\'' +
            ", email='" + email + '\'' +
            ", enterpriseProperty='" + enterpriseProperty + '\'' +
            ", enterpriseSize='" + enterpriseSize + '\'' +
            ", fax='" + fax + '\'' +
            ", linkman='" + linkman + '\'' +
            ", linkmanMobile='" + linkmanMobile + '\'' +
            ", phone='" + phone + '\'' +
            ", postCode='" + postCode + '\'' +
            '}';
  }

  public String getCustomerCode() {
    return customerCode;
  }

  public void setCustomerCode(String customerCode) {
    this.customerCode = customerCode;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }


  public String getCustomerType() {
    return customerType;
  }

  public void setCustomerType(String customerType) {
    this.customerType = customerType;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getEnterpriseProperty() {
    return enterpriseProperty;
  }

  public void setEnterpriseProperty(String enterpriseProperty) {
    this.enterpriseProperty = enterpriseProperty;
  }


  public String getEnterpriseSize() {
    return enterpriseSize;
  }

  public void setEnterpriseSize(String enterpriseSize) {
    this.enterpriseSize = enterpriseSize;
  }


  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }


  public String getLinkman() {
    return linkman;
  }

  public void setLinkman(String linkman) {
    this.linkman = linkman;
  }


  public String getLinkmanMobile() {
    return linkmanMobile;
  }

  public void setLinkmanMobile(String linkmanMobile) {
    this.linkmanMobile = linkmanMobile;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getPostCode() {
    return postCode;
  }

  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }

}
