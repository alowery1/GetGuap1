package com.example.angelialowery.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import static com.example.angelialowery.myapplication.Track2.myExpenses;

import android.os.Bundle;
import android.widget.TextView;

public class Display2 extends AppCompatActivity {
    TextView BillsD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display2);

        BillsD = (TextView) findViewById(R.id.billsid);
        //float[] arr = new float[5];
        //arr = myExpenses.spendings.values();
        //BillsD.setText(myExpenses.spendings.values().toString());
        float b = myExpenses.spendings.get("Bills");
        String h = Float.toString(b);
        BillsD.setText(h);

    }
}
