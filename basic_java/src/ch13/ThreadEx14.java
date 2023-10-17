package ch13;

import javax.swing.*;

import static java.lang.Thread.interrupted;
import static java.lang.Thread.sleep;

public class ThreadEx14 {
    public static void main(String[] args) {
        Thread th1 = new Thread(new ThreadEx14_1());
        th1.start();
        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요");
        System.out.println("입력하신 값은 "+input+"입니다.");
        th1.interrupt();
        System.out.println("isInterrupted() : " +th1.isInterrupted());


    }
}

class ThreadEx14_1 implements Runnable {
    @Override
    public void run() {
        int i = 10;
        while (i != 0 && !Thread.currentThread().isInterrupted()) {
            System.out.println(i--);
            try {
                sleep(1000);
                //sleep에 의해 멈춰있을때, interrupt()를 호출하면 InterruptedException가 발생한다.
                //그리고 interrupted상태는 false로 자동 초기화된다.
            } catch (InterruptedException e) {
                System.out.println("에러 발생후 interrupted상태가 초기화 된다. 그래서 interrup()를 재실행 해줘야한다.");
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("카운트가 종료되었습니다.");
    }
}
