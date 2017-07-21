package com.example.aya_moh.phar3on;

import android.app.ActionBar;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;


public class Slider extends ActionBarActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {
   static String x;
    private SliderLayout mDemoSlider;
    TextView name, desc;
    String image_uri1,image_uri2,image_uri3;
    TextToSpeech t1;
    private FloatingActionsMenu fabBtn_menu;
    private com.getbase.floatingactionbutton.FloatingActionButton fab2;
    private FloatingActionButton fab3;
    String scanFormat;
    StatusModel mstatusModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//       setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
        mDemoSlider = (SliderLayout) findViewById(R.id.slider);
        name = (TextView) findViewById(R.id.list_item_name);
        desc = (TextView) findViewById(R.id.list_item_desc);
//        play = (Button) findViewById(R.id.playbtn);
     //  stop = (Button) findViewById(R.id.stopbtn);


//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Slider.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });
        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });
//        play.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String ntoSpeak = name.getText().toString();
//                String dtoSpeak = desc.getText().toString();
//                Toast.makeText(getApplicationContext(), ntoSpeak, Toast.LENGTH_SHORT).show();
//                t1.speak(ntoSpeak, TextToSpeech.QUEUE_FLUSH, null);
//                t1.speak(dtoSpeak, TextToSpeech.QUEUE_FLUSH, null);
//
//            }
//        });
//        stop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onPause();
//            }
//        });

//        HashMap<String,String> url_maps = new HashMap<String, String>();
//        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
//        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
//        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
//        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");
        DatabaseHelper helper = new DatabaseHelper(this);
        DatabaseOperation dbOperation = new DatabaseOperation(helper);
        Intent intent = getIntent();

        if (intent !=null)
        {
            scanFormat = intent.getStringExtra("STname");
             mstatusModel = (StatusModel) intent.getSerializableExtra("STdescription");
            Toast.makeText(this,mstatusModel.getADscription(),Toast.LENGTH_LONG).show();
            if (scanFormat ==null||scanFormat=="")
            {

            }
            else {
                name.setText(mstatusModel.getName());
                desc.setText(mstatusModel.getADscription());
                Cursor cursor = dbOperation.getStatue_image(scanFormat.toString());

                if (cursor.getCount()>0)
                {
                    List<Map<String,String>> mapList = new ArrayList<>();

                    while (cursor.moveToNext())
                    {

                        Toast.makeText(this, cursor.getString(4).toString(), Toast.LENGTH_SHORT).show();
                        HashMap<String, String> file_maps = new HashMap<String, String>();
                        HashMap<String, String> file_maps1 = new HashMap<String, String>();
                        HashMap<String, String> file_maps2 = new HashMap<String, String>();
                        file_maps.put(cursor.getString(1),cursor.getString(2));
                        file_maps1.put(cursor.getString(1),cursor.getString(3));
                        file_maps2.put(cursor.getString(1),cursor.getString(4));

                        getimage(file_maps);
                        getimage(file_maps1);
                        getimage(file_maps2);


                      //  file_maps.put(cursor.getString(1), list);
//                        file_maps.put(cursor.getString(1), cursor.getString(3).toString());
//                        file_maps.put(cursor.getString(1), cursor.getString(4).toString());
//                        mapList.add(0,);

                       /* Picasso.with(this).load(Uri.parse(image_uri1.toString())).into((Target) mDemoSlider);
                        Picasso.with(this).load(Uri.parse(image_uri2.toString())).into((Target) mDemoSlider);
                        Picasso.with(this).load(Uri.parse(image_uri3.toString())).into((Target) mDemoSlider);*/

                      /*  for (int i=0;i<3;i++) {


                            TextSliderView textSliderView = new TextSliderView(this);
                            // initialize a SliderLayout
                            textSliderView
                                    .description(String.valueOf(cursor.getString(1)))
                                    .image("Ramsis Elsales")
                                    .setScaleType(BaseSliderView.ScaleType.Fit)
                                    .setOnSliderClickListener(this);

                            //add your extra information
                            textSliderView.bundle(new Bundle());
                            textSliderView.getBundle()
                                    .putString("extra", String.valueOf(name));

                            mDemoSlider.addSlider(textSliderView);
                        }*/
                    }


                    name.setText(scanFormat.toString());
//                    Picasso.with(this).load(Uri.parse(cursor.getString(2).toString())).into(Statue_image1);
//                    Picasso.with(this).load(Uri.parse(cursor.getString(3).toString())).into(Statue_image2);
//                    Picasso.with(this).load(Uri.parse(cursor.getString(4).toString())).into(Statue_image3);

                }
                else
                {


                }
          //      Toast.makeText(this,scanFormat+"\n"+mstatusModel.getName()+"\n"+mstatusModel.getADscription()+"\n"+mstatusModel.getEDscription()+"\n"+mstatusModel.getFDscription(), Toast.LENGTH_SHORT).show();
                String scanFormat = intent.getStringExtra("STname");
           //     mstatusModel = (StatusModel) intent.getSerializableExtra("STdescription");
                //  Toast.makeText(this, scanFormat + "\n" + mstatusModel.getName() + "\n" + mstatusModel.getADscription() + "\n", Toast.LENGTH_SHORT).show();
                name.setText(mstatusModel.getName());
                desc.setText(mstatusModel.getADscription());
            }

        }




//        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
//        file_maps.put("تمثال رع", R.drawable.a1);
//        file_maps.put("تمثال امون", R.drawable.a2);
//        file_maps.put("تمثال", R.drawable.a3);

//        for (String name : file_maps.keySet()) {
//            TextSliderView textSliderView = new TextSliderView(this);
//            // initialize a SliderLayout
//            textSliderView
//                    .description(name)
//                    .image(file_maps.get(name))
//                    .setScaleType(BaseSliderView.ScaleType.Fit)
//                    .setOnSliderClickListener(this);
//
//            //add your extra information
//            textSliderView.bundle(new Bundle());
//            textSliderView.getBundle()
//                    .putString("extra", name);
//
//            mDemoSlider.addSlider(textSliderView);
//        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(3000);
        mDemoSlider.addOnPageChangeListener(this);
//        ListView l = (ListView)findViewById(R.id.transformers);
//        l.setAdapter(new Adapter(this));
//        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                mDemoSlider.setPresetTransformer(((TextView) view).getText().toString());
//                Toast.makeText(MainActivity.this, ((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();
//            }
//        });


    }
    private  void  getimage (HashMap<String,String> map){

        HashMap<String,String> list=map;

            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView

                    .image(list.get(scanFormat.toString()))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", String.valueOf(name));

            mDemoSlider.addSlider(textSliderView);

    }
    private void play(com.getbase.floatingactionbutton.FloatingActionButton fab2)
    {
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String dtoSpeak = desc.getText().toString();
                Toast.makeText(getApplicationContext(), dtoSpeak, Toast.LENGTH_SHORT).show();
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
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }

//    @Override
//    public void onSliderClick(BaseSliderView slider) {
//        Toast.makeText(this, slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = getIntent();
       // StatusModel mstatusModel = (StatusModel) intent.getSerializableExtra("STdescription");

        switch (item.getItemId()) {
            case R.id.arabic:

                desc.setText(mstatusModel.getADscription());

                break;
            case R.id.english:
                desc.setText(mstatusModel.getEDscription());

                break;
            case R.id.french:
                desc.setText(mstatusModel.getFDscription());

                break;

        }
        return super.onOptionsItemSelected(item);
    }




    public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}