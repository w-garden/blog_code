package ch13;

/**
 * run()으로 실행해서 예외를 발생시켰다. main쓰레드에서 예외가 발생되었으며 새로운 쓰레드가 생성되지 않았다.
 */
class ThreadEx3 {
    public static void main(String[] args) {
        ThreadEx3_1 t1 = new ThreadEx3_1();
        t1.run();
    }
}
class ThreadEx3_1 extends Thread {
    @Override
    public void run() {
        throwException();
    }

    private void throwException() {
        try{
            throw new Exception();
        }catch (Exception e){
            e.printStackTrace();

        }
    }
}
