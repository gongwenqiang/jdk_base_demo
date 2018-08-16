package format;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author gongwq
 * @create 2018-08-14 15:34
 */
public class StringFomatTest {
    public static void main(String[] args) {
        //The format specifiers for general, character, and numeric types have the following syntax:
        //   %[argument_index$][flags][width][.precision]conversion
        //金额
        System.out.println("String.format(\"%,.2f\", 123456.00) = " + String.format("%,.2f", 123456.00));
        //output: String.format("%,.2f", 123456.00) = 123,456.00
        DecimalFormat decimalFormat = new DecimalFormat("####,####,####,####,####.00");
        String bigDecimalStr = decimalFormat.format(new BigDecimal(12345.70).setScale(2, RoundingMode.HALF_UP));
        System.out.println("bigDecimalStr = " + bigDecimalStr);
        //output:bigDecimalStr = 1,2345.70
        //width测试
        System.out.println(String.format("%111.2f", 123456.00));
        //output:                                                                                                      123456.00
    }

}
