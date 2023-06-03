package org.example.Connection;

import org.example.Connection.Deserializer.DeserializerStatResponse;
import org.example.Connection.Parser.StatisticsParser;
import org.example.Connection.Repsonse.StatResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;


public class StatisticsConnection{
    private static final String AUTH = "Authorization";

    public static List<StatResponse> getAllStatistics() throws IOException, URISyntaxException, InterruptedException {

        String BEARER = Connection.readToken();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8080/stats/all"))
                .setHeader(AUTH, BEARER)
                .build();

        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        List<StatResponse> statResponseList = StatisticsParser.parseStatistics(response);

        return statResponseList;

    }

    public static List<StatResponse> getFilteredStatistics(String continent, String deaths) throws URISyntaxException, IOException, InterruptedException {

        String BEARER = Connection.readToken();
        String url = "http://localhost:8080/stats/filter/" + continent + "/" + deaths;
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI(url))
                .setHeader(AUTH, BEARER)
                .build();

        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        List<StatResponse> statResponseList = StatisticsParser.parseStatistics(response);

        return statResponseList;
    }

    public static List<StatResponse> getFilteredByContinent(String continent) throws URISyntaxException, IOException, InterruptedException {

        String BEARER = Connection.readToken();
        String url = "http://localhost:8080/stats/continent/" + continent;
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI(url))
                .setHeader(AUTH, BEARER)
                .build();

        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        List<StatResponse> statResponseList = StatisticsParser.parseStatistics(response);

        return statResponseList;
    }

    public static List<StatResponse> getFilteredByCountry(String country) throws URISyntaxException, IOException, InterruptedException {

        country = country.replace(" ","+");

        String BEARER = Connection.readToken();
        String url = "http://localhost:8080/stats/country?country=" + country + "&";
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI(url))
                .setHeader(AUTH, BEARER)
                .build();

        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        List<StatResponse> statResponseList = StatisticsParser.parseStatistics(response);

        return statResponseList;
    }

    public static List<StatResponse> getFilteredByDeaths(String deaths) throws URISyntaxException, IOException, InterruptedException {

        String BEARER = Connection.readToken();
        String url = "http://localhost:8080/stats/deaths/" + deaths;
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI(url))
                .setHeader(AUTH, BEARER)
                .build();

        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        List<StatResponse> statResponseList = StatisticsParser.parseStatistics(response);

        return statResponseList;
    }

    public static int updateStatistics(List<StatResponse> stats) throws IOException, InterruptedException {

        String BEARER = Connection.readToken();
        HttpClient client = HttpClient.newHttpClient();

        String post = DeserializerStatResponse.deserializerStats(stats);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/stats/update"))
                .header("Content-Type", "application/json")
                .setHeader(AUTH, BEARER)
                .POST(HttpRequest.BodyPublishers.ofString(post))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.statusCode();
    }
}


