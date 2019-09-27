package edu.ecnu.stu.WorldClock;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ClockTest {

    @BeforeAll
    static void setBeijingTime(){
        Clock.Beijing.setCurTime(0);
    }


    @Test
    void modifyCurTimebyNewBeijingTime() {

        int newTime=0;

        Clock.Beijing.modifyCurTimebyNewBeijingTime(newTime);
        Clock.London.modifyCurTimebyNewBeijingTime(newTime);
        Clock.Mexico.modifyCurTimebyNewBeijingTime(newTime);
        Clock.Sydney.modifyCurTimebyNewBeijingTime(newTime);
        Clock.Newyork.modifyCurTimebyNewBeijingTime(newTime);

        assertEquals(0,Clock.Beijing.getCurTime());
        assertEquals(8,Clock.London.getCurTime());
        assertEquals(4,Clock.Mexico.getCurTime());
        assertEquals(22,Clock.Sydney.getCurTime());
        assertEquals(13,Clock.Newyork.getCurTime());


    }

    @AfterAll
    static void clear(){
        Clock.Beijing.setCurTime(0);
        Clock.London.setCurTime(0);
        Clock.Mexico.setCurTime(0);
        Clock.Sydney.setCurTime(0);
        Clock.Newyork.setCurTime(0);

    }
}