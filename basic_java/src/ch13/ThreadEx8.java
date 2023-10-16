package ch13;

import static java.lang.Thread.sleep;

public class ThreadEx8 {
    public static void main(String[] args) {
        ThreadEx8_1 t1 = new ThreadEx8_1();
        Thread t2 = new Thread(new ThreadEx8_2());
        t2.setPriority(7);
        System.out.println("t1.getPriority() : " + t1.getPriority());
        System.out.println("t2.getPriority() : " + t2.getPriority());
        t1.start();
        t2.start();

    }
}

class ThreadEx8_1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
            try {
                sleep(100);
            } catch (Exception e) {
            }
        }
    }
}

class ThreadEx8_2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("|");
            try {
                sleep(100);
            } catch (Exception e) {
            }
        }
    }
}
