package com.example.assignment_3;

import android.content.Context;
import android.se.omapi.SEService;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
import java.util.Set;

public class Contacts1ListAdapter extends ArrayAdapter<Contacts1> {

    private static final String TAG= "Contacts1ListAdapter";
int mResource;
    public Contacts1ListAdapter(@NonNull Context context, int resource, List<Contacts1> Object) {
        super(context, resource,Object);
        this.context = context;
        mResource=resource;
    }

    private Context context;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name=getItem(position).getName();
        String email=getItem(position).getEmail();
        String contact=getItem(position).getNumber();
        ImageView imageView2=getItem(position).getImageView();

        Contacts1 contacts1=new Contacts1(name,email,contact,imageView2);
        LayoutInflater inflater= LayoutInflater.from(context);
        convertView=inflater.inflate(mResource,parent,false);
        TextView textView=(TextView)convertView.findViewById(R.id.textview1);
        TextView textView1=(TextView)convertView.findViewById(R.id.textview2);
        TextView textView2=(TextView)convertView.findViewById(R.id.textview3);
ImageView imageView1=(ImageView)convertView.findViewById(R.id.image1);
        textView.setText(name);
        textView1.setText(email);
        textView2.setText(contact);
        //imageView1.setImageResource();

        return convertView;
    }


}
