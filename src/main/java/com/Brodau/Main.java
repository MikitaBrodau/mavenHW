package com.Brodau;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ConfigReader cf = new ConfigReader();
        try {
            File config = new File("config.json");
            if (cf.isFilesExist(cf.readConfig(config))) {
                if (cf.renameFilesFromConfig(cf.readConfig(config))) {
                    System.out.println("Success");
                } else System.err.println("Wrong input");
            } else System.err.println("Files not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
