package com.company.parsingxml.main;

import java.net.URISyntaxException;


import com.company.parsingxml.parser.DOMParserBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private final static Logger logger= LogManager.getLogger();
    public static void main(String[] args) throws URISyntaxException {
        DOMParserBuilder builder=new DOMParserBuilder();
        builder.buildSetTariffs("C:/epam/Task 3/src/main/resources/tariffs.xml");
        logger.info(builder.getTariffs());
    }
}
