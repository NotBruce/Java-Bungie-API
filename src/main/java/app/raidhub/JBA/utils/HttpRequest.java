package app.raidhub.JBA.utils;

import app.raidhub.JBA.JBA;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequest {

    /**
     * @param url required url to send request
     * @return Response from Request URL
     * TODO: Exceptions for Bungie API
     */
    public static JsonObject GET(String url) {
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-API-KEY", JBA.getApiKey());
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)");
            int responseCode = con.getResponseCode();

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            String response = "";

            while ((inputLine = in.readLine()) != null) {
                response += inputLine;
            }

            in.close();
            JsonParser parser = new JsonParser();
            JsonObject json = (JsonObject) parser.parse(response);
            return (JsonObject) parser.parse(response);
        } catch (IOException ioException) {
            return null;
        }
    }
}
