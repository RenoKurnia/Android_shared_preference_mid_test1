package com.example.renokurniarw.uts;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by RenoKurniaRW on 11/3/2017.
 */

public class Converter {
    private String value;
    public Converter(String s,String input1,String input2){

        int length = s.length()-1,i=0;
        StringBuilder sb = new StringBuilder();
        char[] temp = new char[length];
        String tempo = ",{\"name\":\""+input1+"\",\"sender\":\""+input2+"\"}]";
        temp = s.toCharArray();
        while(i<length){
            sb.append(temp[i]);
            i++;
        }
        value = sb.toString()+tempo;
        Log.i("name value here",value);

    }

    public String getValue() {
        return value;
    }
}
