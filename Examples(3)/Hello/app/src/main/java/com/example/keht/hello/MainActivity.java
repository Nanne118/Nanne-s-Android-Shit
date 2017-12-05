package com.example.keht.hello;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {

    TextView mainTextView;
    TextView mainTextView2;
    Button mainButton;
    EditText mainEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mainTextView = (TextView) findViewById(R.id.main_textview);
        mainTextView2 = (TextView) findViewById(R.id.main_textview2);
        mainEditText = (EditText) findViewById(R.id.main_edittext);


        mainTextView2.setText("Set in Java!");

        mainButton = (Button) findViewById(R.id.main_button);
        mainButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        mainTextView.setText(  mainEditText.getText());
    }
}
