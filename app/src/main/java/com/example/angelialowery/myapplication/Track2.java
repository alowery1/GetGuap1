package com.example.angelialowery.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import java.lang.String;
import android.util.Log;

import org.w3c.dom.Text;

import java.util.Locale;

import android.os.Bundle;


public class Track2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    //Double type1, type2, type3, type4, type5;
    float type1, type2, type3, type4, type5;
    EditText inp1, inp2, inp3, inp4, inp5;
    TextView display2;


    public static Float a;
    public static Float b;
    public static Float c;
    public static Float d;
    public static Float e;
    //public static  j;


    //Made button not private
    Button submit2;

    //private Button submit;

    static TrackSpendings myExpenses = new TrackSpendings();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track2);

        final Spinner spinner1 = findViewById(R.id.sp1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);


        final Spinner spinner2 = findViewById(R.id.sp2);
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(this);

        final Spinner spinner3 = findViewById(R.id.sp3);
        spinner3.setAdapter(adapter);
        spinner3.setOnItemSelectedListener(this);

        final Spinner spinner4 = findViewById(R.id.sp4);
        spinner4.setAdapter(adapter);
        spinner4.setOnItemSelectedListener(this);

        final Spinner spinner5 = findViewById(R.id.sp5);
        spinner5.setAdapter(adapter);
        spinner5.setOnItemSelectedListener(this);



        inp1 = (EditText) findViewById(R.id.in1);
        inp2 = (EditText) findViewById(R.id.in2);
        inp3 = (EditText) findViewById(R.id.in3);
        inp4 = (EditText) findViewById(R.id.in4);
        inp5 = (EditText) findViewById(R.id.in5);


        submit2 = (Button) findViewById(R.id.trackbut);
        display2 = (TextView) findViewById(R.id.title);



        submit2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //UPDATE TRACK SPENDINGS HASHMAP

                //GET USER AMOUNT INPUT
                type1 = Float.valueOf(inp1.getText().toString());
                //GET VALUE OF SPINNER
                String spinnerKey1 = spinner1.getSelectedItem().toString();
                //ADD DOUBLE VALUE TO HASHMAP
                myExpenses.spendings.put(spinnerKey1, myExpenses.spendings.get(spinnerKey1) + type1);

                //GET USER AMOUNT INPUT
                type2 = Float.valueOf(inp2.getText().toString());
                //GET VALUE OF SPINNER
                String spinnerKey2 = spinner2.getSelectedItem().toString();
                //ADD DOUBLE VALUE TO HASHMAP
                myExpenses.spendings.put(spinnerKey2, myExpenses.spendings.get(spinnerKey2) + type2);

                //GET USER AMOUNT INPUT
                type3 = Float.valueOf(inp3.getText().toString());
                //GET VALUE OF SPINNER
                String spinnerKey3 = spinner3.getSelectedItem().toString();
                //ADD DOUBLE VALUE TO HASHMAP
                myExpenses.spendings.put(spinnerKey3, myExpenses.spendings.get(spinnerKey3) + type3);

                //GET USER AMOUNT INPUT
                type4 = Float.valueOf(inp4.getText().toString());
                //GET VALUE OF SPINNER
                String spinnerKey4 = spinner4.getSelectedItem().toString();
                //ADD DOUBLE VALUE TO HASHMAP
                myExpenses.spendings.put(spinnerKey4, myExpenses.spendings.get(spinnerKey4) + type4);


                //GET USER AMOUNT INPUT
                type5 = Float.valueOf(inp5.getText().toString());
                //GET VALUE OF SPINNER
                String spinnerKey5 = spinner5.getSelectedItem().toString();
                //ADD DOUBLE VALUE TO HASHMAP
                myExpenses.spendings.put(spinnerKey5, myExpenses.spendings.get(spinnerKey5) + type5);


                //FROM JHANAE: DONT NEED THE VARIABLES BELOW. type1..type5 ARE THE SAME THING
                a = myExpenses.spendings.get("Bill");
                //j = (float)a;
                b = myExpenses.spendings.get("Transportation");
                c = myExpenses.spendings.get("Food");
                d = myExpenses.spendings.get("Personal");
                //e = myExpenses.spendings.get(spinnerKey5);
                //display2.setText(a.toString() + " " + b.toString() + " " +  c.toString() + " " + d.toString());
                openTrackRes();


            }

        });


    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void openTrackRes(){
        Intent intent = new Intent (this, TrackResults.class);
        startActivity(intent );
    }

}
