package cn.com.servyou.freamework.jdk8.LocalData;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2020/12/21 10:14
 * <p>作者: huwy
 */
public class LocalDateTimeTest {

    public static void main(String[] args) {

        /**
         *
         * Instant：瞬时时间。
         *
         * LocalDate：本地日期，不包含具体时间, 格式 yyyy-MM-dd。
         *
         * LocalTime：本地时间，不包含日期. 格式 yyyy-MM-dd HH:mm:ss.SSS 。
         *
         * LocalDateTime：组合了日期和时间，但不包含时差和时区信息。
         *
         * ZonedDateTime：最完整的日期时间，包含时区和相对UTC或格林威治的时差。
         *
         */

        System.out.println("==========获取当前的日期时间==========");
        //本地日期，不包括时分秒
        LocalDate nowDate = LocalDate.now();
        //本地日期，包括时分秒
        LocalDateTime nowDateTime = LocalDateTime.now();

        System.out.println("nowDate:" + nowDate);   //nowDate:2020-12-21
        System.out.println("nowDateTime:" + nowDateTime);  //nowDateTime:2020-12-21T10:21:03.340

        //获取当前的时间，包括毫秒
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("当前年：" + ldt.getYear());
        System.out.println("当前年份天数：" + ldt.getDayOfYear());
        System.out.println("当前月：" + ldt.getDayOfMonth());
        System.out.println("当前时：" + ldt.getHour());
        System.out.println("当前分：" + ldt.getMinute());
        System.out.println("当前时间：" + ldt.toString());

        System.out.println("==========格式化日期==========");
        System.out.println("格式化时间:" + ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));


        System.out.println("后5天时间：" + ldt.plusDays(5));
        System.out.println("前5天时间并格式化：" + ldt.minusDays(5)
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println("前一个月的时间：" + ldt.minusMonths(1)
                .format(DateTimeFormatter.ofPattern("yyyyMM")));
        System.out.println("后一个月的时间：" + ldt.plusMonths(1));
        System.out.println("指定2099年10月23日：" + ldt.withYear(2099)
                .withMonth(10)
                .withDayOfMonth(23) );


        System.out.println("==========创建指定时间==========");
        //通过指定年月日来创建
        LocalDate ld = LocalDate.of(2017, Month.NOVEMBER, 17);
        LocalDate ld2 = LocalDate.of(2018, Month.APRIL, 17);
        System.out.println("ld:" + ld + "  ld2:" + ld2); //ld:2017-11-17  ld2:2018-04-17


        System.out.println("==========时间相差比较==========");

        //具体相差的年月日
        ld = LocalDate.parse("2017-12-30");
        ld2 = LocalDate.parse("2018-01-01");
        System.out.println("相差年：" + ChronoUnit.YEARS.between(ld, ld2)
                + " 相差月：" + ChronoUnit.MONTHS.between(ld, ld2) + " 相差天："
                + " 相差天：" + ChronoUnit.DAYS.between(ld, ld2));

        System.out.println(Period.between(ld, ld2).getDays());



    }


}
