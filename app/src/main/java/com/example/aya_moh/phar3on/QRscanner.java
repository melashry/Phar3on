package com.example.aya_moh.phar3on;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Aya_Moh on 7/2/2017.
 */
public class QRscanner extends AppCompatActivity {
    private FloatingActionButton mScanButton;
    private TextView mScanDataTextView;
    private static final int SCAN_INTENT = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrscanner);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mScanButton = (FloatingActionButton) findViewById(R.id.scan_button);
        mScanDataTextView = (TextView) findViewById(R.id.scan_data);

        mScanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getBaseContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(QRscanner.this, new String[]{Manifest.permission.CAMERA}, 0);
                } else {

                    Intent intent = new Intent(QRscanner.this, Scan.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 0:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission allowed successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(QRscanner.this, Scan.class);
                    startActivityForResult(intent, SCAN_INTENT);
                } else {
                    Toast.makeText(this, "You need to accept read sms permission first," +
                            " \n go to app settings and allow them.", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

}

