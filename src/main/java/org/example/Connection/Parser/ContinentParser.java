package org.example.Connection.Parser;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import lombok.NoArgsConstructor;
import org.example.Connection.Repsonse.ContinentResponse;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class ContinentParser {

    public static List<ContinentResponse> parseContinent(HttpResponse<String> response) {

        JsonArray jsonArray = JsonParser.parseString(response.body()).getAsJsonArray();

        List<ContinentResponse> continentResponseList = new ArrayList<>();


        for (JsonElement jsonElement : jsonArray) {
            Integer continentId = jsonElement.getAsJsonObject().get("continent_id").getAsInt();
            String continentName = jsonElement.getAsJsonObject().get("continent_name").getAsString();

            ContinentResponse continentResponse = new ContinentResponse();

            continentResponse.setContinentId(continentId);
            continentResponse.setContinentName(continentName);

            continentResponseList.add(continentResponse);
        }

        return continentResponseList;
    }

}
