package java8newfeature.newTimeAPI;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * ZonedDate、ZonedTime、ZonedDateTime:带时区的时间
 * 其中每个视图都对应着ID，地区ID的格式为"{区域}/{城市}"
 * 例如 Asia/Shanghai
 * ZoneId:该类中包含了所有的时区信息
 * getAvailableZoneIds():可以获取所有的时区信息
 * of(id):用指定的时区信息获取ZoneId对象
 */
public class TestZone {
    @Test
    public void test1() {
        Set<String> set = ZoneId.getAvailableZoneIds();
        set.forEach(System.out::println);
    }
    @Test
    public void test2() {
        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Europe/Tallinn"));
        System.out.println(ldt);// 2018-02-14T02:52:36.399

        Instant now = Instant.now();
        System.out.println(now);// 2018-02-14T00:52:36.411Z

        LocalDateTime ldt2 = LocalDateTime.now();
        ZonedDateTime zdt = ldt2.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(zdt);// 2018-02-14T00:52:36.427+08:00[Asia/Shanghai]
    }
}
