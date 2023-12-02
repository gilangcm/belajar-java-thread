package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

    @Test
    void delayedJob() throws InterruptedException {

        var task = new TimerTask(){
            @Override
            public void run() {
                System.out.println("Delayed job");
            }
        };
        var timer = new Timer();
        timer.schedule(task,2_000);

        Thread.sleep(3_000L);
    }

    @Test
    void periodicJob() throws InterruptedException {

        var task = new TimerTask(){
            @Override
            public void run() {
                System.out.println("Delayed job");
            }
        };
        var timer = new Timer();
        timer.schedule(task,2_000,2_000);

        Thread.sleep(10_000L);
    }
}
