package com.example.angelialowery.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.w3c.dom.Text;
//import com.mashape.unirest.http.JsonNode; //been here
//import com.mashape.unirest.http.HttpResponse; //been
//import com.mashape.unirest.http.Unirest; //been
import com.mashape.unirest.http.exceptions.UnirestException; //been
import android.os.AsyncTask;
import android.util.Log;
import com.mashape.unirest.http.*;

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

        //testCall();

    }

    public void testCall(){

        //final HttpResponse<JsonNode> response = Unirest.get("http://httpbin.org/get").queryString("Limit",10),asJson();

        try {
            HttpResponse<JsonNode> response = Unirest.post("https://stylinandy-taxee.p.mashape.com/v2/calculate/2018")
                    .header("X-Mashape-Key", "T04ZbUXfKQmshRETTnVWe1LiYF4Jp1epPrYjsnyTjE3ARot3Hz")
                    .header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJBUElfS0VZX01BTkFHRVIiLCJodHRwOi8vdGF4ZWUuaW8vdXNlcl9pZCI6IjViZGY4YWE5Njg3NjI3MmQ2NjVmYWYyZCIsImh0dHA6Ly90YXhlZS5pby9zY29wZXMiOlsiYXBpIl0sImlhdCI6MTU0MTM3NjY4MX0.IVHGyyEjnXOZ2JM4QlRXWceOJE52hRQ52P6290S5CR0")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .field("filing_status", "single")
                    .field("pay_periods", 1)
                    .field("pay_rate", 105000)
                    .field("state", "GA")
                    .asJson();
            //response.getBody(); //i just added it
            Log.v("AppCompatActivity","after the try ");
           //Log.e("AppCompatActivity",response.getBody().toString());
        } catch (UnirestException e) {
            e.printStackTrace();
        }

    }


}
