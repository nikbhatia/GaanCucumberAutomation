package com.gaana.automation.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;
import com.gaana.test.base.BaseAutomation;

/**
 * This file contains utility functions related to yaml files
 * @author nikhil.bhatia
 *
 */


public class YamlReader {

    public static String appConfigPath = "";

    public static void configureTestDataPaths(String env) {
        appConfigPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "testdata" + File.separator + "appConfig_" + env + ".yml";
        BaseAutomation.appUrlFile = appConfigPath;
    }

    /**
     * @author nikhil.bhatia, This method use to read YML file and return the
     * value according to the key
     * @param key {yaml key for which value is needed}
     * @return {yaml value according to key}
     */
    public static String getAppConfigValue(String key) {
        String value = null;
        try {
            value = getValue(key, appConfigPath);
        } catch (FileNotFoundException ex) {
            TestNGLogUtility.info(ex.getMessage());
            return null;
        }
        return value;
    }





    @SuppressWarnings("unchecked")
    public static Map<String, Object> getYamlValues(String token) {
        Reader doc;
        System.out.println("Yaml: " + appConfigPath);
        try {
            doc = new FileReader(appConfigPath);
        } catch (FileNotFoundException ex) {
            TestNGLogUtility.info("File not valid or missing!!!");
            ex.printStackTrace();
            return null;
        }
        Yaml yaml = new Yaml();
        // TODO: check the type casting of object into the Map and create
        // instance in one place
        Map<String, Object> object = (Map<String, Object>) yaml.load(doc);
        return parseMap(object, token + ".");
    }

    @SuppressWarnings("unchecked")
    private static String getValue(String token, String yamlFile) throws FileNotFoundException {
        Reader doc = new FileReader(yamlFile);
        Yaml yaml = new Yaml();
        Map<String, Object> object = (Map<String, Object>) yaml.load(doc);
        return getMapValue(object, token);
    }

    public static String getMapValue(Map<String, Object> object, String token) {
        // TODO: check for proper yaml token string based on presence of '.'
        String[] st = token.split("\\.");
        return parseMap(object, token).get(st[st.length - 1]).toString();
    }

    @SuppressWarnings("unchecked")
    private static Map<String, Object> parseMap(Map<String, Object> object,
            String token) {
        if (token.contains(".")) {
            String[] st = token.split("\\.");
            object = parseMap((Map<String, Object>) object.get(st[0]),
                    token.replace(st[0] + ".", ""));
        }
        return object;
    }

    public static int generateRandomNumber(int MinRange, int MaxRange) {
        int randomNumber = MinRange
                + (int) (Math.random() * ((MaxRange - MinRange) + 1));
        return randomNumber;
    }
}
