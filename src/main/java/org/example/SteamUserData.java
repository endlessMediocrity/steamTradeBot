package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SteamUserData extends SteamUser {

    private String steamid;

    public SteamUserData(String steamid) {
        super(steamid);
    }


    public StringBuffer getAllUserData() {
        String url = "https://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key=" + api_key +"&steamids=" + steamid;
        StringBuffer response = new StringBuffer();
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            response.append("GET Response Code :: ").append(responseCode).append("\n");
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
            } else {
                response.append("Connection Exception");
            }
            con.disconnect();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return response;
    }
}
