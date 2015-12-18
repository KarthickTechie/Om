package com.apps.karthick.om;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.home)
        {
            //Intent intent = new Intent(this,MainActivity.class);
            //startActivity(intent);
            Toast.makeText(this,"Back Button Clicked",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
