package com.example.neha.serviceexamplenew;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private Button buttonCreate, buttonCollect, buttonDisplay;
    private EditText textRSA, textRSG;

    MyService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonCreate = (Button)findViewById(R.id.buttonCreate);
        buttonCollect = (Button)findViewById(R.id.buttonCollect);
        buttonDisplay = (Button)findViewById(R.id.buttonDisplay);
        textRSA = (EditText)findViewById(R.id.textRSA);
        textRSG = (EditText)findViewById(R.id.textRSG);

        buttonCreate.setOnClickListener(this);
        buttonCollect.setOnClickListener(this);
        buttonDisplay.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent myIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        switch (v.getId())
        {
            case R.id.buttonCreate:
                if (service != null)
                {
                    service = new MyService();
                }
                else
                {

                }
                break;
            case R.id.buttonCollect:
                if (service != null)
                {
                    service.BeginCollect();
                }
                break;
            case R.id.buttonDisplay:
                if (service != null)
                {
                    service.EndCollect();
                    textRSA.setText(service.stringRSA);
                    textRSG.setText(service.stringRSG);
                }
                break;
        }
    }
}
