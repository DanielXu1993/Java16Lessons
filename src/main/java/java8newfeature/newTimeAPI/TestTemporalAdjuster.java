package java8newfeature.newTimeAPI;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 * TemporalAdjuster:时间校正器(FunctionalInterface)。Temporal adjustInto(Temporal temporal);
 * 有时我们可能需要获取例如：将时间调整到"下个周日"等操作
 * TemporalAdjusters:该类通过静态方法提供了大量的常用TemporalAdjuster的实现
 */
public class TestTemporalAdjuster {
    // TemporalAdjuster: 时间校正器
    @Test
    public void test1() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);// 2018-02-14T00:48:40.368
        LocalDateTime ldt2 = ldt.withDayOfMonth(10);
        System.out.println(ldt2);//2018-02-10T00:48:40.368

        LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(ldt3);// 2018-02-18T00:48:40.368
        System.out.println("-------------------");
        // 自定义:下一个工作日
        LocalDateTime ldt5 = ldt.with(l -> {
            LocalDateTime ldt4 = (LocalDateTime) l;
            DayOfWeek dow = ldt4.getDayOfWeek();
            if (dow.equals(DayOfWeek.FRIDAY)) {
                return ldt4.plusDays(3);
            } else if (dow.equals(DayOfWeek.SATURDAY)) {
                return ldt4.plusDays(2);
            } else
                return ldt4.plusDays(1);
        });
        System.out.println(ldt5);// 2018-02-15T00:48:40.368
    }
}
