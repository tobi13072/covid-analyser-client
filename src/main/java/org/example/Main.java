package org.example;

import lombok.SneakyThrows;
import org.example.UI.HomePage;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

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