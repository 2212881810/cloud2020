import java.time.ZonedDateTime;

public class DateTimeTest {
    public static void main(String[] args) {
        ZonedDateTime dateTime = ZonedDateTime.now();
        System.out.println(dateTime);  //2020-04-19T22:43:50.514+08:00[Asia/Shanghai]
    }
}
