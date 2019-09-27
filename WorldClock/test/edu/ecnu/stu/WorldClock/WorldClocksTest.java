package edu.ecnu.stu.WorldClock;

import org.junit.jupiter.api.*;


import java.text.DateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WorldClocksTest {

    static WorldClocks worldClocks;
    static int realSystemTime;

    @BeforeEach
    void init(){
        worldClocks = new WorldClocks();
        realSystemTime = LocalTime.now().getHour();
    }

    @Test
    void autoModifyAllClockByPhone() {

        worldClocks.autoModifyAllClockByPhone();

        //计算出与系统时间对应的各个时区的时间
        Calendar london = Calendar.getInstance();
        london.add(Calendar.HOUR_OF_DAY,8);
        Calendar mexico = Calendar.getInstance();
        mexico.add(Calendar.HOUR_OF_DAY,4);
        Calendar sydney = Calendar.getInstance();
        sydney.add(Calendar.HOUR_OF_DAY,-2);
        Calendar newyork = Calendar.getInstance();
        newyork.add(Calendar.HOUR_OF_DAY,13);

        assertEquals(realSystemTime,worldClocks.waiterPhoneTime);
        assertEquals(realSystemTime,Clock.Beijing.getCurTime());
        assertEquals(london.get(Calendar.HOUR_OF_DAY),Clock.London.getCurTime());
        assertEquals(mexico.get(Calendar.HOUR_OF_DAY),Clock.Mexico.getCurTime());
        assertEquals(sydney.get(Calendar.HOUR_OF_DAY),Clock.Sydney.getCurTime());
        assertEquals(newyork.get(Calendar.HOUR_OF_DAY),Clock.Newyork.getCurTime());
    }

    @Test
    void modifyAllClockCurTimewithNormalTime(){
        worldClocks.modifyWaiterPhoneTimeAndWorldClcok(13);//设置手机时间
        assertEquals(13,worldClocks.waiterPhoneTime);
        assertEquals(13,Clock.Beijing.getCurTime());
        assertEquals(13+8,Clock.London.getCurTime());
        assertEquals(13+4,Clock.Mexico.getCurTime());
        assertEquals(13-2,Clock.Sydney.getCurTime());
        assertEquals(13+13-24,Clock.Newyork.getCurTime());
    }

    @Test
    void modifyAllClockCurTimewithInvalidTime(){
        worldClocks.modifyWaiterPhoneTimeAndWorldClcok(28);//设置手机时间
        assertEquals(4,worldClocks.waiterPhoneTime);
        assertEquals(4,Clock.Beijing.getCurTime());
        assertEquals(4+8,Clock.London.getCurTime());
        assertEquals(4+4,Clock.Mexico.getCurTime());
        assertEquals(4-2,Clock.Sydney.getCurTime());
        assertEquals(4+13,Clock.Newyork.getCurTime());
    }
}