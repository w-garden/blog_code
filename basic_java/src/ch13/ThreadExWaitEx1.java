package ch13;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class ThreadExWaitEx1 {
    public static void main(String[] args) throws Exception {
        Table table = new Table();
        new Thread(new Cook(table), "요리사1").start();
        new Thread(new Customer(table, "doughnut"), "손님1").start();
        new Thread(new Customer(table, "burger"), "손님2").start();

        sleep(100);
        System.exit(0);

    }
}

class Customer implements Runnable {
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
                sleep(10);
            } catch (InterruptedException e) {
            }
            String name = Thread.currentThread().getName();

            if (eatFood()) {
                System.out.println(name + " ate a " + food);
            } else {
                System.out.println(name + " failed to eat. :(");
            }
        }

    }

    public boolean eatFood() {
        return table.remove(food);
    }
}

class Cook implements Runnable {
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
                sleep(1);
            } catch (InterruptedException e) {
            }
        }
    }
}

class Table {
    String[] dishNames = {"doughnut", "doughnut", "burger"};
    final int MAX_FOOD = 6;

    private ArrayList<String> dishes = new ArrayList<>();


    public int dishNum() {
        return dishNames.length;
    }

    public void add(String dish) {
        if (dishes.size() >= MAX_FOOD) {
            return;
        }
        dishes.add(dish);
        System.out.println("Dishes: " + dishes);
    }

    public boolean remove(String dishName) {
        for (int i = 0; i < dishes.size(); i++) {
            if (dishName.equals(dishes.get(i))) {
                dishes.remove(i);
                return true;
            }
        }
        return false;
    }
}
