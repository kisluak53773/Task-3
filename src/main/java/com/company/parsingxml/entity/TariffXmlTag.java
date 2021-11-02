package com.company.parsingxml.entity;

public enum TariffXmlTag {
    TARIFFS("tariffs"),
    LANDLINE("landline"),
    MOBILE("mobile"),
    ID("id"),
    TARIFFICATION("tariffication"),
    MOBILE_TYPE("mobile-type"),
    NAME("name"),
    OPERATOR_NAME("operator-name"),
    CONTRACT_DATE("contract-date"),
    CONTRACTOR_NAME("contractor-name"),
    PASSPORT("passport"),
    PAYROLL("payroll"),
    CONNECTION_PRICE("connection-price"),
    FAVORITE_NUMBER("favorite-number"),
    SMS_PRICE("sms-price"),
    ADDRESS("address"),
    TARIFFICATION_PRICE("tariffication-price");
    private String value;
    TariffXmlTag(String value){
        this.value=value;
    }
    public String getValue(){
        return value;
    }
}
