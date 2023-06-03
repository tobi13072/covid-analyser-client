package org.example.Connection.Deserializer;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.example.Connection.Repsonse.StatResponse;

import java.util.List;

public class DeserializerStatResponse {
    public static String deserializerStats(List<StatResponse> stats){

        JsonArray jsonArray = new JsonArray();

        for(StatResponse element: stats){
            JsonObject jsonBody = new JsonObject();
            jsonBody.addProperty("stat_id", element.getStatId());
            jsonBody.addProperty("country_population", element.getCountryPopulation());
            jsonBody.addProperty("total_cases", element.getTotalCases());
            jsonBody.addProperty("total_deaths", element.getTotalDeaths());
            jsonBody.addProperty("total_recovered", element.getTotalRecovered());
            jsonBody.addProperty("active_cases", element.getActiveAccess());

            JsonObject jsonCountry = new JsonObject();
            jsonCountry.addProperty("country_name", element.getCountry().getCountryName());

            jsonBody.add("country",jsonCountry);
            jsonArray.add(jsonBody);
        }

        return jsonArray.toString();
    }
}
