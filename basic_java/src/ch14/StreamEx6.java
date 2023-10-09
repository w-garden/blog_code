package ch14;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx6 {
    public static void main(String[] args) {
        Student[] stuArr = {
                new Student("이자바", 2, 300),
                new Student("김자바", 1, 200),
                new Student("안자바", 4, 500),
                new Student("박자바", 2, 100),
                new Student("소자바", 5, 500),
                new Student("위자바", 1, 400),
                new Student("오자바", 7, 400),
                new Student("최자바", 2, 900),
                new Student("신자바", 4, 900)
        };

        //학생 이름만 뽑아서 List에 저장
        List<String> names = Stream.of(stuArr).map(Student::getName).collect(Collectors.toList());
        System.out.println("names = " + names);

        // 스트림을 배열로 저장
        Student[] stuArr2 = Stream.of(stuArr).toArray(Student[]::new);
        for (Student student : stuArr2) {
            System.out.println(student.getName() + " : " + student);
        }
        System.out.println();
        //스트림을 Map<String, Student>로 변환. 학생 이름이 key
        Map<String, Student> stuMap = Stream.of(stuArr).collect(Collectors.toMap(s -> s.getName(), s -> s));
        for (String name : stuMap.keySet()) {
            System.out.println(name+" = "+stuMap.get(name));
        }

        long count = Stream.of(stuArr).collect(Collectors.counting());
        long totalScore = Stream.of(stuArr).collect(Collectors.summingLong(Student::getTotalScore));
        System.out.println("count = " + count);
        System.out.println("totalScore = " + totalScore);

        totalScore = Stream.of(stuArr).collect(Collectors.reducing(0, Student::getTotalScore, Integer::sum));
        System.out.println("totalScore = " + totalScore);

        Optional<Student> topStudent = Stream.of(stuArr)
                .collect(Collectors.maxBy(Comparator.comparing(Student::getTotalScore)));
        System.out.println("topStudent = " + topStudent.get());

        IntSummaryStatistics stat = Stream.of(stuArr).collect(Collectors.summarizingInt(Student::getTotalScore));
        System.out.println("stat = " + stat);

        String stuName = Stream.of(stuArr).map(Student::getName)
                .collect(Collectors.joining(",", "[", "]"));
        System.out.println(stuName);


    }
}
