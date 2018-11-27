package com.example.angelialowery.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.angelialowery.myapplication.Track2.myExpenses;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;


public class TrackResults extends AppCompatActivity {
    private static String TAG = "TrackResults ";
    //float x = 25.9f;
    float y = myExpenses.spendings.get("Transportation");
    float z = myExpenses.spendings.get("Food");
    float g = myExpenses.spendings.get("Bills");
    float x = myExpenses.spendings.get("Personal");

    float sum = y + z + g + x;
    float yp = y/sum*100;
    float zp = z/sum*100;
    float gp = g/sum*100;
    float xp = x/sum*100;
    //double y = 30.0;
    //double z = 34.1;
    //double g = 10.0;

    //JHANAE: CHANGED TO FLOAT
    //float a = Track2.a;
    //float b = Track2.b;
    //float c = Track2.c;
    //float d = Track2.d;

    //float a = Track2.myExpenses.spendings.get("Bill");
    //j = (float)a;
    //float b = Track2.myExpenses.spendings.get("Transportation");
    //float c = Track2.myExpenses.spendings.get("Food");
    //float d = Track2.myExpenses.spendings.get("Personal");
    private float[] yData = {xp, yp, zp, gp};
    TextView display3;


    private String[] xData = {"Personal", "Transportation", "Food", "Bills"};
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_results);
        Log.d(TAG, "onCreate: start to create chart");

        pieChart = (PieChart) findViewById(R.id.piechart1);
        //pieChart.setDescription("Spendings (In $) ");
        pieChart.setHoleRadius(25f);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setCenterText("Cool Chart");
        pieChart.setCenterTextSize(10);
        //pieChart.setDrawEntryLabels(true);

        addDataSet();
        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                Log.d(TAG, "onValueSelected: Value Selected from chart.");
                Log.d(TAG, "onValueSelected: " + e.toString());
                Log.d(TAG, "onValueSelected: " + h.toString());
                int pos1 = e.toString().indexOf("y:");
                String type = e.toString().substring(pos1 + 3);

                for(int ti = 0;ti<yData.length; ti++){
                    if(yData[ti]==Float.parseFloat(type)){
                        pos1 = ti;
                        break;
                    }
                }
                String type2 = xData[pos1];
                Toast.makeText(TrackResults.this,"Type"+type2 + pos1, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });

    }

    private void addDataSet() {
        Log.d(TAG, "addDataSet started");
        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        ArrayList<String> xEntrys = new ArrayList<>();

        for(int i = 0; i < yData.length; i++){
            //yEntrys.add(new PieEntry(yData[i], i));
            yEntrys.add(new PieEntry(yData[i], i));
        }
        for(int i = 1; i < xData.length; i++){
            xEntrys.add(xData[i]);
        }

        //create data set
        PieDataSet pieDataSet = new PieDataSet(yEntrys, "Spendings");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(12);

        //add colors
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.MAGENTA);
        colors.add(Color.BLUE);
        colors.add(Color.GREEN);
        //colors.add(Color.RED);
        colors.add(Color.YELLOW);
        pieDataSet.setColors(colors);

        //Add legend
        Legend legend = pieChart.getLegend();
        //legend.setFormSize(10f); // set the size of the legend forms/shapes
        legend.setForm(Legend.LegendForm.CIRCLE.CIRCLE); // set what type of form/shape should be used
        legend.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);

        //create pie data object
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();




    }


}
