package com.example.aya_moh.phar3on;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Aya_Moh on 7/1/2017.
 */

public class Listmlk extends AppCompatActivity {

    public static int s;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadScreen();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void loadScreen(){
        setContentView(R.layout.activity_listmlk);
        SetupListView();

    }
    private void SetupListView()
    {

        final  String[] Families = getResources().getStringArray(R.array.first);

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
                // When clicked, show a toast with the TextView text
                if (position==0){
                    s=1;
                    Toast.makeText(getApplicationContext(),
                            ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), Detail.class);
                    startActivity(i);}

            }
        });

    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}




      /*  ListActivity {
public static int s;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // no more this
        // setContentView(R.layout.list_fruit);
        if (ListFamily.x==1){

            final  String[] First = getResources().getStringArray(R.array.first);

        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_listmlk,First));

        ListView listView = getListView();
        listView.setTextFilterEnabled(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                if (position==0){
                    s=1;
                Toast.makeText(getApplicationContext(),
                        ((TextView) view).getText(), Toast.LENGTH_SHORT).show();}
                Intent i = new Intent(getApplicationContext(), Detail.class);
                startActivity(i);
            }
        });

    }}

}
*/