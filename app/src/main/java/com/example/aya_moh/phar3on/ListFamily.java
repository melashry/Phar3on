package com.example.aya_moh.phar3on;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Aya_Moh on 7/1/2017.
 */


public class ListFamily extends AppCompatActivity {
  public static   int x =0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listfamily);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        SetupListView();

       // loadScreen();

    }

//    private void loadScreen(){
//
//
//    }
    private void SetupListView()
    {

        final  String[] Families = getResources().getStringArray(R.array.families_names);

        ArrayAdapter<String> listItemAdapter
                = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                Families);
        ListView lv = (ListView)this.findViewById(R.id.myListView);
        lv.setAdapter(listItemAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                if (position==0){
                    Toast.makeText(getApplicationContext(),
                            ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
                    x= 1;
                    Intent i = new Intent(getApplicationContext(), Listmlk.class);
                    startActivity(i);}
                // When clicked, show a toast with the TextView text
                Toast.makeText(getApplicationContext(),
                        "22222222222222222", Toast.LENGTH_SHORT).show();

            }
        });
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}






/*public class ListFamily extends ListActivity {
public static int x;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // no more this
        // setContentView(R.layout.activity_listfamily);
        final  String[] Families = getResources().getStringArray(R.array.families_names);

        setListAdapter(new ArrayAdapter<String>(this, R.layout.item,Families));

        ListView listView = getListView();
        listView.setTextFilterEnabled(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                if (position==0){
                    Toast.makeText(getApplicationContext(),
                            ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
                    x= 1;}
                // When clicked, show a toast with the TextView text
                Toast.makeText(getApplicationContext(),
                        "22222222222222222", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), Listmlk.class);
                startActivity(i);
            }
        });

    }

}*/