package com.example.keht.progressdialog;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button mainButton;
    ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainButton = (Button) findViewById(R.id.main_button);
        mainButton.setOnClickListener(this);

        mDialog = new ProgressDialog(this);
        mDialog.setMessage("Please wait…");
        mDialog.setCancelable(false);
        mDialog.setProgress(0);
        mDialog.setMax(100);

    }

    @Override
    public void onClick(View view) {
        mDialog.show();

        new Thread(new Runnable() {
            @Override
            public void run() {
            for(int i =0 ; i < 100; i++)
            {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                    mDialog.incrementProgressBy(1);

            }
                mDialog.dismiss();
            }
        }).start();
    }
}
