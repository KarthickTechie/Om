package com.apps.karthick.om;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView mLyricTxt;
    String selectedLanguage="";
    private Resources resources;
    private InputStream iS;
    private ByteArrayOutputStream oS;
    private int[]englishLyrics = {R.raw.english};
    private int[]kannadaLyrics = {R.raw.kannada};
    private int[]malayalamLyrics = {R.raw.malayalam};
    private int[]sanskritLyrics = {R.raw.sanskrit};
    private int[]tamilLyrics = {R.raw.tamil};
    private int[]teluguLyrics = {R.raw.telugu};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resources = getResources();
        mLyricTxt = (TextView)findViewById(R.id.lyricsTextView);
        toolbar= (Toolbar) findViewById(R.id.id_appBar);
        setSupportActionBar(toolbar);

        //setSupportActionBar(toolbar);


    }

    public String updateTextView(int mValue) throws IOException {
        iS = resources.openRawResource(mValue);
        byte[] buffer = new byte[iS.available()];
        //read the text file as a stream, into the buffer
        iS.read(buffer);
        oS = new ByteArrayOutputStream();
        //write this buffer to the output stream
        oS.write(buffer);
        //Close the Input and Output streams
        oS.close();
        iS.close();
        return oS.toString();

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

        if (id == R.id.action_next) {
            /*
            Toast.makeText(getApplicationContext(),"Clickeed",Toast.LENGTH_SHORT).show();
            Intent in = new Intent(this,SecondActivity.class);
            startActivity(in);
            */
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Select language");
            builder.setItems(R.array.languages, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    switch (which) {
                        case 0:
                            //Toast.makeText(getApplicationContext(), "Language  :  English", Toast.LENGTH_SHORT).show();
                            try {
                                mLyricTxt.setText(updateTextView(englishLyrics[0]));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            break;
                        case 1:

                            try {
                                mLyricTxt.setText(updateTextView(kannadaLyrics[0]));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case 2:

                            try {
                                mLyricTxt.setText(updateTextView(malayalamLyrics[0]));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case 3:

                            try {
                                mLyricTxt.setText(updateTextView(sanskritLyrics[0]));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case 4:

                            try {
                                mLyricTxt.setText(updateTextView(tamilLyrics[0]));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case 5:

                            try {
                                mLyricTxt.setText(updateTextView(teluguLyrics[0]));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;

                    }
                }
            });

            builder.create().show();

        }
        return true;
    }
}
