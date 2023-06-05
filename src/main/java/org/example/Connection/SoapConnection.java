package org.example.Connection;

import org.example.Connection.Parser.SoapParser;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SoapConnection {
    private static final String URL = "http://localhost:8080/ws";
    private static final String AUTH = "Authorization";
    public static Integer getDeathsByCountry(String country) throws IOException, InterruptedException, ParserConfigurationException, SAXException {

        String xmlPayload = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
                "               xmlns:std=\"http://lizewski.com/soap\">\n" +
                "  <soap:Body>\n" +
                "    <std:getDeathsRequest>\n" +
                "      <country>"+ country + "</country>\n" +
                "    </std:getDeathsRequest>\n" +
                "  </soap:Body>\n" +
                "</soap:Envelope>";

        HttpClient client = HttpClient.newHttpClient();

        String token = Connection.readToken();


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .header("Content-Type", "text/xml")
                .setHeader(AUTH,token)
                .POST(HttpRequest.BodyPublishers.ofString(xmlPayload))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Integer deaths = SoapParser.parseDeaths(response.body());

        return deaths;
    }

}
