package com.example.aya_moh.phar3on;


import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class Testing extends AppCompatActivity {
    String image_uri1,image_uri2,image_uri3;
    String scanFormat;
    ImageView Statue_image1,Statue_image2,Statue_image3;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);
        Statue_image1 = (ImageView) findViewById(R.id.statue_image1);
        Statue_image2 = (ImageView) findViewById(R.id.statue_image2);
        Statue_image3 = (ImageView) findViewById(R.id.statue_image3);

        textView      = (TextView) findViewById(R.id.text);
        DatabaseHelper helper = new DatabaseHelper(this);
        DatabaseOperation dbOperation = new DatabaseOperation(helper);


        Intent intent = getIntent();
        if (intent !=null)
        {
            scanFormat = intent.getStringExtra("STname");
            StatusModel mstatusModel = (StatusModel) intent.getSerializableExtra("STdescription");
            if (scanFormat ==null||scanFormat=="")
            {

            }
            else {
                Cursor cursor = dbOperation.getStatue_image(scanFormat.toString());
                if (cursor.getCount()>0)
                {
                    while (cursor.moveToNext())
                    {
                        Toast.makeText(this, cursor.getString(4).toString(), Toast.LENGTH_SHORT).show();
                        image_uri1 = cursor.getString(2).toString();
                        image_uri2 = cursor.getString(3).toString();
                        image_uri3 = cursor.getString(4).toString();


                    }


                    textView.setText(scanFormat.toString());
                    Picasso.with(this).load(Uri.parse(image_uri1.toString())).into(Statue_image1);
                    Picasso.with(this).load(Uri.parse(image_uri2.toString())).into(Statue_image2);
                    Picasso.with(this).load(Uri.parse(image_uri3.toString())).into(Statue_image3);
                    Toast.makeText(this,cursor.getCount()+"", Toast.LENGTH_SHORT).show();

                }
                else
                {


                }
                Toast.makeText(this,scanFormat+"\n"+mstatusModel.getName()+"\n"+mstatusModel.getADscription()+"\n"+mstatusModel.getEDscription()+"\n"+mstatusModel.getFDscription()+cursor.getCount()+"", Toast.LENGTH_SHORT).show();
                Log.e("dddddddddddd",String.valueOf(cursor.getCount()));
            }

        }



    }
}
