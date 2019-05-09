package day01;

import java.util.Timer;
import java.util.TimerTask;

public class Demo5 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        // abstract class TimerTask implements Runnable
        // 实现了Runnable接口的抽象类
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("定时任务");
            }
        }, 500, 1000);
        // 延时500ms后，每隔1000ms的时候执行一次.
    }
}
