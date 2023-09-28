package ch13;

public class Ex13_6 {
    public static void main(String[] args) {
        Thread_Ex6_1 th1 = new Thread_Ex6_1();
        Thread_Ex6_2 th2 = new Thread_Ex6_2();

        th2.setPriority(7); //우선 순위를 지정할 수 있다. 1~10. 10이 최대 우선순위

        System.out.println("Priority of th1(-) : "+th1.getPriority());
        System.out.println("Priority of th2(|) : "+th2.getPriority());
        th1.start();
        th2.start();

    }
}
