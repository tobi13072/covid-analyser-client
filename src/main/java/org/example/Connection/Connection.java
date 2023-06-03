package org.example.Connection;

import com.google.gson.JsonObject;
import lombok.Getter;
import org.example.Connection.Parser.LoginParser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Getter
public class Connection {
    private static final String BASE_URL = "http://localhost:8080/";
    private String token;
    public Integer login(String username,String password) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        JsonObject jsonBody = new JsonObject();
        jsonBody.addProperty("username", username);
        jsonBody.addProperty("password", password);

        String url = BASE_URL + "api/auth/authenticate";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody.toString()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        int statusCode = response.statusCode();

        if(statusCode==200){
            token = LoginParser.parseLogin(response);
        }

        writeToken(statusCode);

        return statusCode;
    }


    public void writeToken(int statusCode) throws IOException {
        if(statusCode == 200){
            FileWriter fileWriter = new FileWriter("token.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(token);
            bufferedWriter.close();
        }
    }

    public static String readToken() throws IOException {

        File file = new File("token.txt");

        if (file.exists()) {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            bufferedReader.close();

            String content = stringBuilder.toString();

            String BEARER = "Bearer ";

            return BEARER += content;

        } else {
            System.out.println("Plik nie istnieje.");
        }
        return null;
    }
}
