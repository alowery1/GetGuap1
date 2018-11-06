package com.example.angelialowery.myapplication;
import java.util.HashMap;
public class TrackSpendings {


        HashMap<String, Double> spendings = new HashMap<String, Double>();

        public TrackSpendings() {
            
            spendings.put("Personal", 0.0);
            spendings.put("Transportation", 0.0);
            spendings.put("Food", 0.0);
            spendings.put("Bills", 0.0);

//            """for (String name : spendings.keySet()) {
//                String category = name;
//                Double spent = spendings.get(name);
//                System.out.println(category + ": " + spent);
//            }
        }
//        public static void main(String args[]){

//            TrackSpendings myExpenses = new TrackSpendings();

//        }
    }