package ch14;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class StreamEx7 {
    public static void main(String[] args) {

        Undergraduate[] stuArr = {
                new Undergraduate("이자바", true, 1, 1, 300),
                new Undergraduate("김자바", false, 1, 1, 100),
                new Undergraduate("안자바", true, 1, 1, 200),
                new Undergraduate("박자바", false, 1, 2, 700),
                new Undergraduate("소자바", true, 1, 2, 400),
                new Undergraduate("위자바", true, 1, 2, 500),
                new Undergraduate("오자바", false, 1, 3, 600),
                new Undergraduate("최자바", false, 1, 3, 100),
                new Undergraduate("신자바", true, 1, 3, 200),

                new Undergraduate("이자바", true, 2, 1, 300),
                new Undergraduate("김자바", false, 2, 1, 100),
                new Undergraduate("안자바", true, 2, 2, 200),
                new Undergraduate("박자바", false, 2, 2, 700),
                new Undergraduate("소자바", true, 2, 1, 400),
                new Undergraduate("위자바", true, 2, 4, 900),
                new Undergraduate("오자바", false, 2, 4, 600),
                new Undergraduate("최자바", false, 2, 1, 100),
                new Undergraduate("신자바", true, 2, 5, 200)
        };
        System.out.printf("1. 단순분할(성별로 분할) \n");
        Map<Boolean, List<Undergraduate>> stuBySex = Stream.of(stuArr).collect(partitioningBy(Undergraduate::isMale));

        List<Undergraduate> maleStudent = stuBySex.get(true);
        List<Undergraduate> femaleStudent = stuBySex.get(false);
        System.out.println("\t남학생");
        for (Undergraduate m : maleStudent) System.out.println(m);
        System.out.println("\t여학생");
        for (Undergraduate s : femaleStudent) System.out.println(s);
        System.out.println("\n2. 단순분할 + 통계(성별 + 학생수)");
        Map<Boolean, Long> stuNumBySex = Stream.of(stuArr).collect(partitioningBy(Undergraduate::isMale, counting()));
        System.out.println("남학생 수 : " + stuNumBySex.get(true));
        System.out.println("여학생 수 : " + stuNumBySex.get(false));
        System.out.println("\n3. 단순분할 + 통계(성별1등)");
        Map<Boolean, Optional<Undergraduate>> topScoreBySex = Stream.of(stuArr).collect(partitioningBy(Undergraduate::isMale, maxBy(comparingInt(Undergraduate::getScore))));
        System.out.println("남학생 1등 : " + topScoreBySex.get(true));
        System.out.println("여학생 1등 : " + topScoreBySex.get(false));

        Map<Boolean, Undergraduate> topScoreBySex2 = Stream.of(stuArr)
                .collect(partitioningBy(Undergraduate::isMale, collectingAndThen(maxBy(comparingInt(Undergraduate::getScore)), Optional::get)));
        System.out.println("남학생 1등 : " + topScoreBySex2.get(true));
        System.out.println("여학생 1등 : " + topScoreBySex2.get(false));

        System.out.println("\n3. 다중분할(성별, 불합격자, 200점 이하)");
        Map<Boolean, Map<Boolean, List<Undergraduate>>> failedStuBySex =
                Stream.of(stuArr).collect(partitioningBy(Undergraduate::isMale,
                        partitioningBy(s -> s.getScore() <= 200)));
        List<Undergraduate> failedMaleStu = failedStuBySex.get(true).get(true);
        List<Undergraduate> failedFemaleStu = failedStuBySex.get(false).get(true);
        for (Undergraduate m : failedMaleStu) {
            System.out.println(m);
        }
        for (Undergraduate f : failedFemaleStu) {
            System.out.println(f);
        }

    }
}
