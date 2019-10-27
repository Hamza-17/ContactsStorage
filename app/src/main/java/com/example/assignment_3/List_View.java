package com.example.assignment_3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class List_View extends AppCompatActivity {
    ArrayList<Contacts1> contacts1s=new ArrayList<>();
    private static final String TAG="List_View";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        Log.d(TAG,"onCreate: Started");
        ListView mlistView=(ListView) findViewById(R.id.listview);



        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED){

            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS},1);
        }
        else{

            getcontact();
        }


        Contacts1ListAdapter adapter = new Contacts1ListAdapter(this,R.layout.adapter_view,contacts1s);
        mlistView.setAdapter(adapter);
    }

    private void getcontact() {

        Cursor cursor= getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
        while (cursor.moveToNext()){

            String name=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String mobile=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            String email="Not Available";
            ImageView imageView=(ImageView)findViewById(R.id.image1);
           // imageView.setImageResource(R.drawable.profile);
            Contacts1 c=new Contacts1(name,mobile,email,imageView);
            contacts1s.add(c);

            //arrayList.add(name+ "     " + mobile +  "\n");
            //tv_phonebook.setText(arrayList.toString());
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==1){

            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){

                getcontact();

            }
        }
    }


    public void btn_ViewContact(View view) {


        startActivity(new Intent(getApplicationContext(),ViewContact.class));


    }







}













