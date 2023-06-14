package com.example.gulfproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class signup extends AppCompatActivity {

    EditText username, password, repassword;
    Button signup, signin;
    DataBaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = (EditText) findViewById(R.id.et1);
        password = (EditText) findViewById(R.id.et4);
        repassword = (EditText) findViewById(R.id.et5);
        signup = (Button) findViewById(R.id.bnt1);
        signin = (Button) findViewById(R.id.bnt2);
        DB=new DataBaseHelper(this);


         signup.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String user= username.getText().toString();
                 String pass= password.getText().toString();
                 String repass= repassword.getText().toString();
                 if (user.equals("")||pass.equals("")||repass.equals(""))
                     Toast.makeText(signup.this, "Enter All Info", Toast.LENGTH_SHORT).show();
                 else{
                     if (pass.equals(repass)){
                         Boolean checkuser = DB.checkusername(user);
                         if (checkuser==false){
                             Boolean insert=DB.insertData(user, pass);
                             if (insert==true){
                                 Toast.makeText(signup.this, "Enter successfully", Toast.LENGTH_SHORT).show();
                                 Intent intent = new Intent(getApplicationContext(),signin.class);
                                 startActivity(intent);
                             }else {
                                 Toast.makeText(signup.this, "Enter is failed", Toast.LENGTH_SHORT).show();
                             }
                         }
                         else{
                             Toast.makeText(signup.this, "already Enterd please signin", Toast.LENGTH_SHORT).show();
                         }
                     }else {
                         Toast.makeText(signup.this, "password not matching ", Toast.LENGTH_SHORT).show();
                     }
                 }


             }
         });


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), signin.class);
                startActivity(intent);
            }

        });


       }

    }