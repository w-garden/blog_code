package ch13;

/**
 * ThreadEx2.java 에서는 main쓰레드가 콘솔창에서 확인되지 않는다.
 * 왜냐하면 main쓰레드는 이미 종료되었기 때문이다.
 */

class ThreadEx2 {
    public static void main(String[] args)  {
        ThreadEx2_1 t1 = new ThreadEx2_1();
        t1.start();
    }
}

class ThreadEx2_1 extends Thread {
    @Override
    public void run() {
        throwException();
    }

    private void throwException() {
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
