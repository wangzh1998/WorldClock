package edu.ecnu.stu.WorldClock;

import edu.ecnu.stu.WorldClock.WorldClocks;

import java.util.Scanner;

public class WorldClocksUI {
    private static WorldClocks worldClocks;

    public static void main(String[] args) throws Throwable{
        worldClocks = new WorldClocks();
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("************************************");
        System.out.println("          欢迎使用WorldClock         ");
        System.out.println("************************************");

        String lastOption = "";
        while(!lastOption.equalsIgnoreCase("x")){
            lastOption = displayMenu(scanner);//scanner 作为参数
        }
        System.out.println("\n再见...\n");
    }

    public static String displayMenu(Scanner scanner){
        System.out.println("请选择：");
        System.out.println("1.一键校准(根据手机上的北京时间，自动校准城市时钟)");
        System.out.println("2.手动校准（设置手机时间并自动校准城市时钟）");
        System.out.println("x.退出系统");
        System.out.print("您的选择为：");
        String option = scanner.next();

        switch (option){
            case "1":
                setPhoneTimeModeOnBeijing();
                return option;
            case "2":
                setPhoneTime(scanner);
                return option;
            case"x":
                return option;
            default:
                System.out.println("您的输入选项无效，请重新输入");
                return option;
        }
    }
    public static void setPhoneTimeModeOnBeijing(){
        worldClocks.autoModifyAllClockByPhone();
        System.out.println("\n当前手机时间模式为北京时间！");
        System.out.println("手机时间从互联网获取，若不准，请选择选项2，自行调整。");
        printTime();
    }

    public static void setPhoneTime(Scanner scanner){
        scanner.nextLine();
        System.out.println("\n请输入想设置的手机时间(整数0-23)：");
        int time = scanner.nextInt();
        while(!(time>=0&&time<24)){
            System.out.println("输入时间不合法，请重新输入正确时间(整数0-23)：");
            time = scanner.nextInt();
        }
        worldClocks.modifyWaiterPhoneTimeAndWorldClcok(time);
        System.out.println("设置完成！");
        printTime();
    }



    private static void printTime(){
        System.out.println("-------------------------------------");
        System.out.println("当前手机时间："+worldClocks.waiterPhoneTime+"点");
        System.out.println("北京时间："+Clock.Beijing.getCurTime()+"点");
        System.out.println("伦敦时间："+Clock.London.getCurTime()+"点");
        System.out.println("莫斯科时间："+Clock.Mexico.getCurTime()+"点");
        System.out.println("悉尼时间："+Clock.Sydney.getCurTime()+"点");
        System.out.println("纽约时间："+Clock.Newyork.getCurTime()+"点");
        System.out.println("-------------------------------------\n");
        System.out.println();
    }
}
