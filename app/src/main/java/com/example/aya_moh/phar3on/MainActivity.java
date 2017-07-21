package com.example.aya_moh.phar3on;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    private boolean result;
    private Uri Image_uri1,Image_uri2,Image_uri3,Image_uri4,Image_uri5,Image_uri6,Image_uri7,Image_uri8,Image_uri9,Image_uri10,Image_uri11,Image_uri12,Image_uri13,Image_uri14,Image_uri15,Image_uri16,Image_uri17,Image_uri18,Image_uri19,Image_uri20,Image_uri21;
    ImageButton description , scanner, photos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper dbhelper=new DatabaseHelper(this);
        DatabaseOperation dboperation=new DatabaseOperation(dbhelper);
        Cursor cursor = dboperation.getStatueData();


        Image_uri1 = Convert_to_Uri(R.drawable.ramsis1);
        Image_uri2 = Convert_to_Uri(R.drawable.ramsis2);
        Image_uri3 = Convert_to_Uri(R.drawable.ramsis3);
        Image_uri4 = Convert_to_Uri(R.drawable.montohotob1);
        Image_uri5 = Convert_to_Uri(R.drawable.montohotob2);
        Image_uri6 = Convert_to_Uri(R.drawable.montohotob3);
        Image_uri7 = Convert_to_Uri(R.drawable.ahoms1);
        Image_uri8 = Convert_to_Uri(R.drawable.ahmos2);
        Image_uri9 = Convert_to_Uri(R.drawable.ahmos3);
        Image_uri10 = Convert_to_Uri(R.drawable.sobak_hotob1);
        Image_uri11 = Convert_to_Uri(R.drawable.sobak_hotob2);
        Image_uri12 = Convert_to_Uri(R.drawable.sobak_hotob3);
        Image_uri13 = Convert_to_Uri(R.drawable.psusennes);
        Image_uri14 = Convert_to_Uri(R.drawable.psusennes1);
        Image_uri15 = Convert_to_Uri(R.drawable.psusennes2);
        Image_uri16 = Convert_to_Uri(R.drawable.ramsis3_1);
        Image_uri17 = Convert_to_Uri(R.drawable.ramsis3_2);
        Image_uri18 = Convert_to_Uri(R.drawable.ramsis3_3);
        Image_uri19 = Convert_to_Uri(R.drawable.kamos);
        Image_uri20 = Convert_to_Uri(R.drawable.kamose2);
        Image_uri21 = Convert_to_Uri(R.drawable.kamos);
        if (cursor.getCount()>0)
        {
     Toast.makeText(this,cursor.getCount()+"", Toast.LENGTH_SHORT).show();
        }else
        {
            dboperation.insert_dataTable1();
            dboperation.insertimage_to_table2(this,Image_uri1.toString(),Image_uri2.toString(),Image_uri3.toString(),Image_uri4.toString(),Image_uri5.toString(),Image_uri6.toString()
            ,Image_uri7.toString(),Image_uri8.toString(),Image_uri9.toString(),Image_uri10.toString(),Image_uri11.toString(),Image_uri12.toString()
            ,Image_uri13.toString(),Image_uri14.toString(),Image_uri15.toString(),Image_uri16.toString(),Image_uri17.toString(),Image_uri18.toString()
            ,Image_uri19.toString(),Image_uri20.toString(),Image_uri21.toString());

        }


        description= (ImageButton) findViewById(R.id.descbtn);
        scanner= (ImageButton) findViewById(R.id.scannerbtn);
        photos= (ImageButton) findViewById(R.id.photobtn);
        final Activity activity = this;
        scanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,QRscanner.class);
                startActivity(i);

            }
        });
        description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ListFamily.class);
                startActivity(i);
            }
        });
        photos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Gallary.class);
                startActivity(i);
            }
        });

    }

    private Uri Convert_to_Uri(int image_drawable)
    {
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(),image_drawable);

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        bitmap1.compress(Bitmap.CompressFormat.JPEG,100,os);
        String path = MediaStore.Images.Media.insertImage(getContentResolver(),bitmap1,"title",null);
        return Uri.parse(path);
    }
}

