package com.example.angelialowery.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.Intent;

public class Screen3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    float type1, type2, type3, type4, type5;
    EditText inp1, inp2, inp3, inp4, inp5;

    private Button submit;

    TrackSpendings myExpenses = new TrackSpendings();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);

        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Spinner spinnerr = findViewById(R.id.spinner2);
        spinnerr.setAdapter(adapter);
        spinnerr.setOnItemSelectedListener(this);

        Spinner spinnerrr = findViewById(R.id.spinner3);
        spinnerrr.setAdapter(adapter);
        spinnerrr.setOnItemSelectedListener(this);

        Spinner spinnerrrr = findViewById(R.id.spinner4);
        spinnerrrr.setAdapter(adapter);
        spinnerrrr.setOnItemSelectedListener(this);

        Spinner spinnerrrrr = findViewById(R.id.spinner5);
        spinnerrrrr.setAdapter(adapter);
        spinnerrrrr.setOnItemSelectedListener(this);

        submit = (Button) findViewById(R.id.trackbutton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTrackRes();
            }
        });

        inp1 = (EditText) findViewById(R.id.inp1);
        inp2 = (EditText) findViewById(R.id.inp2);
        inp3 = (EditText) findViewById(R.id.inp3);
        inp4 = (EditText) findViewById(R.id.inp4);
        inp5 = (EditText) findViewById(R.id.inp5);
        submit = (Button) findViewById(R.id.trackbutton);
        //submit.setOnClickListener(new View.OnClickListener(){
        //    @Override
        //            public void onClick(View v){
        //        type1 = Float.valueOf(inp1.getText().toString());
        //        System.out.println(type1);

        //    }
        //});

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
