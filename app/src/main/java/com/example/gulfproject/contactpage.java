package com.example.gulfproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class contactpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactpage);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        Toast.makeText(this, "Selected Item" + item.getTitle(), Toast.LENGTH_LONG).show();
        switch (item.getItemId()) {
            case R.id.edd:
                Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                return true;

            case R.id.eed:
                Intent intent1 =new Intent(getApplicationContext(),homepage.class);
                startActivity(intent1);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
        }
    }