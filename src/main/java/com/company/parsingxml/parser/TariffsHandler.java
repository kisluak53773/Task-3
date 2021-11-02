package com.company.parsingxml.parser;

import com.company.parsingxml.entity.Landline;
import com.company.parsingxml.entity.Mobile;
import com.company.parsingxml.entity.TariffXmlTag;
import com.company.parsingxml.entity.Tariffs;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDate;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class TariffsHandler extends DefaultHandler {
    private static final String XML_DELIMITER = "-";
    private static final String ENUM_DELIMITER = "_";
    private Set<Tariffs> tariffs;
    private Tariffs current;
    private TariffXmlTag currentXmlTag;
    private EnumSet<TariffXmlTag> withText;

    public  TariffsHandler(){
        tariffs = new HashSet<Tariffs>();
        withText = EnumSet.range(TariffXmlTag.NAME,TariffXmlTag.TARIFFICATION_PRICE);
    }

    public Set<Tariffs> getTariffs() {
        return tariffs;
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs){
        String landlineTag = TariffXmlTag.LANDLINE.getValue();
        String mobileTag = TariffXmlTag.MOBILE.getValue();
        if(landlineTag.equals(qName) || mobileTag.equals(qName)){
            if(landlineTag.equals(qName)){
                current = new Landline();
            }else{
                current = new Mobile();
            }
            for(int i = 0; i < attrs.getLength(); i++){
                currentXmlTag = TariffXmlTag.valueOf(replaceDelimiter(attrs.getQName(i)));
                switch (currentXmlTag){
                    case ID -> {
                        current.setId(attrs.getValue(i));
                    }
                    case TARIFFICATION ->{
                        current.setTariffication(attrs.getValue(i));
                    }
                    case MOBILE_TYPE -> {
                        Mobile mobile = (Mobile) current;
                        mobile.setMobileType(attrs.getValue(i));
                    }
                }
            }
            currentXmlTag = null;
        }else{
            TariffXmlTag buffer = TariffXmlTag.valueOf(replaceDelimiter(qName));
            if(withText.contains(buffer)){
                currentXmlTag = buffer;
            }
        }

    }

    public void endElement(String uri, String localName, String qName)  {
        String landlineTag = TariffXmlTag.LANDLINE.getValue();
        String mobileTag = TariffXmlTag.MOBILE.getValue();
        if(landlineTag.equals(qName) || mobileTag.equals(qName)){
            tariffs.add(current);
        }
    }


    public void characters(char[] ch, int start, int length)  {
        String buffer = new String(ch,start,length);
        if(currentXmlTag!=null){
            switch (currentXmlTag){
                case NAME ->{
                    current.setName(buffer);
                }
                case OPERATOR_NAME ->{
                    current.setOperatorName(buffer);
                }case CONTRACT_DATE->{
                    current.setContractDate(LocalDate.parse(buffer));
                }case CONTRACTOR_NAME -> {
                    current.setContractorName(buffer);
                }case PASSPORT -> {
                    current.setPassport(buffer);
                }
                case TARIFFICATION_PRICE ->{
                    current.setTariffication(buffer);
                }
                case PAYROLL ->{
                    current.setPayroll(Integer.parseInt(buffer));
                }
                case CONNECTION_PRICE ->{
                    current.setConnectionPrice(Integer.parseInt(buffer));
                }
                case FAVORITE_NUMBER ->{
                    current.setFavoriteNumber(buffer);
                }
                case SMS_PRICE ->{
                    Mobile mobile=(Mobile)current;
                    mobile.setSmsPrice(Double.parseDouble(buffer));
                }
                case ADDRESS ->{
                    Landline landline = (Landline) current;
                    landline.setAddress(buffer);
                }
                default -> {
                    throw new EnumConstantNotPresentException(
                            currentXmlTag.getDeclaringClass(),currentXmlTag.name());
                }
            }
        }
        currentXmlTag = null;
    }

    private String replaceDelimiter(String name){
        return name.replace(XML_DELIMITER,ENUM_DELIMITER)
                .toUpperCase();
    }
}
