package org.example;

import org.example.UI.HomePage;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException, URISyntaxException, InterruptedException {

       /* LoginPage login = new LoginPage();
        login.setVisible(true);*/
        HomePage home = new HomePage();
        home.setVisible(true);

        Runtime.getRuntime().addShutdownHook(new Thread() {
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