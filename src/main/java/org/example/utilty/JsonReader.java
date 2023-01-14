package org.example.utilty;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JsonReader  {


     // create method for external path ?

    public Object getDataFile(String value) {
        String dataFilePath = ".//data/myjson.json";
        JSONObject testObject = null;


        try {
            FileReader reader = new FileReader(dataFilePath );
            JSONParser jsonParser = new JSONParser();
            Object Obj =  jsonParser.parse(reader);
            testObject = (JSONObject) Obj;
            testObject.get(value);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        assert testObject != null;
        return testObject.get(value);


    }
}
   /* public static void main(String[] args) {

        JsonReader jsonReader = new JsonReader();

          String results = (String) jsonReader.getDataFile("ProductName");
        System.out.println(results);
    }*/




//For Json Array:
     /* JSONArray array =  (JSONArray)advancedSearch.get("criteria");

        for (int i = 0; i < array.size(); i++){
            JSONObject criteria = (JSONObject)array.get(i);
            String product = (String)advancedSearch.get("productName");
            System.out.println(product);
        }
*/