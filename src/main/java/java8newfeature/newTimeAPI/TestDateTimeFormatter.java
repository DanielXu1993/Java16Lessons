package java8newfeature.newTimeAPI;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * DateTimeFormatter：格式化时间/日期
 *        String                format(TemporalAccessor temporal):使用此格式化程序格式化日期时间对象。
 * static DateTimeFormatter     ofPattern(String pattern):使用指定的格式创建格式化对象。
 */
public class TestDateTimeFormatter {
    @Test
    public void test6() {
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
        LocalDateTime ldt = LocalDateTime.now();
        String date1 = ldt.format(dtf);
        System.out.println(date1);// 2018-02-14
        System.out.println("----------------------");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String date2 = dtf2.format(ldt);
        System.out.println(date2);// 2018年02月14日 00:41:37
        System.out.println("----------------------");
        LocalDateTime newDate = ldt.parse(date2, dtf2);
        System.out.println(newDate);// 2018-02-14T00:41:37
        System.out.println("----------------------");
    }
}
