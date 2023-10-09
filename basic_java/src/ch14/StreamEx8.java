package ch14;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ch14.Undergraduate.Level.*;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class StreamEx8 {
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
                new Undergraduate("신자바", true, 1, 4, 400),

                new Undergraduate("이자바", true, 2, 1, 300),
                new Undergraduate("김자바", false, 2, 1, 100),
                new Undergraduate("안자바", true, 2, 2, 200),
                new Undergraduate("박자바", false, 2, 2, 700),
                new Undergraduate("소자바", true, 2, 1, 400),
                new Undergraduate("위자바", true, 2, 3, 500),
                new Undergraduate("오자바", false, 2, 4, 300),
                new Undergraduate("최자바", false, 2, 1, 100),
                new Undergraduate("신자바", true, 2, 3, 200)
        };

        System.out.println("1. 단순그룹화(반별로 그룹화");
        Map<Integer, List<Undergraduate>> stuByBan = Stream.of(stuArr).collect(groupingBy(Undergraduate::getBan));
        for (List<Undergraduate> ban : stuByBan.values()) {
            for (Undergraduate s : ban) {
                System.out.println(s);
            }
        }
        System.out.println("2. 단순그룹화(성적별로 그룹화");
        Map<Undergraduate.Level, List<Undergraduate>> stuByLevel = Stream.of(stuArr).collect(groupingBy(s -> {
            if (s.getScore() >= 300) return HIGH;
            else if (s.getScore() >= 200) return MID;
            else return LOW;
        }));
        TreeSet<Undergraduate.Level> keySet = new TreeSet<>(stuByLevel.keySet());
        for (Undergraduate.Level key : keySet) {
            System.out.println("[" + key + "]");
            for (Undergraduate s : stuByLevel.get(key)) {
                System.out.println(s);
            }
        }
        System.out.println("3. 단순그룹화 + 통계(성적별 학생수)");
        Map<Undergraduate.Level, Long> stuCntByLevel = Stream.of(stuArr).collect(groupingBy(s -> {
            if (s.getScore() >= 300) return HIGH;
            else if (s.getScore() >= 200) return MID;
            else return LOW;
        }, counting()));
        for (Undergraduate.Level key : stuCntByLevel.keySet()) {
            System.out.printf("[%s] - %d명, ", key, stuCntByLevel.get(key));
        }
        System.out.println();
        System.out.println("4. 다중그룹화(학년별, 반별)");
        Map<Integer, Map<Integer, List<Undergraduate>>> stuByHakAndBan = Stream.of(stuArr)
                .collect(groupingBy(Undergraduate::getHak, groupingBy(Undergraduate::getBan)));

        for (Map<Integer, List<Undergraduate>> hak : stuByHakAndBan.values()) {
            for (List<Undergraduate> ban : hak.values()) { //학년별
                for (Undergraduate undergraduate : ban) { //반별
                    System.out.println(undergraduate);
                }
                System.out.println();
            }
        }
        System.out.println("5. 다중그룹화 + 통계(학년별, 반별 1등)");
        Map<Integer, Map<Integer, Undergraduate>> topStuByHakAndBan =
                Stream.of(stuArr)
                        .collect(groupingBy(Undergraduate::getHak
                                , groupingBy(Undergraduate::getBan
                                        , collectingAndThen(
                                                maxBy(comparingInt(Undergraduate::getScore))
                                                , Optional::get
                                        )
                                )
                        ));
        for (Map<Integer, Undergraduate> ban : topStuByHakAndBan.values()) {
            for (Undergraduate s : ban.values()) {
                System.out.println(s);
            }
        }
        System.out.println("6. 다중그룹화 + 통계(학년별, 반별 성적그룹)");
        Map<String, Set<Undergraduate.Level>> stuByScoreGroup = Stream.of(stuArr)
                .collect(groupingBy(s-> s.getHak() +"-" +s.getBan(), mapping(s->{
                    if(s.getScore() >=300) return HIGH;
                    else if(s.getScore() >=200) return MID;
                    else return LOW;
                }
                ,toSet())
                ));

        Set<String> ketSet2 = stuByScoreGroup.keySet();
        for (String s : ketSet2) {
            System.out.println("[" + s + "]" + stuByScoreGroup.get(s));
        }
    }
}
