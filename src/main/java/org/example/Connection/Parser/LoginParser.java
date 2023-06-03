package org.example.Connection.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.http.HttpResponse;

public class LoginParser {

    public static String parseLogin(HttpResponse<String> response){

        JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();

        String token = jsonObject.getAsJsonObject().get("token").getAsString();


        return token;
    }
}
