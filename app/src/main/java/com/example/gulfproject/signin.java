package com.example.gulfproject;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class signin extends AppCompatActivity {

    Button Enter;
    EditText username;
    EditText password;
    DataBaseHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        Enter=(Button) findViewById(R.id.bn2);
        username=(EditText) findViewById(R.id.ed1);
        password=(EditText) findViewById(R.id.ed2);
        DB=new DataBaseHelper(this);


        Enter.setOnClickListener(new View.OnClickListener() {
           @Override
        public void onClick(View v) {
               String user= username.getText().toString();
               String pass= password.getText().toString();

               if (user.equals("")||pass.equals(""))
                   Toast.makeText(signin.this, "Enter All Info", Toast.LENGTH_SHORT).show();
               else{
                   Boolean checkuserpass=DB.checkusernamepassword(user,pass);
                   if (checkuserpass==true){
                       Toast.makeText(signin.this, "sign in successfully", Toast.LENGTH_SHORT).show();
                       Intent intent= new Intent(getApplicationContext(),homepage.class);
                       startActivity(intent);
                   }else {
                       Toast.makeText(signin.this, "Invalid Info", Toast.LENGTH_SHORT).show();
                   }


               }
           }


       });

    }

}