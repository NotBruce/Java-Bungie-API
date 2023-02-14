package app.raidhub.JBA.utils;

import app.raidhub.JBA.JBA;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

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
            return (JsonObject) ((JsonObject) parser.parse(response)).get("Response").getAsJsonObject();
        } catch (IOException ioException) {
            return null;
        }
    }

    public static JsonObject POST(String url, String code) {
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            String rawData = "code=" + code;
            String type = "application/x-www-form-urlencoded";
            String encodedData = URLEncoder.encode( rawData, "UTF-8" );
            con.setRequestMethod("POST");
            con.addRequestProperty("Authorization", "Basic ");
            con.setRequestProperty("X-API-KEY", JBA.getApiKey());
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)");
            con.setRequestProperty( "Content-Type", type );
            con.setRequestProperty( "Content-Length", String.valueOf(encodedData.length()));
            OutputStream os = con.getOutputStream();
            os.write(encodedData.getBytes());
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
            return (JsonObject) ((JsonObject) parser.parse(response)).get("Response").getAsJsonObject();
        } catch (IOException ioException) {
            return null;
        }
    }
}
