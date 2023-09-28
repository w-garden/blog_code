package ch13;

/**
 * OS 의 프로세스 스케줄러의 영향을 받기 때문에 실행할 때마다 다른 결과를 얻을 수있음
 * 자바가 OS 독립적이기는 하지만 쓰래드는 OS에 종속적이다.
 */
public class Ex13_3 {
    static long startTime = 0;

    public static void main(String[] args) {
        Thread_Ex3 th1 = new Thread_Ex3();
        th1.start();
        startTime = System.currentTimeMillis();

        for (int i = 0; i < 300; i++)
            System.out.printf("%s", new String("-"));

        System.out.print("소요시간1:" + (System.currentTimeMillis() - Ex13_3.startTime));

    }
}


