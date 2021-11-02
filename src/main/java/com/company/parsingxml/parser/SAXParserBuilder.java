package com.company.parsingxml.parser;

import com.company.parsingxml.builder.AbstractTariffsBuilder;
import com.company.parsingxml.entity.Tariffs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Set;

public class SAXParserBuilder extends AbstractTariffsBuilder {
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
            logger.error("Parse configuration exception");
        } catch (SAXException e) {
            logger.error("SAX exception");
        }
        reader.setContentHandler(handler);
    }

    @Override
    public Set<Tariffs> getTariffs(){
        return tariffs;
    }

    @Override
    public void buildTariffs(String path){
        try {
            reader.parse(path);
        } catch (IOException e) {
            logger.error("IO exception");
        } catch (SAXException e) {
            logger.error("SAX exception");
        }
        tariffs=handler.getTariffs();
    }
}
