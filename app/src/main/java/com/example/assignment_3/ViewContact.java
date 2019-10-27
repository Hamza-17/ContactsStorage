package com.example.assignment_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ViewContact extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contact);
        TextView username1 = (TextView)findViewById(R.id.textview11);
        TextView username = (TextView)findViewById(R.id.textview1);
       // String user=username.getText().toString();
       // username1.setText(user);
username1.setText("whada");



    }
}
