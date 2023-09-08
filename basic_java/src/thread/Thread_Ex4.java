package thread;

public class Thread_Ex4 extends Thread {
    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);

            } catch (Exception e) {

            }
        }
    }
}
