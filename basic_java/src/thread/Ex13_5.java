package thread;

import javax.swing.*;
import java.util.SortedMap;

public class Ex13_5 {
    public static void main(String[] args) {

        Thread_Ex4 th1 = new Thread_Ex4();
        th1.start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요");
        System.out.println("입력하신 값은 " + input + "입니다");
    }
}
