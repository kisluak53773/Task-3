package com.company.parsingxml.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;


import com.company.parsingxml.builder.AbstractTariffsBuilder;
import com.company.parsingxml.factory.ParserBuilderFactory;
import com.company.parsingxml.parser.DOMParserBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private final static Logger logger= LogManager.getLogger();
    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
        AbstractTariffsBuilder builder= ParserBuilderFactory.createTariffsBuilder("stax");
        builder.buildTariffs("src/main/resources/data/tariffs.xml");
        logger.info(builder.getTariffs());
    }
}
