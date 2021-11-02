package com.company.parsingxml.factory;

import com.company.parsingxml.builder.AbstractTariffsBuilder;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ParserBuilderFactoryTest {

    @Test
    public void testCreateTariffsBuilderSAX() {
        String expected="[id:id1\n" +
                "name:standard\n" + "operator name:A1\n" + "contract date:2015-04-28\n" + "contractor name:Alex Merser\n" +
                "passport:AB614521\n" + "payroll:2\n" + "connection price:5\n" + "favorite number:+375296662574\n" +
                "tariffication:null\n" + "tariffication price:0.1\n" + "sms price:0.5\n" + "mobile type:out-net\n" +
                ", id:id2\n" + "name:standard\n" + "operator name:Beltelecom\n" + "contract date:2016-12-19\n" +
                "contractor name:Jason Smith\n" + "passport:AB672984\n" + "payroll:5\n" + "connection price:10\n"
                + "favorite number:+375296458719\n" + "tariffication:12 seconds\n" + "tariffication price:0.02\n"
                + "address:str.Belgorodska, h.15, ap.63\n" + "]";
        AbstractTariffsBuilder builder= ParserBuilderFactory.createTariffsBuilder("sax");
        builder.buildTariffs(String.valueOf(ClassLoader.getSystemResource("data/tariffs.xml")));
        String actual=builder.getTariffs().toString();
        assertEquals(actual,expected);
    }

    @Test
    public void testCreateTariffsBuilderDOM(){
        String expected="[id:id1\n" +
                "name:standard\n" + "operator name:A1\n" + "contract date:2015-04-28\n" + "contractor name:Alex Merser\n" +
                "passport:AB614521\n" + "payroll:2\n" + "connection price:5\n" + "favorite number:+375296662574\n" +
                "tariffication:\n" + "tariffication price:0.1\n" + "sms price:0.5\n" + "mobile type:out-net\n" + ", id:id2\n" +
                "name:standard\n" + "operator name:Beltelecom\n" + "contract date:2016-12-19\n" + "contractor name:Jason Smith\n"
                + "passport:AB672984\n" + "payroll:5\n" + "connection price:10\n" + "favorite number:+375296458719\n"
                + "tariffication:12 seconds\n" + "tariffication price:0.02\n" + "address:str.Belgorodska, h.15, ap.63\n" + "]";
        AbstractTariffsBuilder builder= ParserBuilderFactory.createTariffsBuilder("dom");
        builder.buildTariffs(String.valueOf(ClassLoader.getSystemResource("data/tariffs.xml")));
        String actual=builder.getTariffs().toString();
        assertEquals(actual,expected);
    }

    @Test
    public void testCreateTariffsBuilderStAX(){
        String expected="[id:id1\n" + "name:standard\n" + "operator name:A1\n" + "contract date:2015-04-28\n" +
                "contractor name:Alex Merser\n" + "passport:AB614521\n" + "payroll:2\n" + "connection price:5\n" +
                "favorite number:+375296662574\n" + "tariffication:null\n" + "tariffication price:0.1\n" + "sms price:0.5\n" +
                "mobile type:out-net\n" + ", id:id2\n" + "name:standard\n" + "operator name:Beltelecom\n" + "contract date:2016-12-19\n" +
                "contractor name:Jason Smith\n" + "passport:AB672984\n" + "payroll:5\n" + "connection price:10\n" +
                "favorite number:+375296458719\n" + "tariffication:12 seconds\n" + "tariffication price:0.02\n" +
                "address:str.Belgorodska, h.15, ap.63\n" + "]";
        AbstractTariffsBuilder builder= ParserBuilderFactory.createTariffsBuilder("stax");
        builder.buildTariffs("src/main/resources/data/tariffs.xml");
        String actual=builder.getTariffs().toString();
        assertEquals(actual,expected);
    }
}