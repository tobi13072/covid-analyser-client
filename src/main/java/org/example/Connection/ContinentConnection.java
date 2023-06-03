package org.example.Connection;

import lombok.NoArgsConstructor;
import org.example.Connection.Parser.ContinentParser;
import org.example.Connection.Repsonse.ContinentResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@NoArgsConstructor
public class ContinentConnection {
    private static final String AUTH = "Authorization";
    public static List<ContinentResponse> getAllContinent()  throws IOException, URISyntaxException, InterruptedException{

        String BEARER = Connection.readToken();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8080/continent/all"))
                .setHeader(AUTH, BEARER)
                .build();

        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        List<ContinentResponse> continentResponseList= ContinentParser.parseContinent(response);

        return continentResponseList;
    }
}
