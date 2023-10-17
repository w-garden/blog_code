package ch13;


import static java.lang.Thread.sleep;

public class ThreadEx12 {
    public static void main(String[] args) {
        ThreadEx12_1 th1 = new ThreadEx12_1();
        ThreadEx12_2 th2 = new ThreadEx12_2();
        th1.start();
        th2.start();

        try {
            sleep(2000); //이렇게 실행하여도 실제 실행하는 쓰레드가 영향받음(main쓰레드)
        } catch (InterruptedException e) {
        }
        System.out.print("<<main 종료>>");
    }

}

class ThreadEx12_1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++)
            System.out.print("-");
        System.out.println("\n<<th1 종료>>");

    }
}

class ThreadEx12_2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++)
            System.out.print("|");
        System.out.println("\n<<th2 종료>>");
    }
}