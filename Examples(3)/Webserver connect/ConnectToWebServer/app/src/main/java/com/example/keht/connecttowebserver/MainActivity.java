package com.example.keht.connecttowebserver;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;


public class MainActivity extends Activity {

    private String ip = "http://145.37.74.51";
    private int port = 8000;
    private String extension = "/data";
    private String extensionDb = "/database";
    private String urlDb = ip + ":" + port + extensionDb;
    private String urlConnect = ip + ":" + port + extension;

    private ArrayList<String> httpGetData = new ArrayList<String>();
    private Button connectButton;
    private Button dbButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectButton = (Button) findViewById(R.id.main_button);
        dbButton = (Button) findViewById(R.id.db_button);

        connectButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                makeGetRequest(urlConnect);
                // display the server response
                for (int i = 0; i < httpGetData.size(); i++) {
                    Log.d("Debug", httpGetData.get(i));
                }

            }
        });

        dbButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                makeGetRequest(urlDb);
                // display the server response
                for (int i = 0; i < httpGetData.size(); i++) {
                    Log.d("Debug", httpGetData.get(i));
                }

            }
        });
    }

    private void makeGetRequest(final String url)
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    HttpParams httpParameters = new BasicHttpParams();
                    int timeoutConnection = 3000;
                    HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);

                    HttpClient client = new DefaultHttpClient(httpParameters);
                    HttpGet request = new HttpGet(url);
                    HttpResponse response =  client.execute(request);

                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(response.getEntity().getContent()));

                    String line = null;
                    httpGetData.clear();

                    while ((line = reader.readLine()) != null)
                    {
                        Log.d("Debug",line);
                        httpGetData.add(line);
                    }
                }
                catch (Exception e)
                {
                    Log.d("Debug", e.getMessage());
                }
            }
        }).start();
    }
}
