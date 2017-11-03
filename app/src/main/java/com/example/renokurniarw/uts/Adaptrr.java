package com.example.renokurniarw.uts;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by RenoKurniaRW on 11/1/2017.
 */

public class Adaptrr extends RecyclerView.Adapter<Adaptrr.OwnHolder>{

    String data1[],data2[],data3[];
    int img[];
    Context ctx;

    public Adaptrr(Context ct,String s1[],String s2[],String s3[],int i1[]){
        ctx = ct;
        data1 = s1;
        data2 = s2;
        data3 = s3;
        img = i1;
    }

    @Override
    public OwnHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater myInflator = LayoutInflater.from(ctx);
        View myviewer = myInflator.inflate(R.layout.myrow,parent,false);
        return new OwnHolder(myviewer);
    }

    @Override
    public void onBindViewHolder(OwnHolder holder, int position) {
        holder.t1.setText(data1[position]);
        holder.t2.setText(data2[position]);
        holder.t3.setText(data3[position]);
        holder.imgss.setImageResource(img[position]);

    }

    @Override
    public int getItemCount() {

        return data1.length;
    }

    public class OwnHolder extends RecyclerView.ViewHolder {
        TextView t1,t2,t3;
        ImageView imgss;
        public OwnHolder(View itemView) {
            super(itemView);
            t1 = (TextView)itemView.findViewById(R.id.sender);
            t2 = (TextView)itemView.findViewById(R.id.content);
            t3 = (TextView)itemView.findViewById(R.id.date);
            imgss = (ImageView)itemView.findViewById(R.id.gambar);
        }
    }


}
