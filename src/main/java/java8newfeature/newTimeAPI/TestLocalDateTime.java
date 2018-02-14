package java8newfeature.newTimeAPI;

import org.junit.Test;

import java.time.*;

/**
 * LocalDate、LocalTime、LocalDateTime:实现了Temporal和TemporalAdjuster接口
 * LocalDate、LocalTime、LocalDateTime的实例是不可变对象(final修饰，线程安全)
 * 分别表示根据国际标准的系统的日期、时间、日期+时间。
 * 它们提供了建档的日期或时间，并不包含当前的时间信息，也不包含与时区相关的信息。
 * LocalDateTime中常用的方法:
 * String       format(DateTimeFormatter formatter):使用指定的格式化程序格式化此日期时间。
 * static LocalDateTime     parse(CharSequence text):从一个标准时间格式的字符串（如 2007-12-03T10:15:30)获取一个实例。
 * static LocalDateTime	    parse(CharSequence text, DateTimeFormatter formatter):使用特定的格式化从文本字符串获取实例。
 * int          getDayOfYear():返回一年中的第几天，1~365/366
 * int          getDayOfMonth():返回一个月中的第几天，1~31
 * DayOfWeek    getDayOfWeek():获取星期几字段，这是一个枚举 DayOfWeek
 * int          getYear()/getMonthValue()/getHour()/getMinute()/getSecond():获取年、月、时分秒
 * Month        getMonth():返回一个月份枚举类
 * LocalDateTime    plusDays(long days)/...:在指定的日期上添加天数
 * LocalDateTime	minusDays(long days)/...:在指定的日期上减去天数
 * static LocalDateTime     now():返回系统默认时区的当前时间
 * static LocalDateTime	    now(ZoneId zone):从指定时区的系统时钟获取当前的日期时间。
 * static LocalDateTime	    of(LocalDate date, LocalTime time):从日期和时间获取 LocalDateTime一个实例。
 * static LocalDateTime	    of(int year, int month, int dayOfMonth, int hour, int minute):从年，月，日，小时和分钟获得的实例。
 * LocalDate	toLocalDate():获得这个日期时间的 LocalDate一部分。
 * LocalTime	toLocalTime():获得这个日期时间的 LocalTime一部分。
 * LocalDateTime    withYear(int year)/withMonth(int month)/withDayOfMonth(int dayOfMonth)/withHour(int hour)/...获取更改后的时间
 */

/**
 * Instant:时间戳(从1970年1月1日00：00：000到指定时间的毫秒值)，实现了Temporal和TemporalAdjuster接口
 * Instant中常用的方法:
 * static Instant	now():从系统时钟获取当前瞬间。默认获取的是以UTC时区(格林威治时间)为基础的
 * long     toEpochMilli():获取从1970-01-01 00:00:00到现在的毫秒数
 * long     getEpochSecond():获取从1970-01-01 00:00:00到现在的秒数
 * static Instant       ofEpochMilli(long epochMilli):根据1970年加上指定毫秒数指定Instant实例
 */

/**
 * Duration:计算两个时间之间的间隔
 * Duration中常用的方法:
 * static Duration      between(Temporal startInclusive, Temporal endExclusive):两个时间对象之间的持续时间的实例
 * long                 toDays()/toHours()/toMinutes()/getSeconds():获取此持续时间内的天数、小时数、分钟数、秒数
 * long                 toMillis():将此持续时间转换为总长度（以毫秒为单位）。
 */
public class TestLocalDateTime {
    // 1.LocalDate  LocalTime LocalDateTime
    @Test
    public void test1() {
        // 获取当前系统时间
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);// 2018-02-14T00:15:01.745
        LocalDateTime ldt2 = LocalDateTime.of(2018, 02, 14, 13, 14, 13);
        System.out.println(ldt2);// 2018-02-14T13:14:13
        LocalDateTime ldt3 = ldt2.plusYears(1L);
        System.out.println(ldt3);// 2019-02-14T13:14:13
        LocalDateTime ldt4 = ldt3.minusMonths(2L);
        System.out.println(ldt4);// 2018-12-14T13:14:13
        System.out.println(ldt4.getYear());//2018
        System.out.println(ldt4.getMonthValue());//12
        System.out.println(ldt4.getDayOfMonth());//14
        System.out.println(ldt4.getHour());//13
        System.out.println(ldt4.getMinute());//14
        System.out.println(ldt4.getSecond());//13
        System.out.println(ldt4.getNano());//0
    }

    // 2.Instant: 时间戳(从1970年1月1日00：00：000到指定时间的毫秒值)
    @Test
    public void test2() {
        Instant instant1 = Instant.now();// 默认获取的是以UTC时区(格林威治时间)为基础的
        System.out.println(instant1);// 2018-02-14T00:17:18.510Z

        System.out.println(instant1.toEpochMilli());//   1518567438510
        System.out.println(instant1.getEpochSecond());// 1518567438
        Instant instant2 = Instant.ofEpochSecond(60);
        System.out.println(instant2); // 1970-01-01T00:01:00Z

        OffsetDateTime odt = instant1.atOffset(ZoneOffset.ofHours(-8));
        System.out.println(odt);// 2018-02-13T16:17:18.510-08:00
    }

    // 3. Duration:计算两个时间之间的间隔
    @Test
    public void test3() throws InterruptedException {
        Instant instant1 = Instant.now();
        Thread.sleep(1000);
        Instant instant2 = Instant.now();
        Duration duration = Duration.between(instant1, instant2);
        System.out.println(duration.toMillis());// 1001
        System.out.println("-----------------------------------------");
        LocalTime lt1 = LocalTime.now();
        Thread.sleep(60000);
        LocalTime lt2 = LocalTime.now();
        System.out.println(Duration.between(lt1, lt2).toMillis());//60081
        System.out.println(Duration.between(lt1, lt2).toMinutes());//1
        System.out.println(Duration.between(lt1, lt2).getSeconds());//60
    }

    // 4.Period:计算两个日期之间的间隔
    @Test
    public void test4() {
        LocalDate ld1 = LocalDate.of(1993, 04, 8);
        LocalDate ld2 = LocalDate.now();
        Period period = Period.between(ld1, ld2);
        System.out.println(period);// P24Y10M6D
        System.out.println(period.getYears());// 24
        System.out.println(period.getMonths());// 10
        System.out.println(period.getDays());// 6
    }
}
