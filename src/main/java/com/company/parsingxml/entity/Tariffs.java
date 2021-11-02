package com.company.parsingxml.entity;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Tariffs {
    private String id;
    private String name;
    private String operatorName;
    private LocalDate contractDate;
    private String contractorName;
    private String passport;
    private int payroll;
    private int connectionPrice;
    private String favoriteNumber;
    private String tariffication;
    private double tarifficationPrice;



    public Tariffs(){}

    public Tariffs(String id, String name, String operatorName, LocalDate contractDate, String contractorName,
                   String passport, int payroll, int connectionPrice, String favoriteNumber, String tariffication, double tarifficationPrice) {
        this.id = id;
        this.name = name;
        this.operatorName = operatorName;
        this.contractDate = contractDate;
        this.contractorName = contractorName;
        this.passport = passport;
        this.payroll = payroll;
        this.connectionPrice = connectionPrice;
        this.favoriteNumber = favoriteNumber;
        this.tariffication = tariffication;
        this.tarifficationPrice = tarifficationPrice;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public int getPayroll() {
        return payroll;
    }

    public int getConnectionPrice() {
        return connectionPrice;
    }

    public String getFavoriteNumber() {
        return favoriteNumber;
    }

    public String getTariffication() {
        return tariffication;
    }

    public double getTarifficationPrice() {
        return tarifficationPrice;
    }

    public LocalDate getContractDate() {
        return contractDate;
    }

    public String getContractorName() {
        return contractorName;
    }

    public String getPassport() {
        return passport;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public void setPayroll(int payroll) {
        this.payroll = payroll;
    }

    public void setConnectionPrice(int connectionPrice) {
        this.connectionPrice = connectionPrice;
    }

    public void setFavoriteNumber(String favoriteNumber) {
        this.favoriteNumber = favoriteNumber;
    }

    public void setTariffication(String tariffication) {
        this.tariffication = tariffication;
    }

    public void setTarifficationPrice(double tarifficationPrice) {
        this.tarifficationPrice = tarifficationPrice;
    }

    public void setContractDate(LocalDate contractDate) {
        this.contractDate = contractDate;
    }

    public void setContractorName(String contractorName) {
        this.contractorName = contractorName;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("id:").append(id).append("\n");
        sb.append("name:").append(name).append("\n");
        sb.append("operator name:").append(operatorName).append("\n");
        sb.append("contract date:").append(contractDate).append("\n");
        sb.append("contractor name:").append(contractorName).append("\n");
        sb.append("passport:").append(passport).append("\n");
        sb.append("payroll:").append(payroll).append("\n");
        sb.append("connection price:").append(connectionPrice).append("\n");
        sb.append("favorite number:").append(favoriteNumber).append("\n");
        sb.append("tariffication:").append(tariffication).append("\n");
        sb.append("tariffication price:").append(tarifficationPrice).append("\n");
        return sb.toString();
    }
}
