package com.example.smartattendance;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.material.button.MaterialButton;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageView imageView = findViewById(R.id.imageView);

        MaterialButton createButton = findViewById(R.id.button3);
        MaterialButton deleteButton = findViewById(R.id.button7);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for createButton
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for deleteButton
            }
        });


        // Find the EditText with the correct ID from the layout file
        ListView list = findViewById(R.id.ListClass);

        List<String> arraylist = new ArrayList<>();
        arraylist.add("class 1");
        arraylist.add("class 2");
        arraylist.add("class 3");
        arraylist.add("class 4");
        arraylist.add("class 5");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, arraylist);
        list.setAdapter(arrayAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    //clicked on class 1
                    startActivity(new Intent(HomeActivity.this, classes.class));
                } else if (position == 1) {
                    //clicked on class 2
                } else {

                }
            }
        });

    }
}


