package _Bloch;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
import java.util.function.Consumer;

public class Test extends Thread {
    public static void main(String[] args) {

    }

}

 class TestClass {
    public static void main(String[] args) throws Exception {
        LocalDate date = LocalDate.of(2020, 1, 2);
        LocalTime tome = LocalTime.of(11, 12, 34);
        LocalDateTime dateTime = LocalDateTime.of(date, tome);

        DateTimeFormatter f = DateTimeFormatter.ofPattern("hh:mm");
        System.out.println(f.format(dateTime));
        //f.format(date);
        System.out.println(f.format(tome));

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.println(dateTimeFormatter.format(dateTime));


    }
}


