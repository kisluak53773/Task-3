package com.company.parsingxml.parser;

import com.company.parsingxml.builder.AbstractTariffsBuilder;
import com.company.parsingxml.entity.Landline;
import com.company.parsingxml.entity.Mobile;
import com.company.parsingxml.entity.TariffXmlTag;
import com.company.parsingxml.entity.Tariffs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class StAXParserBuilder extends AbstractTariffsBuilder {
    private final static Logger logger= LogManager.getLogger();
    private static final String XML_DELIMITER = "-";
    private static final String ENUM_DELIMITER = "_";
    private Set<Tariffs> tariffs;
    private XMLInputFactory inputFactory;

    public StAXParserBuilder(){
        inputFactory=XMLInputFactory.newInstance();
        tariffs=new HashSet<Tariffs>();
    }

    @Override
    public Set<Tariffs> getTariffs(){
        return tariffs;
    }

    @Override
    public void buildTariffs(String path){
        XMLStreamReader reader;
        String name;
        try(FileInputStream inputStream=new FileInputStream(new File(path))){
            reader=inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()){
                int type=reader.next();
                if(type== XMLStreamConstants.START_ELEMENT){
                    name=reader.getLocalName();
                    if(name.equals(TariffXmlTag.MOBILE.getValue())){
                        Mobile mobile=new Mobile();
                        mobile= (Mobile) buildTariff(name,reader,mobile);
                        tariffs.add(mobile);
                    }else if(name.equals(TariffXmlTag.LANDLINE.getValue())){
                        Landline landline=new Landline();
                        landline= (Landline) buildTariff(name,reader,landline);
                        tariffs.add(landline);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            logger.error("File not found");
        } catch (IOException e) {
            logger.error("IO exception");
        } catch (XMLStreamException e) {
            logger.error("XML stream exception");
        }
    }

    private Tariffs buildTariff(String tag, XMLStreamReader reader,Tariffs tariff) throws XMLStreamException {
        if(tag.equals(TariffXmlTag.MOBILE.getValue())){
            Mobile mobile=(Mobile)tariff;
            mobile.setMobileType(reader.getAttributeValue(null,TariffXmlTag.MOBILE_TYPE.getValue()));
        }
        tariff.setId(reader.getAttributeValue(null,TariffXmlTag.ID.getValue()));
        tariff.setTariffication(reader.getAttributeValue(null,TariffXmlTag.TARIFFICATION.getValue()));
        String name;
        while (reader.hasNext()){
            int type=reader.next();
            switch (type){
                case XMLStreamConstants.START_ELEMENT:
                    name=reader.getLocalName();
                    switch (TariffXmlTag.valueOf(replaceDelimiter(name))){
                        case NAME ->{
                            tariff.setName(getXMLText(reader));
                        }case OPERATOR_NAME ->{
                            tariff.setOperatorName(getXMLText(reader));
                        }
                        case TARIFFICATION_PRICE ->{
                            tariff.setTarifficationPrice(Double.parseDouble(getXMLText(reader)));
                        }case CONTRACT_DATE -> {
                            tariff.setContractDate(LocalDate.parse(getXMLText(reader)));
                        }case CONTRACTOR_NAME -> {
                            tariff.setContractorName(getXMLText(reader));
                        }case PASSPORT -> {
                            tariff.setPassport(getXMLText(reader));
                        }
                        case PAYROLL ->{
                            tariff.setPayroll(Integer.parseInt(getXMLText(reader)));
                        }
                        case CONNECTION_PRICE ->{
                            tariff.setConnectionPrice(Integer.parseInt(getXMLText(reader)));
                        }
                        case FAVORITE_NUMBER ->{
                            tariff.setFavoriteNumber(getXMLText(reader));
                        }
                        case SMS_PRICE ->{
                            Mobile mobile=(Mobile)tariff;
                            mobile.setSmsPrice(Double.parseDouble(getXMLText(reader)));
                        }
                        case ADDRESS ->{
                            Landline landline = (Landline) tariff;
                            landline.setAddress(getXMLText(reader));
                        }
                    }break;
                case XMLStreamConstants.END_ELEMENT:{
                    name=reader.getLocalName();
                    if(name.equals(TariffXmlTag.MOBILE.getValue()) | name.equals(TariffXmlTag.LANDLINE.getValue())){
                        return tariff;
                    }
                }
            }
        }
        return tariff;
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String result=null;
        if(reader.hasNext()){
            reader.next();
            result=reader.getText();
        }
        return result;
    }

    private String replaceDelimiter(String name){
        return name.replace(XML_DELIMITER,ENUM_DELIMITER)
                .toUpperCase();
    }
}
