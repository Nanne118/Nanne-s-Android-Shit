package com.example.keht.listviewdynamic;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mainEditText;
    Button mainButton;
    ListView mainListView;
    ArrayAdapter mArrayAdapter;
    ArrayList mNameList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainEditText = (EditText) findViewById(R.id.main_edittext);

        mainButton = (Button) findViewById(R.id.main_button);
        mainButton.setOnClickListener(this);

        mainListView = (ListView) findViewById(R.id.main_listview);
        mArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mNameList);
        mainListView.setAdapter(mArrayAdapter);
    }

    @Override
    public void onClick(View view) {
        mNameList.add(mainEditText.getText().toString());
        mArrayAdapter.notifyDataSetChanged();
    }
}
