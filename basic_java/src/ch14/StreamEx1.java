
package ch14;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx1 {
    public static void main(String[] args) {
        Stream<Student> studentStream = Stream.of(
                new Student("이자바", 2, 300),
                new Student("김자바", 1, 200),
                new Student("안자바", 4, 500),
                new Student("박자바", 2, 100),
                new Student("소자바", 5, 500),
                new Student("최자바", 1, 400),
                new Student("오자바", 7, 400),
                new Student("최자바", 2, 900)
        );

        studentStream.sorted(Comparator.comparing(Student::getBan)
                        .thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);



    }
}


