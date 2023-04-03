package dateTime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Test {
    public static void main(String[] args) {
        System.out.println(isDate());
    }

    /**
     * 检查是否日期格式
     */
    public static boolean isDate(){
        String str = "1998-12-3033";
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate.parse(str, fmt1);
        }catch (DateTimeParseException e){
            return false;
        }
        return true;
    }
}
