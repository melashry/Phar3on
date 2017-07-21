package com.example.aya_moh.phar3on;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.zxing.Result;

import java.io.Serializable;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by Aya_Moh on 7/2/2017.
 */

public class Scan extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;
    private StatusModel statusModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view
        setContentView(mScannerView);
        statusModel = new StatusModel();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }


    @Override
    public void handleResult(Result result) {
        String scanResult = result.getText().toString();
        String scanFormat = result.getBarcodeFormat().toString();
        Toast.makeText(this, scanResult, Toast.LENGTH_LONG).show();
        //Intent intent = new Intent(getBaseContext(),Sliderr.class);
        /*Intent intent = new Intent(getBaseContext(),Test.class);
        intent.putExtra("scan_result", scanResult);
        intent.putExtra("scan_format", scanFormat);
        setResult(RESULT_OK, intent);
        startActivity(intent);
     */  // Toast.makeText(this, "hhhhhhhhhhhhhh", Toast.LENGTH_LONG).show();
        //Intent i = new Intent(Scan.this, Sliderr.class);
        Intent i = new Intent(Scan.this, Slider.class);
        DatabaseHelper dbhelper=new DatabaseHelper(this);
        DatabaseOperation dboperation=new DatabaseOperation(dbhelper);
        Cursor description = dboperation.getStatueDescription(scanResult.toString());
        if (description.getCount()>0){
        while (description.moveToNext())
            {

                statusModel.setName(description.getString(description.getColumnIndex(DatabaseHelper.NAME)));
                statusModel.setADscription(description.getString(2));
                statusModel.setEDscription(description.getString(3));
                statusModel.setFDscription(description.getString(4));

            }
        }

        i.putExtra("STname", scanResult);
        i.putExtra("STdescription", (Serializable)statusModel);
        startActivity(i);

         /*DatabaseHelper dbhelper=new DatabaseHelper(this);
        DatabaseOperation dboperation=new DatabaseOperation(dbhelper);
        Cursor description = dboperation.getStatueDescription(scanResult);
       */ //
        mScannerView.stopCamera();
        finish();

    }


}