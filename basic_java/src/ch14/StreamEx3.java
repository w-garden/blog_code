package ch14;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx3 {
    public static void main(String[] args) {
        Student[] stuArr = {
                new Student("이자바", 2, 300),
                new Student("김자바", 1, 200),
                new Student("안자바", 4, 500),
                new Student("박자바", 2, 100),
                new Student("소자바", 5, 500),
                new Student("최자바", 1, 400),
                new Student("오자바", 7, 400),
                new Student("최자바", 2, 900),
                new Student("신자바", 4, 900)
        };

        Stream<Student> stuStream = Stream.of(stuArr);

        stuStream.sorted(Comparator.comparing(Student::getBan)
                .thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);

        stuStream = Stream.of(stuArr);
        IntStream stuScoreStream = stuStream.mapToInt(Student::getTotalScore);

        IntSummaryStatistics stat = stuScoreStream.summaryStatistics();
        System.out.println("count = " + stat.getCount());
        System.out.printf("average = "+"%.2f\n",stat.getAverage());
        System.out.println("MAX = "+stat.getMax());
        System.out.println("MIN = "+ stat.getMin());
        System.out.println("sum = "+stat.getSum());
    }
}
