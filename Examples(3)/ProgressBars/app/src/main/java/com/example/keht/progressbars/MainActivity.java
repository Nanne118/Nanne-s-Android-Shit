package com.example.keht.progressbars;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button mainButton;
    private ProgressDialog mProgress;
    private int mProgressStatus = 0;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainButton = (Button) findViewById(R.id.main_button);
        mainButton.setOnClickListener(this);

        mProgress= new ProgressDialog(this);
        mProgress.setProgress(100);
        mProgress.setMax(200);
        mProgress.setMessage("Its loading....");
        mProgress.setTitle("ProgressDialog bar example");
        mProgress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
    }

    @Override
    public void onClick(View view) {
        mProgress.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (mProgress.getProgress() <= mProgress.getMax()) {
                        Thread.sleep(1000);
                        mHandler.post(new Runnable() {
                            public void run() {
                                mProgress.();
                            }
                        });
                        if (mProgress.getProgress() == mProgress.getMax()) {
                            mProgress.dismiss();
                        }
                    }
                } catch (Exception e) {
                }
            }
        }).start();

    }
}
