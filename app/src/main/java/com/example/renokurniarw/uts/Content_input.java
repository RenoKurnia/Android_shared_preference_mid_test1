package com.example.renokurniarw.uts;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Content_input extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_input);
    }

    public void Save(View view) {

        SharedPreferences sp = getSharedPreferences(MainActivity.sp1,0);
        TextView t1 =(TextView)findViewById(R.id.pengirimText);
        TextView t2 = (TextView)findViewById(R.id.isiText);
        String s1 = t1.toString();
        String s2 = t2.toString();
        String smain = sp.getString("sender","noname");
        Converter conv = new Converter(smain,s1,s2);
        SharedPreferences.Editor edit = getSharedPreferences(MainActivity.sp1,0).edit();
        edit.putString("sender",conv.getValue());
        edit.apply();
        Intent it = new Intent(this,MainActivity.class);
        startActivity(it);
    }

}
