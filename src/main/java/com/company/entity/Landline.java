package com.company.entity;

public class Landline extends Tariffs{
    private String address;

    public Landline(String id, String name, String operatorName, int payroll, int connectionPrice,
                    String favoriteNumber, String tariffication, double tarifficationPrice, String address) {
        super(id, name, operatorName, payroll, connectionPrice, favoriteNumber, tariffication, tarifficationPrice);
        this.address = address;
    }

    public Landline(){}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append(super.toString());
        sb.append("address:").append(address).append("\n");
        return sb.toString();
    }
}
