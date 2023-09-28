package ch13;

/**
 * thread 구현과 실행하기
 * 1. Thread 상속(Thread는 Runnable를 상속받고 있음)
 * 2. Runnable 구현
 */
class Ex13_1 {
    public static void main(String[] args) {
        Thread_Ex1 t1 = new Thread_Ex1();
        Thread t2 = new Thread(new Thread_Ex2());
        Thread_Ex1 t3 = new Thread_Ex1();

        t1.start();
        t2.start();
        t3.start();

    }
}


