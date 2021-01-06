package com.Brodau;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ConfigReader {

    public boolean renameFilesFromConfig(JsonReader jsonReader) throws IOException {
        Type jsonDeserializationTypes = new TypeToken<ArrayList<JsonDeserialization>>() {}.getType();
        List<JsonDeserialization> jsonDeserialization = new Gson().fromJson(jsonReader, jsonDeserializationTypes);
        for (JsonDeserialization j : jsonDeserialization) {
            File file = new File(j.getPath() + j.getOldName());
            if (!file.renameTo(new File(j.getPath()
                    + j.getNewName() + "_"
                    + j.getOldName()))) {
                return false;
            }
        }
        return true;
    }

    public boolean isFilesExist(JsonReader jsonReader) throws IOException {
        Type jsonDeserializationTypes = new TypeToken<ArrayList<JsonDeserialization>>() {
        }.getType();
        List<JsonDeserialization> jsonDeserialization = new Gson().fromJson(jsonReader, jsonDeserializationTypes);
        for (JsonDeserialization j : jsonDeserialization) {
            File file = new File(j.getPath() + j.getOldName());
            if (!file.exists()) {
                return false;
            }
        }
        return true;
    }


    public JsonReader readConfig(File config) throws IOException {
        return new JsonReader(new BufferedReader(new FileReader(config)));
    }
}
