package com.sainsburys.utils;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class UtilHelper {

    static Logger log = LoggerHelper.getLogger(UtilHelper.class);
    private static String dateFormat = "yyyy-MM-dd";

    /**
     * This function is used to derive system date in required format
     *
     * @return date
     */
    public static String getCurrentDate() {
        DateFormat df = new SimpleDateFormat(dateFormat);
        Date dateobj = new Date();
        return df.format(dateobj);
    }

    /**
     * Method to get current time
     */
    public static int getCurrentTime() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat time = new SimpleDateFormat("HHmmss");
        int currentTime = Integer.parseInt(time.format(cal.getTime()));
        return currentTime;
    }

    /**
     * Method to get time in pattern
     */
    public static String getFormattedDateTime(String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        return date;
    }

    /**
     * Method to format date(20200202) to date(2020-02-02)
     *
     * @param date
     * @return
     */
    public static String getFormattedDate(String date) {
        StringBuilder builder = new StringBuilder(date);
        builder.insert(4, '-');
        builder.insert(7, '-');
        String formattedDate = builder.toString();
        return formattedDate;
    }

    /**
     * This method reads given file and convert to String
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    public static String generateStringValueFromJson(String filePath) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(filePath));
            JSONObject jsonObject = (JSONObject) obj;
            String json = jsonObject.toJSONString();
            return json;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Not able to convert Json to String..");
        }
    }

    /**
     * This method reads given string and parse to Json
     *
     * @param text
     * @return JSONObject
     * @throws IOException
     */
    public static JSONObject generateJsonFromString(String text) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(text);
            JSONObject jsonResponse = (JSONObject) parser.parse(obj.toString());
            return jsonResponse;
        } catch (Exception e) {
            log.info("Invalid message");
//			e.printStackTrace();
//			throw new RuntimeException("Not able to convert to json response.");
        }
        return null;
    }

    /**
     * This method reads given string and parse to Json
     *
     * @return JSONObject
     * @throws IOException
     */
    public static JSONObject generateJsonFromFile(String filePath) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(filePath));
            JSONObject jsonResponse = (JSONObject) parser.parse(obj.toString());
            return jsonResponse;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Not able to convert to json response.");
        }
    }

    public static List<String> generateJsonListFromFile(String filePath) {
        JSONParser parser = new JSONParser();
        List<String> jsonResponseList = new ArrayList<>();
        try {
            Object obj = parser.parse(new FileReader(filePath));
            JSONArray jsonResponse = (JSONArray) parser.parse(obj.toString());
            for (int i = 0; i < jsonResponse.size(); i++) {
                jsonResponseList.add(jsonResponse.get(i).toString());
            }
            return jsonResponseList;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Not able to convert to json response.");
        }
    }

    /**
     * This method reads text, convert to json object and then to object MAP
     *
     * @param jsonTextString
     * @param headerKey
     * @return Object Map of Json
     */
    public static Map<String, Object> generateObjectMapFromJsonString(String jsonTextString, String headerKey) {
        try {
            JSONObject jsonObject = generateJsonFromString(jsonTextString);
            Map<String, Object> objectMap = (Map<String, Object>) jsonObject.get(headerKey);
            return objectMap;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Not able to parse json and convert to map.");
        }
    }

    /**
     * This method reads text, convert to json object and then to object MAP
     *
     * @param jsonTextString
     * @return Object Map of Json
     */
    public static Map<String, Object> generateObjectMapFromJsonString(String jsonTextString) {
        try {
            JSONObject jsonObject = generateJsonFromString(jsonTextString);
            Map<String, Object> objectMap = (Map<String, Object>) jsonObject;
            return objectMap;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Not able to parse json and convert to map.");
        }
    }

    /**
     * Decode the given text
     *
     * @param text
     * @return decoded text
     */
    public static String decryptText(String text) {
        byte[] decodedBytes = Base64.getDecoder().decode(text);
        String decodedText = new String(decodedBytes);
        return decodedText;
    }

    /**
     * Copy the files from source path to destination
     *
     * @param src
     * @param dest
     * @throws IOException
     */
    public static void copy(File src, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = is.read(buf)) > 0) {
                os.write(buf, 0, bytesRead);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    public static JSONObject getJsonObjectFromJson(JSONObject data, String key) {
        JSONObject jsonObject = (JSONObject) data.get(key);
        return jsonObject;
    }

    public static String getStringObjectFromJson(JSONObject data, String key) {
        Object value = data.get(key);
        if (value.equals("null")) {
            return null;
        } else {
            String text = String.valueOf(data.get(key));
            return text;
        }
    }

    public static JSONArray getJsonArrayFromJson(JSONObject data, String key) {
        JSONArray jsonArray = (JSONArray) data.get(key);
        return jsonArray;
    }

    public static void deleteFile(String filePath) {

        try {
            File reportFile = new File(filePath);
            if (reportFile.isDirectory()) {
                if (reportFile.exists()) {
                    FileUtils.cleanDirectory(reportFile);
                }
            } else {
                if (reportFile.exists()) {
                    reportFile.delete();
                }
            }

        } catch (Exception e) {
            log.info("Not able to delete file..");
            e.printStackTrace();
        }
    }
}