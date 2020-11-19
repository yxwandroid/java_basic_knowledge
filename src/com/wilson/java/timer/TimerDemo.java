package com.wilson.java.timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
   static int callingTime =0;
    public static void main(String[] args) {
        Timer timer =new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                callingTime++;
                System.out.println(getCallingTime());
            }
        },0,1000);
    }

   static private String getCallingTime() {
        int minute = callingTime / 60;
        int second = callingTime % 60;
        return (minute < 10 ? "0" + minute : minute) + ":" + (second < 10 ? "0" + second : second);
    }
}
