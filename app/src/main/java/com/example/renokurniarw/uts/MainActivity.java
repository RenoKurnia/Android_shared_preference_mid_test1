package com.example.renokurniarw.uts;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sp;
    static final String sp1="preference";
    static int count=0;
    RecyclerView r1;
    Adaptrr ad;
    static String s1[],s2[],s3[];
    int img[] = {R.drawable.imagerate};
    JSONArray jsonarray;
    public MainActivity() throws JSONException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences(sp1,0);
        try {
            jsonarray = new JSONArray(sp.getString("sender","noname"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            prefrencestart();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        r1 = (RecyclerView)findViewById(R.id.recylcerView);
        ad = new Adaptrr(this, s1,s2,s3,img);
        r1.setAdapter(ad);
        r1.setLayoutManager(new LinearLayoutManager(this));

    }
    public void prefrencestart() throws JSONException {
        s1 = new String[jsonarray.length()];
        s2 = new String[jsonarray.length()];
        s3 = new String[jsonarray.length()];
        for(int i=0; i<jsonarray.length(); i++){
            JSONObject obj = jsonarray.getJSONObject(i);
            String name = obj.getString("name");
            String url = obj.getString("sender");
            Log.i("Value url",url);
            s1[i] = name;
            s2[i] = url;
            s3[i] = String.valueOf(i)+"-10-2017";
        }
        for(int i=0; i<jsonarray.length(); i++){
            Log.i("Name here",s1[i]);
            Log.i("Value here",s2[i]);
        }
    }
    public void Sending(View v){
        Intent it = new Intent(this,Content_input.class);
        startActivity(it);
    }

}
