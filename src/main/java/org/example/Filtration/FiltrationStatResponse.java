package org.example.Filtration;

import org.example.Connection.Repsonse.StatResponse;
import org.example.Connection.StatisticsConnection;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class FiltrationStatResponse {
    public static List<StatResponse> filterData(String continent, String country, String deaths) throws URISyntaxException, IOException, InterruptedException {

        List<StatResponse> stats = new ArrayList<>();


        if(!country.isEmpty()){
            stats = StatisticsConnection.getFilteredByCountry(country);
        }else if (!continent.isEmpty() && country.isEmpty() && deaths.equals("-1")){
            stats = StatisticsConnection.getFilteredByContinent(continent);
        } else if (continent.isEmpty() && country.isEmpty() && !deaths.equals("-1")) {
            stats = StatisticsConnection.getFilteredByDeaths(deaths);
        }else if(!continent.isEmpty() && country.isEmpty() && !deaths.equals("-1")){
            stats = StatisticsConnection.getFilteredStatistics(continent,deaths);
        }else {
            stats = StatisticsConnection.getAllStatistics();
        }


        return stats;
    }
}
