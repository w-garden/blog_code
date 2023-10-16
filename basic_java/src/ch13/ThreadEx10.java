package ch13;

/**
 *         t.setDaemon(true); 이 코드 때문에 main 메서드가 종료되면 강제 종료된다.
 */
public class ThreadEx10 implements Runnable {
    static boolean autoSave = false;

    public static void main(String[] args) {
        Thread t = new Thread(new ThreadEx10());
        t.setDaemon(true); //이 코드 때문에 main 메서드가 종료되면 강제 종료된다.
        t.start();

        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            System.out.println(i);

            if (i == 5)
                autoSave = true;
        }
        System.out.println("프로그램을 종료합니다.");
    }

    @Override
    public void run() {
        while (true){
            try{
                Thread.sleep(1000 * 3);
            }catch (InterruptedException e){}
            if(autoSave) autoSave();
        }

    }

    private void autoSave() {
        System.out.println("작업 파일이 저장 되었습니다.");
    }
}
