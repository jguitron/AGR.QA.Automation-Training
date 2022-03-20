//package com.ashley_ui.testsData;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Properties;
//
//
//public class CreatingPropertiesFile extends HashMap {
//
//    static Properties props = new Properties();
//
//    public String NewPropertyFile(){
//        String urlAddress = "https://www.ashleyfurniture.com/";
//        String urlName = "devUrl";
//        props.put(urlName, urlAddress);
//    return urlName;
//
//    }
//
//    public static void main(String[] args) throws IOException {
//
////        props.put("stageUrl", "https://ecomm-mozart.stage.ashleyretail.com");
//////        props.put("mfiUrl", "https://mfe-content.dev.ashleyretail.com");
////
//        props.put("browser1", "chrome");
////        props.put("browser2", "chrome-headless");
////        props.put("browser3", "chrome-remote");
////        props.put("browser4", "safari");
////        props.put("browser5", "safari-remote");
//        String path = "config.properties";
//        FileOutputStream outputStream = new FileOutputStream(path);
//        props.store(outputStream, "New properties file added");
//
//    }
//
//}
