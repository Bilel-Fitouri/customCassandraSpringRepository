import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.Months;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by bfitouri on 21/08/16.
 */
public class Test {

    public static void main(String[] args) {
        String tableNameExpression = "gas_sensor_index_%s_%s";

        DateTime beginTs = DateTime.parse("2016-06-01T00:00:00Z");
        DateTime endTs = DateTime.parse("2016-11-27T09:00:00Z");

        Months months = Months.monthsBetween(beginTs,endTs);

        List<String> numbers = IntStream
                .rangeClosed(0, months.getMonths())
                .mapToObj(index -> {
                    DateMidnight monthDateTime = beginTs.plusMonths(index).toDateMidnight();
                    int m = monthDateTime.getMonthOfYear();
                    int y = monthDateTime.getYear();
                    return String.format(tableNameExpression, y, m);

                })
                .collect(Collectors.toList());


        numbers.forEach(System.out::println);
    }
}
