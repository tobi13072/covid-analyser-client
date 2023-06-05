package org.example;

import lombok.SneakyThrows;
import org.example.Connection.SoapConnection;
import org.example.UI.HomePage;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException, URISyntaxException, InterruptedException, ParserConfigurationException, SAXException {

        HomePage home = new HomePage();
        home.setVisible(true);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                File file = new File("token.txt");
                if (file.exists()) {
                    file.delete();
                }
            }
        });




    }
}