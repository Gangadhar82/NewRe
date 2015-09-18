package com.mmadapps.newre;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

import static android.R.layout.simple_expandable_list_item_1;

public class MainActivity extends AppCompatActivity {
    private static final String END_POINT="http://restcountries.eu/rest/";
    TextView textView,textView1,textView2,textView3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= (TextView) findViewById(R.id.textview);
        textView1= (TextView) findViewById(R.id.textView1);
        textView2= (TextView) findViewById(R.id.textView2);
        textView3= (TextView) findViewById(R.id.textView3);



        //listview= (ListView) findViewById(R.id.listView);
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(END_POINT)
                .build();
        CountrieAPI api = restAdapter.create(CountrieAPI.class);
        api.GetCountries("capital","The Valley", new Callback<List<Country>>() {
            @Override
            public void success(List<Country> countries, Response response) {
                //Toast.makeText(getBaseContext(),"country name is\t"+countries.get(0).name,Toast.LENGTH_LONG).show();
                textView.setText("country name is:\t"+countries.get(0).name);
                textView1.setText("Area is:\t"+countries.get(0).area);
                textView2.setText("native:\t" + countries.get(0).nativeName);
               textView3.setText("translations:\t"+countries.get(0).trans.de+"/t"+countries.get(0).trans.es+countries.get(0).trans.ja);
            }

            @Override
            public void failure(RetrofitError error) {
                String str;
               str= error.toString();
                Toast.makeText(getBaseContext(),"Retrofit Error"+str,Toast.LENGTH_LONG).show();
                Log.d("Bhaskar",error.toString());

            }
        });


    }}
