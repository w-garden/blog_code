package test;

import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class Sample {
    public static void main(String[] args) {

//
//        Properties p = System.getProperties();
//        System.out.println("프로퍼티의 개수 : " + p.size());
//        for (Object o : p.keySet()) {
//            System.out.println(o + "\t:  " + p.get(o));
//        }


        Predicate<String> isEmptyStr = s ->s.length()==0;


    }
}
