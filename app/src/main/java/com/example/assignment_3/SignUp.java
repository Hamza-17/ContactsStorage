package com.example.assignment_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    EditText username;
    EditText password;
    CheckBox remember;
    Button login;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username=findViewById(R.id.username1);
        password=findViewById(R.id.password1);
        remember=findViewById(R.id.checkbox1);
        login=findViewById(R.id.button1);
        SharedPreferences preferences=getSharedPreferences("checkbox",MODE_PRIVATE);
String checkbox=preferences.getString("remember","");
if(checkbox.equals("true")){
    Intent intent=new Intent(SignUp.this,HomePage.class);
    startActivity(intent);

}

else if(checkbox.equals("false")){

    Toast.makeText(this,"Please sign in",Toast.LENGTH_SHORT).show();
}


login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(SignUp.this,HomePage.class);
        startActivity(intent);
    }
});



        remember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){

                    SharedPreferences sharedPreferences=getSharedPreferences("checkbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("remember","true");
                    editor.apply();
                    Toast.makeText(SignUp.this,"Checked",Toast.LENGTH_SHORT).show();

                }

                else if(!compoundButton.isChecked()){
                    SharedPreferences sharedPreferences=getSharedPreferences("checkbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("remember","false");
                    editor.apply();
                    Toast.makeText(SignUp.this,"Unchecked",Toast.LENGTH_SHORT).show();


                }
            }
        });


    }




}
