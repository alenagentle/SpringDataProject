package com.simbirsoft.javacourse.data;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Properties;

@Component
public class PropertyReader {
    private Properties prop;

    public Properties loadFile() {
        String configFileInput = "resources/person.properties";
        this.prop = new Properties();
        try {
            this.prop.load(new BufferedReader(new InputStreamReader(new FileInputStream(configFileInput), "UTF-8")));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return this.prop;
    }
}
