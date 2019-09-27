package edu.ecnu.stu.WorldClock;

import java.time.LocalTime;


/*业务逻辑类*/
public  class WorldClocks {
    int waiterPhoneTime;

    public WorldClocks() {
        this.waiterPhoneTime = LocalTime.now().getHour();
    }

    //从系统获取北京时间，并更新枚举类中的北京时间，同时将服务员手机时间设置为北京时间，并更新世界时钟
    public void autoModifyAllClockByPhone(){
        modifyAllClockCurTime(waiterPhoneTime);
    }

    //根据输入时间来调整手机时间，并自动更新世界时钟
    //UI层会确保用户输入的时间一定在0-23
    public void modifyWaiterPhoneTimeAndWorldClcok(int newWaiterPhoneTime) {
        //if else处理非法（0-23之外)时间 用在测试里面
        if (newWaiterPhoneTime >= 24)
            newWaiterPhoneTime = newWaiterPhoneTime%24;
        else if (newWaiterPhoneTime < 0){
            newWaiterPhoneTime = newWaiterPhoneTime%24;
            newWaiterPhoneTime += 24;
        }
        waiterPhoneTime = newWaiterPhoneTime;
        modifyAllClockCurTime(waiterPhoneTime);
    }

    private void modifyAllClockCurTime(int WaiterPhoneTime){

        Clock.Beijing.modifyCurTimebyNewBeijingTime(WaiterPhoneTime);
        Clock.London.modifyCurTimebyNewBeijingTime(WaiterPhoneTime);
        Clock.Mexico.modifyCurTimebyNewBeijingTime(WaiterPhoneTime);
        Clock.Sydney.modifyCurTimebyNewBeijingTime(WaiterPhoneTime);
        Clock.Newyork.modifyCurTimebyNewBeijingTime(WaiterPhoneTime);

    }

}
