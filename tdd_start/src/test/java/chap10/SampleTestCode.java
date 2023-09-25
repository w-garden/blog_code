package chap10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleTestCode {
    @Test
    void dateFormat() {
        LocalDate date = LocalDate.of(1945, 8, 15);
        String dateStr = formatDate(date);
        assertEquals(date.getYear()+"년"+date.getMonthValue()+"월"+date.getDayOfMonth()+"일",dateStr);
        assertEquals("1945년8월15일",dateStr); //기대값은 명확하게 표현하는 것이 좋다
    }

    private static String formatDate(LocalDate date) {
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy년M월dd일");
        return date.format(sdf);
    }
}
