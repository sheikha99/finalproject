package com.example.gulfproject;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class orderpage extends AppCompatActivity {
    EditText amount, name;
    Button delete, insert, update, view, save;
    DBHelper db;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderpage);
        amount = findViewById(R.id.edit11);
        name = findViewById(R.id.edit777);

        delete = findViewById(R.id.b4);
        insert = findViewById(R.id.b8);
        update = findViewById(R.id.b3);
        view = findViewById(R.id.b5);
        save = findViewById(R.id.button);

        db = new DBHelper(this);



        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String am = amount.getText().toString();
                String nm = name.getText().toString();

                Boolean checkinsertdata = db.insertItemsData(am,nm);
                if (checkinsertdata == true) {
                    Toast.makeText(orderpage.this, "new entry inserted", Toast.LENGTH_SHORT).show();

                }else
                    Toast.makeText(orderpage.this, "new entry not inserted", Toast.LENGTH_SHORT).show();


            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String am= amount.getText().toString();
                String nm= name.getText().toString();

                Boolean checkupdatedata = db.updateItemsData(am,nm);
                if (checkupdatedata==true) {
                    Toast.makeText(orderpage.this, " entry updated", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(orderpage.this, "entry not updated", Toast.LENGTH_SHORT).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String am= amount.getText().toString();


                Boolean checkdeletedata = db.deleteItemsData(am);
                if (checkdeletedata==true) {
                    Toast.makeText(orderpage.this, " entry deleted", Toast.LENGTH_SHORT).show();
                }  else
                    Toast.makeText(orderpage.this, "entry not deleted", Toast.LENGTH_SHORT).show();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res= db.getData();
                if (res.getCount()==0){
                    Toast.makeText(orderpage.this, "no entry exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("amount :"+res.getString(0)+"\n");
                    buffer.append("name :"+res.getString(1)+"\n\n");
                }
                AlertDialog.Builder builder= new AlertDialog.Builder(orderpage.this);
                builder.setCancelable(true);
                builder.setTitle("user entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), contactpage.class);
                startActivity(intent);
            }
        });




    }
}