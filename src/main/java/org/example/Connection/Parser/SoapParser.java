package org.example.Connection.Parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

public class SoapParser {
    public static Integer parseDeaths(String xml) throws IOException, SAXException, ParserConfigurationException {

        /*String xml = "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "    <SOAP-ENV:Header/>\n" +
                "    <SOAP-ENV:Body>\n" +
                "        <ns3:getDeathsResponse xmlns:ns3=\"http://lizewski.com/soap\">\n" +
                "            <deaths>\n" +
                "                <country>Poland</country>\n" +
                "                <total>1234</total>\n" +
                "            </deaths>\n" +
                "        </ns3:getDeathsResponse>\n" +
                "    </SOAP-ENV:Body>\n" +
                "</SOAP-ENV:Envelope>";*/

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new InputSource(new StringReader(xml)));

        NodeList totalList = document.getElementsByTagName("total");
        Integer deathsTotal = null;
        if (totalList.getLength() > 0) {
            Element totalElement = (Element) totalList.item(0);
            String totalValue = totalElement.getTextContent();
            deathsTotal = Integer.parseInt(totalValue);
            System.out.println("Liczba zgonów: " + deathsTotal);
        } else {
            System.out.println("Nie znaleziono elementu <total>.");
        }
        return deathsTotal;
    }
}
