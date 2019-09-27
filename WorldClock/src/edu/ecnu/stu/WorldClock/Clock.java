package edu.ecnu.stu.WorldClock;

public enum Clock {
    Beijing("Beijing", 0, -8),
    London("London", 0, 0),
    Mexico("Mexico", 0, -4),
    Sydney("Sydney", 0, -10),
    Newyork("Newyork", 0, 5);

    private String name;
    private int curTime;
    private int differenceToUTC;

    Clock(String name, int curTime, int differenceToUTC) {
        this.name = name;
        this.curTime = curTime;
        this.differenceToUTC = differenceToUTC;
    }

    public String getName() {
        return name;
    }

    public int getCurTime() {
        return curTime;
    }


    private int getDifferenceToUTC() {
        return differenceToUTC;
    }


    public void setCurTime(int curTime) {
        this.curTime = curTime;
    }

    public void modifyCurTimebyNewBeijingTime(int newBeijingTime) {
        int newCurTime = newBeijingTime - Clock.Beijing.getDifferenceToUTC()
                + this.getDifferenceToUTC();
        if (newCurTime >= 24)
            newCurTime = newCurTime%24;
        else if (newCurTime < 0){
            newCurTime = newCurTime%24;
            newCurTime += 24;
        }
        this.setCurTime(newCurTime);
    }
}




