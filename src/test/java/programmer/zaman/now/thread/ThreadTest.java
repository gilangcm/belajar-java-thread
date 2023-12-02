package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

public class ThreadTest {
    @Test
    void mainThread() {
        var name = Thread.currentThread().getName();
        System.out.println(name);
    }

    @Test
    void createThread() {
        Runnable runnable = () -> {
            System.out.println("Hello from Thread : " + Thread.currentThread().getName());

        };
        var thread = new Thread(runnable);
        thread.start();

        System.out.println("Program Selesai");
    }

    @Test
    void threadSleep() throws InterruptedException {
        Runnable runnable = () -> {
            try {
                Thread.sleep(2_000);
                System.out.println("Hello from Thread : " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        var thread = new Thread(runnable);
        thread.start();

        System.out.println("Program Selesai");
        Thread.sleep(3_000);
    }

    @Test
    void threadJoin() throws InterruptedException {
        Runnable runnable = () -> {
            try {
                Thread.sleep(2_000);
                System.out.println("Hello from Thread : " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        var thread = new Thread(runnable);
        thread.start();
        System.out.println("Menunggu Selesai");
        thread.join();
        System.out.println("Program Selesai");
    }

    @Test
    void threadInterrupt() throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Runnable : " + i);
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        var thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5_000);
        thread.interrupt();
        System.out.println("Menunggu Selesai");
        thread.join();
        System.out.println("Program Selesai");
    }

    @Test
    void threadInterruptCorrect() throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                // Manual Check Interrupted
                if (Thread.interrupted()){
                    return;
                }
                System.out.println("Runnable : " + i);
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        };
        var thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5_000);
        thread.interrupt();
        System.out.println("Menunggu Selesai");
        thread.join();
        System.out.println("Program Selesai");
    }

    @Test
    void threadName() {
        var thread = new Thread(() -> {
            System.out.println("Run in Thread :" + Thread.currentThread().getName());

        });
        thread.setName("Gils");
        thread.start();
    }
    @Test
    void threadState() throws InterruptedException {
        var thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getState());
            System.out.println("Run in Thread :" + Thread.currentThread().getName());

        });
        thread.setName("Gils");
        System.out.println(thread.getState());
        thread.start();
        thread.join();
        System.out.println(thread.getState());
    }
}
