package org.example.utilty;

import com.google.common.collect.Ordering;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Utility {

    public static String currentDir = System.getProperty("user.dir");
    public static boolean isSorted(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return false;
        }
        return true;
    }


    public static double[] listToArrayOfDoubles(List<String> list){
        double[] doubleList = new double[list.size()];
        double sum = 0;
        for (int i = 0; i < list.size(); ++i) {
            doubleList[i] = Double.parseDouble(list.get(i));

        }
        return doubleList;
    }

    public static Properties loadProperties(){
        Properties prop = new Properties();
        try {
            InputStream inputStream = Files.newInputStream(Paths.get(currentDir+ File.separator+"config.properties"));
            prop.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;
    }
    public static String decode(String key){
        byte[] decodedBytes = Base64.getDecoder().decode(key);
        return new String(decodedBytes);
    }

    public static void main(String[] args) {
        String username = "";
        String securedUsername;
        String password = "";

        securedUsername = Base64.getEncoder().encodeToString(username.getBytes());
        System.out.println(securedUsername);
    }
   public static boolean listSortAtoZ(List<String> inputName) {
       inputName.sort(Comparator.naturalOrder());
       return true;
   }
    public static boolean sortedAlphaZtoA(List<String> inputName) {
        Ordering.natural().reverse().isOrdered(inputName);
        return true;
    }

   public static void isSortedAtoZ(List<String> inputName){
        Collections.sort(inputName);
        System.out.println(inputName);

   }
}
