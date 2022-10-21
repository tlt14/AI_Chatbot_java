package Server;


import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Weather {
    public JSONObject getInfoWether(String address){
        JSONObject result = null;
        try {
            String url_request = "https://api.weatherapi.com/v1/forecast.json?key=8d085b09eaec46be9f9125048220710&q="+address+"&days=3&lang=vi";
            Document doc =  Jsoup.connect(url_request).ignoreContentType(true).get();

            result = new JSONObject(doc.body().ownText());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public JSONObject result (String addr){
//        if(!addr.equals("")){
            return getInfoWether(addr);
//        }
    }
    public static void main(String[] args) {
        Weather m =new Weather();
        System.out.println(m.result("Pleiku"));
    }
}
