package ch13;

public class ThreadEx22 {
    public static void main(String[] args) {
        Runnable r = new RunnableEx22();
        new Thread(r).start();
        new Thread(r).start();

    }

}

class Account_Sync {
    private int balance = 1000;

    public int getBalance() {
        return balance;
    }

    public synchronized void withdraw(int money) {
        if (balance >= money) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            balance -= money;
        }
    }
}

class RunnableEx22 implements Runnable {
    Account_Sync acc = new Account_Sync();

    @Override
    public void run() {
        while (acc.getBalance() > 0) {
            int money = (int) (Math.random() * 3 + 1) * 100;
            acc.withdraw(money);
            String name = Thread.currentThread().getName();
            System.out.println("balance : " + acc.getBalance() + "\t==> "+ name.substring(name.length()-1, name.length())+" 번 쓰레드");
        }

    }
}
