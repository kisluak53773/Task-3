package com.company.parsingxml.parser;

import com.company.parsingxml.entity.Landline;
import com.company.parsingxml.entity.Mobile;
import com.company.parsingxml.entity.Tariffs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class DOMParserBuilder {
    private Set<Tariffs> tariffs;
    private DocumentBuilder documentBuilder;
    private final static Logger logger= LogManager.getLogger();

    public DOMParserBuilder(){
        tariffs =new HashSet<Tariffs>();
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        try {
            documentBuilder=factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.error("Parse configuration exception");
        }
    }

    public void buildSetTariffs(String path){
        Document document;
        try {
            document=documentBuilder.parse(path);
            Element buffer=document.getDocumentElement();
            NodeList listMobile=buffer.getElementsByTagName("mobile");
            NodeList listLandline=buffer.getElementsByTagName("landline");
            addTariff(listMobile);
            addTariff(listLandline);
        } catch (SAXException e) {
            logger.error("SAX exception");
        } catch (IOException e) {
            logger.error("IO exception");
        }

    }

    public Set<Tariffs> getTariffs(){
        return tariffs;
    }

    private Tariffs buildTariff(Element buffer){
        if(buffer.hasAttribute("mobile-type")){
            Mobile mobile=new Mobile();
            mobile.setMobileType(buffer.getAttribute("mobile-type"));
            mobile.setSmsPrice(Double.parseDouble(getElementByText(buffer,"sms-price")));
            fillCommonValues(buffer,mobile);
            return mobile;
        }else {
            Landline landline=new Landline();
            landline.setAddress(getElementByText(buffer,"address"));
            fillCommonValues(buffer,landline);
            return landline;
        }
    }

    private static String getElementByText(Element buffer, String elementName){
        NodeList list=buffer.getElementsByTagName(elementName);
        Node node=list.item(0);
        String result=node.getTextContent();
        return result;
    }

    private void addTariff(NodeList list){
        for(int i=0;i< list.getLength();i++){
            Element element=(Element) list.item(i);
            Tariffs tariff=buildTariff(element);
            tariffs.add(tariff);
        }
    }

    private Tariffs fillCommonValues(Element buffer,Tariffs tariff){
        tariff.setTarifficationPrice(Double.parseDouble(getElementByText(buffer,"tariffication-price")));
        tariff.setTariffication(buffer.getAttribute("tariffication"));
        tariff.setFavoriteNumber(getElementByText(buffer,"favorite-number"));
        tariff.setConnectionPrice(Integer.parseInt(getElementByText(buffer,"connection-price")));
        tariff.setPayroll(Integer.parseInt(getElementByText(buffer,"payroll")));
        tariff.setPassport(getElementByText(buffer,"passport"));
        tariff.setContractorName(getElementByText(buffer,"contractor-name"));
        tariff.setContractDate(LocalDate.parse(getElementByText(buffer,"contract-date")));
        tariff.setOperatorName(getElementByText(buffer,"operator-name"));
        tariff.setName(getElementByText(buffer,"name"));
        tariff.setId(buffer.getAttribute("id"));
        return tariff;
    }
}
