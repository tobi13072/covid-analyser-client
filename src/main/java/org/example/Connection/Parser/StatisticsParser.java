package org.example.Connection.Parser;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.NoArgsConstructor;
import org.example.Connection.Repsonse.CountryResponse;
import org.example.Connection.Repsonse.StatResponse;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class StatisticsParser {

    public static List<StatResponse> parseStatistics(HttpResponse<String> response) {

        JsonArray jsonArray = JsonParser.parseString(response.body()).getAsJsonArray();

        List<StatResponse> statResponseList = new ArrayList<>();


        for (JsonElement jsonElement : jsonArray) {

            Integer statId = jsonElement.getAsJsonObject().get("stat_id").getAsInt();
            Integer countryPopulation = jsonElement.getAsJsonObject().get("country_population").getAsInt();
            Integer totalCases = jsonElement.getAsJsonObject().get("total_cases").getAsInt();
            Integer totalDeaths = jsonElement.getAsJsonObject().get("total_deaths").getAsInt();
            Integer totalRecovered = jsonElement.getAsJsonObject().get("total_recovered").getAsInt();
            Integer activeCases = jsonElement.getAsJsonObject().get("active_cases").getAsInt();

            JsonObject countryObject = jsonElement.getAsJsonObject().get("country").getAsJsonObject();

            String countryName = countryObject.get("country_name").getAsString();
            Integer countryId = countryObject.get("country_id").getAsInt();

            StatResponse statResponse = new StatResponse();

            statResponse.setStatId(statId);
            statResponse.setTotalCases(totalCases);
            statResponse.setCountryPopulation(countryPopulation);
            statResponse.setTotalDeaths(totalDeaths);
            statResponse.setTotalRecovered(totalRecovered);
            statResponse.setActiveAccess(activeCases);

            CountryResponse countryResponse = new CountryResponse();
            countryResponse.setCountryId(countryId);
            countryResponse.setCountryName(countryName);

            statResponse.setCountry(countryResponse);

            statResponseList.add(statResponse);
        }

        return statResponseList;
    }
}
