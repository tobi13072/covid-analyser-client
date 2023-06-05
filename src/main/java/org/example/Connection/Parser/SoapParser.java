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

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new InputSource(new StringReader(xml)));

        NodeList totalList = document.getElementsByTagName("total");
        Integer deathsTotal = null;
        if (totalList.getLength() > 0) {
            Element totalElement = (Element) totalList.item(0);
            String totalValue = totalElement.getTextContent();
            deathsTotal = Integer.parseInt(totalValue);
        } else {
            System.out.println("BLAD SOAP.");
        }
        return deathsTotal;
    }
}
