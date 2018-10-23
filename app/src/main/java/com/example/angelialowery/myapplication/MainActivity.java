package com.example.angelialowery.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button termsbutton;
    private Button trackbutton;
    private Button netbutton;
    private Button budbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        budbutton = (Button) findViewById(R.id.bplanner);
        budbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScreenBud();
            }
        });

        trackbutton = (Button) findViewById(R.id.tracksp);
        trackbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScreen3();
            }
        });

        termsbutton = (Button) findViewById(R.id.terms);
        termsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScreen2();
            }
        });

        netbutton = (Button) findViewById(R.id.CalNet);
        netbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScreenNet();
            }
        });
    }
    public void openScreen2(){
        Intent intent = new Intent (this, Termsc.class);
        startActivity(intent );
    }
    public void openScreen3(){
        Intent intent = new Intent (this, Screen3.class);
        startActivity(intent);
    }

    public void openScreenNet(){
        Intent intent = new Intent (this, Netin.class);
        startActivity(intent );
    }

    public void openScreenBud(){
        Intent intent = new Intent (this, BudgetScreen.class);
        startActivity(intent );
    }


}
