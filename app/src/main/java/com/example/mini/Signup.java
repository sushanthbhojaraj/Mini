package com.example.mini;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Signup extends AppCompatActivity {
    ArrayList<String> ar;
    Spinner sp; //spinner

    EditText eddob,edname,edphone,edloc;
    String sdob,sblood,stname,stloc,stmob;

    ArrayAdapter<String> adapter;
    DataBase obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        eddob=findViewById(R.id.editTextTextPersonName8);
        edname=findViewById(R.id.editTextTextPersonName);
        edphone=findViewById(R.id.editTextTextPersonName6);
        edloc=findViewById(R.id.editTextTextPersonName7);
        obj = new DataBase(this);



        eddob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





                DatePickerDialog dp= new DatePickerDialog(Signup. this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        eddob.setText(i2+"/"+(1+i1)+"/"+i);
                    }
                }  ,2023,1,6   );
                dp.show();

            }
        });


        sp=findViewById(R.id.spinner);

        ar=new ArrayList<>();

        ar.add("B+");
        ar.add("A+");
        ar.add("O+");
        ar.add("AB+");
        ar.add("B-");
        ar.add("A-");
        ar.add("O-");
        ar.add("AB-");
        adapter=new ArrayAdapter<>(Signup.this, android.R.layout.simple_spinner_dropdown_item,ar);



        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sblood=ar.get(i);
                Toast.makeText(Signup.this,""+ sblood, Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    public void signup(View view) {
        stname=edname.getText().toString();
        stloc=edloc.getText().toString();
        stmob=edphone.getText().toString();
        sdob=eddob.getText().toString();
        Toast.makeText(this,
                stname+"-"
                +stmob+"-"
                +sdob, Toast.LENGTH_SHORT).show();
        obj.savdat(stname,stmob,stloc,sdob,sblood);






    }
}