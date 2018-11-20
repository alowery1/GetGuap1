package com.example.angelialowery.myapplication;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Track2Test{

    @Test
    public void testExpenseHashmap(){
        //assertEquals("testing hashmap failed", );
        TrackSpendings testTrack = new TrackSpendings();
        testTrack.spendings.put("testInput1",0.0f);
        testTrack.spendings.put("testInput2",0.0f);
        testTrack.spendings.put("testInput3",0.0f);

        float result = testTrack.spendings.get("testInput1");

        assertEquals("hashmap test failed",0.0f,result);
        assertEquals("test failed",testTrack.spendings.size(),3);
    }
}
