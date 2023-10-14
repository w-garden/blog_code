package ch13;

class Thread_Ex1 extends Thread {
    public static void main(String[] args) {
        Thread_Ex1 t = new Thread_Ex1();
        t.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i+1+" "+getName());
            try {
                sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}