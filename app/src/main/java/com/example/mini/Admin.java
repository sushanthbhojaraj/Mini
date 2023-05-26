package com.example.mini;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Admin extends AppCompatActivity {


    String s1;

    TextView t1;
ArrayList<String> bldary;
    ArrayAdapter<String> adapter;
    Spinner sp;

    DataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        bldary=new ArrayList<>();
        sp=findViewById(R.id.spinner2);
        t1=findViewById(R.id.textView);
        db=new DataBase(this);

        bldary.add("B+");
        bldary.add("A+");
        bldary.add("O+");
        bldary.add("AB+");
        bldary.add("B-");
        bldary.add("A-");
        bldary.add("O-");
        bldary.add("AB-");
        adapter=new ArrayAdapter<>(Admin.this, android.R.layout.simple_spinner_dropdown_item,bldary);

        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                s1=bldary.get(i);
                Toast.makeText(Admin.this, ""+bldary, Toast.LENGTH_SHORT).show();



            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void select(View view) {

        String res=db.getdata(s1);
        t1.setText(res);









    }
}