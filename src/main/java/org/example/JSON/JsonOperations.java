package org.example.JSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JsonOperations<T> {
    public void exportJson(List<T> data,File file) throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(file.getAbsolutePath())) {
            gson.toJson(data, writer);
        }
    }

    public List<T> importJson(File file, TypeToken<List<T>> typeToken) throws IOException {
        String json = new String(Files.readAllBytes(Paths.get(file.getPath())));

        Gson gson = new Gson();
        Type listType = typeToken.getType();

        return gson.fromJson(json, listType);
    }


}
