package com.example.angelialowery.myapplication;
import java.util.HashMap;
public class TrackSpendings {


        HashMap<String, Float> spendings = new HashMap<String, Float>();

        public TrackSpendings() {
            
            spendings.put("Personal", 0.0f);
            spendings.put("Transportation", 0.0f);
            spendings.put("Food", 0.0f);
            spendings.put("Bills", 0.0f);

//            for (String name : spendings.keySet()) {
//                String category = name;
//                Double spent = spendings.get(name);
//                System.out.println(category + ": " + spent);
//            }
        }
//        public static void main(String args[]){
//
//            TrackSpendings myExpenses = new TrackSpendings();

//        }
    }