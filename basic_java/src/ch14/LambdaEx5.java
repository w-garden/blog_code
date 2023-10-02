package ch14;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaEx5 {
    public static void main(String[] args) {
        Supplier<Integer> s = () -> (int) (Math.random() * 100) + 1;
        Consumer<Integer> c = i -> System.out.print(i + ", ");
        Predicate<Integer> p = i -> i % 2 == 0;
        Function<Integer, Integer> f = i -> i / 10 * 10;
        List<Integer> list = new ArrayList<>();

        makeRandomList(list, s);
        System.out.println(list);

        printEvenNum(list, p, c);
        List<Integer> newList = doSomething(list, f);
        System.out.println(newList);
    }

    private static <T> List<T> doSomething(List<T> list, Function<T, T> f) {
        List<T> newList = new ArrayList<>(list.size());
        for (T i : list) {
            newList.add(f.apply(i));
        }
        return newList;
    }


    private static <T> void printEvenNum(List<T> list, Predicate<T> p, Consumer<T> c) {
        System.out.print("[");
        for (T i : list) {
            if (p.test(i)) {
                c.accept(i);
            }
        }
        System.out.println("]");
    }

    private static <T> void makeRandomList(List<T> list, Supplier<T> s) {
        for (int i = 0; i < 10; i++) {
            list.add(s.get());
        }
    }
}
