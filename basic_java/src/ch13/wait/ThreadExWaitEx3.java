package ch13.wait;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class ThreadExWaitEx3 {
    private static final int COOK_TIME =10;
    private static final int CUSTOMER_TIME =100;
    private static final int TABLE_TIME =500;
    public static void main(String[] args) throws Exception {
        Table table = new Table();
        new Thread(new Cook(table), "요리사1").start();
        new Thread(new Customer(table, "doughnut"), "손님1").start();
        new Thread(new Customer(table, "burger"), "손님2").start();

        sleep(2000);
        System.exit(0);

    }


    static class Cook implements Runnable {
        private Table table;

        public Cook(Table table) {
            this.table = table;
        }

        @Override
        public void run() {
            while (true) {
                int idx = (int) (Math.random() * table.dishNum());
                table.add(table.dishNames[idx]);
                try {
                    sleep(COOK_TIME);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    static class Customer implements Runnable {
        private Table table;
        private String food;

        public Customer(Table table, String food) {
            this.table = table;
            this.food = food;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    sleep(CUSTOMER_TIME);
                } catch (InterruptedException e) {
                }
                String name = Thread.currentThread().getName();
                table.remove(food);
                System.out.println(name + " ate a " + food);
            }
        }
    }

    static class Table {
        String[] dishNames = {"doughnut", "doughnut", "burger"};
        final int MAX_FOOD = 6;
        private ArrayList<String> dishes = new ArrayList<>();
        public int dishNum() {
            return dishNames.length;
        }

        public synchronized void add(String dish) {
            while (dishes.size() >= MAX_FOOD) {
                String name = Thread.currentThread().getName();
                System.out.println(name + " is waiting.");
                try {
                    wait();
                    sleep(500);
                } catch (InterruptedException e) {
                }
            }
            dishes.add(dish);
            notify();
            System.out.println("Dishes: " + dishes);
        }

        public void remove(String dishName) {
            synchronized (this) {
                String name = Thread.currentThread().getName();

                while (dishes.size() == 0) {
                    System.out.println(name + " is waiting.");
                    try {
                        wait();
                        sleep(TABLE_TIME);
                    } catch (InterruptedException e) {
                    }
                }

                while (true) {
                    for (int i = 0; i < dishes.size(); i++) {
                        if (dishName.equals(dishes.get(i))) {
                            dishes.remove(i);
                            notify();
                            return;
                        }
                    }
                    try {
                        System.out.println(name + " is waiting.");
                        wait();
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }


}