package com.company.parsingxml.entity;

import java.time.LocalDate;

public class Mobile extends Tariffs{
    private double smsPrice;
    private String mobileType;

    public Mobile(){};

    public Mobile(String id, String name, String operatorName, LocalDate contractDate, String contractorName,
                  String passport, int payroll, int connectionPrice, String favoriteNumber, String tariffication, double tarifficationPrice, double smsPrice, String mobileType) {
        super(id, name, operatorName, contractDate, contractorName, passport, payroll,
                connectionPrice, favoriteNumber, tariffication, tarifficationPrice);
        this.smsPrice = smsPrice;
        this.mobileType = mobileType;
    }

    public void setMobileType(String mobileType) {
        this.mobileType = mobileType;
    }


    public void setSmsPrice(double smsPrice) {
        this.smsPrice = smsPrice;
    }


    public double getSmsPrice() {
        return smsPrice;
    }

    public String getMobileType() {
        return mobileType;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb .append(super.toString());
        sb.append("sms price:").append(smsPrice).append("\n");
        sb.append("mobile type:").append(mobileType).append("\n");
        return sb.toString();
    }


}
