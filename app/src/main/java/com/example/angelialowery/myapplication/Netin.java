package com.example.angelialowery.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Netin extends AppCompatActivity {


    Button calcnetbutton;
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netin);

        calcnetbutton = (Button) findViewById(R.id.calcbutton2);
        display = (TextView) findViewById(R.id.incdisplay);

        calcnetbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText("Demo number");
            }
        });




    }
}
