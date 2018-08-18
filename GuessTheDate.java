import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GuessTheDate {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        int month = in.nextInt();
        int day = in.nextInt();
        String finalResult = "";

        if (day == 1){
            if (month == 1){
                day = 31;
                month = 12;
                --year;
            }else{
                --month;
                if (isLeapYear(year) && month == 2){
                    day = 29;
                } else if (month == 2){
                    day = 28;
                }else {
                    switch (month) {
                        case 1:
                            day = 31;
                            break;
                        case 3:
                            day = 31;
                            break;
                        case 4:
                            day = 30;
                            break;
                        case 5:
                            day = 31;
                            break;
                        case 6:
                            day = 30;
                            break;
                        case 7:
                            day = 31;
                            break;
                        case 8:
                            day = 31;
                            break;
                        case 9:
                            day = 30;
                            break;
                        case 10:
                            day = 31;
                            break;
                        case 11:
                            day = 30;
                            break;
                        case 12:
                            day = 31;
                            break;
                    }
                }
            }
        } else{
            --day;
        }

        switch (month){
            case 1:
                finalResult = String.format("%d-Jan-%d", day, year);
                break;
            case 2:
                finalResult = String.format("%d-Feb-%d", day, year);
                break;
            case 3:
                finalResult = String.format("%d-Mar-%d", day, year);
                break;
            case 4:
                finalResult = String.format("%d-Apr-%d", day, year);
                break;
            case 5:
                finalResult = String.format("%d-May-%d", day, year);
                break;
            case 6:
                finalResult = String.format("%d-Jun-%d", day, year);
                break;
            case 7:
                finalResult = String.format("%d-Jul-%d", day, year);
                break;
            case 8:
                finalResult = String.format("%d-Aug-%d", day, year);
                break;
            case 9:
                finalResult = String.format("%d-Sep-%d", day, year);
                break;
            case 10:
                finalResult = String.format("%d-Oct-%d", day, year);
                break;
            case 11:
                finalResult = String.format("%d-Nov-%d", day, year);
                break;
            case 12:
                finalResult = String.format("%d-Dec-%d", day, year);
                break;
        }

        System.out.println(finalResult);
    }

    private static boolean isLeapYear(int year) {
        boolean leap = false;

        if(year % 4 == 0)
        {
            if( year % 100 == 0)
            {
                // year is divisible by 400, hence the year is a leap year
                if ( year % 400 == 0)
                    leap = true;
                else
                    leap = false;
            }
            else
                leap = true;
        }
        else
            leap = false;

        return leap;
    }
}
