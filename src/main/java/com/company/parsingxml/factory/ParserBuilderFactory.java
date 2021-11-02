package com.company.parsingxml.factory;

import com.company.parsingxml.builder.AbstractTariffsBuilder;
import com.company.parsingxml.parser.DOMParserBuilder;
import com.company.parsingxml.parser.SAXParserBuilder;
import com.company.parsingxml.parser.StAXParserBuilder;

public class ParserBuilderFactory {
        private enum ParserTag{
            SAX, STAX, DOM
        }
        private ParserBuilderFactory(){}

        public static AbstractTariffsBuilder createTariffsBuilder(String parserName)  {
            ParserTag tag = ParserTag.valueOf(parserName.toUpperCase());
            switch (tag){
                case DOM -> {
                    return new DOMParserBuilder();
                }
                case SAX -> {
                    return new SAXParserBuilder();
                }
                case STAX -> {
                    return new StAXParserBuilder();
                }
                default -> throw new EnumConstantNotPresentException(
                        tag.getDeclaringClass(), tag.name());
            }
        }
}
