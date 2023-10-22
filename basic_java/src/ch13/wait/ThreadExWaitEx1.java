package ch13.wait;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class ThreadExWaitEx1 {
    private static final int COOK_TIME =1;
    private static final int CUSTOMER_TIME =10;
    public static void main(String[] args) throws Exception {
        Table table = new Table();
        new Thread(new Cook(table), "COOK1").start();
        new Thread(new Customer(table, "doughnut"), "손님1(doughnut)").start();
        new Thread(new Customer(table, "burger"), "손님2(burger)").start();

        sleep(100);
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
                if (eatFood()) {
                    System.out.println(name + " ate a " + food);
                } else {
                    System.out.println(name + " failed to eat :(");
                }
            }

        }
        public boolean eatFood() {
            return table.remove(food);
        }


    }

    static class Table {
        String[] dishNames = {"doughnut", "doughnut", "burger"};
        final int MAX_FOOD = 6;

        private ArrayList<String> dishes = new ArrayList<>();


        public void add(String dish) {
            if (dishes.size() >= MAX_FOOD) {
                return;
            }
            dishes.add(dish);
            System.out.println("Dishes : " + dishes);
        }

        public boolean remove(String dishName) {
            for (int i = 0; i < dishes.size(); i++)
                if (dishName.equals(dishes.get(i))) {
                    dishes.remove(i);
                    return true;
                }
            return false;
        }
        public  int dishNum() {
            return dishNames.length;}
    }
}

