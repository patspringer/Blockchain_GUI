package utils;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class transactionsRequest {
    private String url = "https://blockchain.info/rawaddr/1NgXeDMaySDnUSsirhBwdnGHiED5Wbe4nN";

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
