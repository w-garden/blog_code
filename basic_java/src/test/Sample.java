package test;

import java.util.Calendar;
import java.util.Date;

public class Sample {
    public static void main(String[] args) {
        Calendar date = Calendar.getInstance();
        System.out.println(date.getTime());
        for(int i=0; i< 10;i++){
            System.out.println(date.get(i));

        }
    }
}
