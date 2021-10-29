package com.company.entity;

public class Tariffs {
    private String id;
    private String name;
    private String operatorName;
    private int payroll;
    private int connectionPrice;
    private String favoriteNumber;
    private String tariffication;
    private double tarifficationPrice;

    public Tariffs(String id, String name, String operatorName, int payroll, int connectionPrice,
                   String favoriteNumber, String tariffication, double tarifficationPrice) {
        this.id = id;
        this.name = name;
        this.operatorName = operatorName;
        this.payroll = payroll;
        this.connectionPrice = connectionPrice;
        this.favoriteNumber = favoriteNumber;
        this.tariffication = tariffication;
        this.tarifficationPrice = tarifficationPrice;
    }

    public Tariffs(){}

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

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("id:").append(id).append("\n");
        sb.append("name:").append(name).append("\n");
        sb.append("operator name:").append(operatorName).append("\n");
        sb.append("payroll:").append(payroll).append("\n");
        sb.append("connection price:").append(connectionPrice).append("\n");
        sb.append("favorite number:").append(favoriteNumber).append("\n");
        sb.append("tariffication:").append(tariffication).append("\n");
        sb.append("tariffication price:").append(tarifficationPrice).append("\n");
        return sb.toString();
    }
}
