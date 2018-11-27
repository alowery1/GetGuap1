package com.example.angelialowery.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;
//import com.mashape.unirest.http.JsonNode; //been here
//import com.mashape.unirest.http.HttpResponse; //been
//import com.mashape.unirest.http.Unirest; //been
//import com.mashape.unirest.http.exceptions.UnirestException; //been
import android.os.AsyncTask;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.HashMap;
import java.util.Map;
//import com.mashape.unirest.http.*;


public class Netin extends AppCompatActivity {



    Button calcnetbutton;
    TextView display;
    RequestQueue requestQueue;

    EditText userSal;
    EditText userState;

    String ficaTx;
    String jVisual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netin);

        calcnetbutton = (Button) findViewById(R.id.calcbutton2);
        display = (TextView) findViewById(R.id.incdisplay);

        userSal = (EditText) findViewById(R.id.textView8);
        userState = (EditText) findViewById(R.id.textView9);


        requestQueue = Volley.newRequestQueue(this);

        calcnetbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testCall2();
                //display.setText("Demo number");
//                testCall();
                //testCall2();
            }
        });




    }

    public void testCall() {

        //final HttpResponse<JsonNode> response = Unirest.get("http://httpbin.org/get").queryString("Limit",10),asJson();
        Log.v("AppCompatActivity","BEFORE the try ");
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
            Log.e("AppCompatActivity",response.getBody().toString());
        } catch (UnirestException e) {
            e.printStackTrace();
        }

    }

    public void testCall2(){
        String url = "https://api.github.com/users/rharsl2/repos";


        JsonArrayRequest arrReq = new JsonArrayRequest(Request.Method.GET, url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Check the length of our response (to see if the user has any repos)
                        if (response.length() > 0) {
                            // The user does have repos, so let's loop through them all.
                            for (int i = 0; i < response.length(); i++) {
                                try {
                                    // For each repo, add a new line to our repo list.
                                    JSONObject jsonObj = response.getJSONObject(i);





                                    Log.e("Volley", jsonObj.toString());
                                    String repoName = jsonObj.get("name").toString();
                                    String lastUpdated = jsonObj.get("updated_at").toString();
//                                    addToRepoList(repoName, lastUpdated);
                                    Log.e("Volley", "Repo found");
                                } catch (JSONException e) {
                                    // If there is an error then output this to the logs.
                                    Log.e("Volley", "Invalid JSON Object.");
                                }

                            }
                        } else {
                            // The user didn't have any repos.
                            Log.e("Volley", "No repos found");
//                            setRepoListText("No repos found.");
                        }

                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // If there a HTTP error then add a note to our repo list.
//                        setRepoListText("Error while calling REST API");
                        Log.e("Volley", error.toString());
                    }
                }

        );

        String url2 = "https://stylinandy-taxee.p.mashape.com/v2/calculate/2018";
        StringRequest postRequest = new StringRequest(Request.Method.POST, url2,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d("Response", response);

                        display.setText(response); //new add by tyla





                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("Error.Response", error.toString());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {

                //new things from tyla make parameters be what the user enters
                String userPay = userSal.getText().toString();
                String userSte = userState.getText().toString();

                Map<String, String>  params = new HashMap<String, String>();
                params.put("filing_status", "single");
                params.put("pay_periods", "1");
                params.put("pay_rate",userPay);
                params.put("state",userSte);
                //params.put("pay_rate", "105000");
                //params.put("state", "GA");

                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("X-Mashape-Key", "T04ZbUXfKQmshRETTnVWe1LiYF4Jp1epPrYjsnyTjE3ARot3Hz");
                params.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJBUElfS0VZX01BTkFHRVIiLCJodHRwOi8vdGF4ZWUuaW8vdXNlcl9pZCI6IjViZGY4YWE5Njg3NjI3MmQ2NjVmYWYyZCIsImh0dHA6Ly90YXhlZS5pby9zY29wZXMiOlsiYXBpIl0sImlhdCI6MTU0MTM3NjY4MX0.IVHGyyEjnXOZ2JM4QlRXWceOJE52hRQ52P6290S5CR0");
                params.put("Content-Type", "application/x-www-form-urlencoded");

                return params;
            }
        };
        // Add the request we just defined to our request queue.
        // The request queue will automatically handle the request as soon as it can.
//        requestQueue.add(arrReq);
        requestQueue.add(postRequest);

        //new stuff tyla adding
    }

/*
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
                //testCall();
            }
        });



    }

    public void testCall() {

        //final HttpResponse<JsonNode> response = Unirest.get("http://httpbin.org/get").queryString("Limit",10),asJson();
        Log.v("AppCompatActivity","BEFORE the try ");
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


*/
}
