package ch13_thread;

import javax.swing.*;

public class Ex13_4 {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요");
        System.out.println("입력하신 값은 " + input + "입니다");

        Thread_Ex4 th4 = new Thread_Ex4();
        th4.start();
    }
}
