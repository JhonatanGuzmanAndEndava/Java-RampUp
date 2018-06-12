package com.endava.bod.challenge.dataprocessing;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Export {
    public static void exportToJson(Staffs staffs) {
        Gson gson = new Gson();
        String jsonFile = gson.toJson(staffs, new TypeToken<Staffs>(){}.getType());
        try {
            Files.write(Paths.get("exportEmployees.json"), jsonFile.getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
