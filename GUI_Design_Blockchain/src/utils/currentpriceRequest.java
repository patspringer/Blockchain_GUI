package utils;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.net.URL;
import java.io.IOException;
import java.io.InputStreamReader;

public class currentpriceRequest {
    private String url = "https://blockchain.info/ticker";

    public String get() throws IOException{

        URL urlObj = new URL(url);

        HttpsURLConnection connection = (HttpsURLConnection) urlObj.openConnection();

        connection.setRequestMethod("GET");
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String json = "";
        StringBuffer response = new StringBuffer();
        while ((json = br.readLine()) != null)
        {
            response.append(json);
        }

        return response.toString();
    }
}
