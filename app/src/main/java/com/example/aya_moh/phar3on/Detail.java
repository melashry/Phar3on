package com.example.aya_moh.phar3on;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.util.Locale;

/**
 * Created by Aya_Moh on 7/1/2017.
 */

public class Detail  extends AppCompatActivity {
    private KenBurnsView king_image;
    TextView desc;
//    Button sound;
    TextToSpeech t1;
    private FloatingActionsMenu fabBtn_menu;
    private com.getbase.floatingactionbutton.FloatingActionButton fab2;
    private FloatingActionButton fab3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        king_image      = (KenBurnsView) findViewById(R.id.kingimg);
        fabBtn_menu = (FloatingActionsMenu) findViewById(R.id.fabBtn_menu);
        fab2 = new com.getbase.floatingactionbutton.FloatingActionButton(this);
        fab2.setIcon(R.drawable.play);
        fab2.setSize(com.getbase.floatingactionbutton.FloatingActionButton.SIZE_MINI);
        fabBtn_menu.addButton(fab2);
        fab3 = new com.getbase.floatingactionbutton.FloatingActionButton(this);
        fab3.setIcon(R.drawable.stop);
        fab3.setSize(com.getbase.floatingactionbutton.FloatingActionButton.SIZE_MINI);
        fabBtn_menu.addButton(fab3);
        play(fab2);
        stop(fab3);
        desc = (TextView) findViewById(R.id.desctxt);
//        sound= (Button) findViewById(R.id.soundbtn);
        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });
//                sound.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        String dtoSpeak = desc.getText().toString();
//                        t1.speak(dtoSpeak, TextToSpeech.QUEUE_FLUSH, null);
//
//                    }
//                });

                    desc.setText(R.string.first1a);


    }

    @Override
    protected void onStart()
    {
        super.onStart();
    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        Intent i = new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_HOME);
        startActivity(i);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.arabic:

                desc.setText(R.string.first1a);

                break;
            case R.id.english:
                desc.setText(R.string.first1e);

                break;
            case R.id.french:
                desc.setText(R.string.first2e);

                break;

        }
        return super.onOptionsItemSelected(item);
    }
    private void play(com.getbase.floatingactionbutton.FloatingActionButton fab2)
    {
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String dtoSpeak = desc.getText().toString();
                t1.speak(dtoSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });}
    private void stop(com.getbase.floatingactionbutton.FloatingActionButton fab3)
    {
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPause();

            }
        });

    }
    public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }

}

