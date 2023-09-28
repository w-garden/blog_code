package ch13;

class Thread_Ex3 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++)
            System.out.printf("%s", new String("|"));

        System.out.print("소요시간2:" + (System.currentTimeMillis() - Ex13_3.startTime));
    }
}
