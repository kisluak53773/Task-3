package com.company.parser;

import com.company.entity.Tariffs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Set;

public class SAXParserBuilder {
    private Set<Tariffs> tariffs;
    private TariffsHandler handler=new TariffsHandler();
    private XMLReader reader;
    private final static Logger logger= LogManager.getLogger();

    public SAXParserBuilder(){
        SAXParserFactory factory=SAXParserFactory.newInstance();
        try {
            SAXParser parser=factory.newSAXParser();
            reader=parser.getXMLReader();
        } catch (ParserConfigurationException e) {
            logger.error("sax parser exception");
        } catch (SAXException e) {
            logger.error("sax parser exception");
        }
        reader.setContentHandler(handler);
    }

    public Set<Tariffs> getTariffs(){
        return tariffs;
    }

    public void buildTariffs(String filename){
        try {
            reader.parse(filename);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        tariffs=handler.getTariffs();
    }
}
