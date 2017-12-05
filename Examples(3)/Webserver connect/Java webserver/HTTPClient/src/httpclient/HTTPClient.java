package httpclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author Crunchify.com
 */

public class HTTPClient {
    
    private final static int port = 8000;
    private final static String ip = "145.37.74.16";
    
    public static void main(String[] args) {
        try {
            URL url = new URL("http://" + ip + ":" + port + "/data");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String strTemp = "";
            while (null != (strTemp = br.readLine())) {
                System.out.println(strTemp);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}