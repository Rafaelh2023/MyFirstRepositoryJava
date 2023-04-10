package Utilities;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JsonReader {
    public JSONObject json;
    public String jsonFile = "";
    //public String path;

    public JsonReader () {
       // this.path = path;
        this.json = readJson();
    }


    public JSONObject readJson(){
        String tmpPath = Base.UtilsDriver.JOSONFILE;
        try(BufferedReader r = new BufferedReader(new FileReader(tmpPath))) {
            String linea;
            while((linea = r.readLine()) != null)
                this.jsonFile += linea;
        } catch (IOException e) {
            this.jsonFile = "{}";
            System.err.println("I couldn't read the file ...");
        }
        return new JSONObject(this.jsonFile);

    }

    public static void main(String[] args) {
        JsonReader reader = new JsonReader();
        System.out.println(reader.readJson());
    }
}
