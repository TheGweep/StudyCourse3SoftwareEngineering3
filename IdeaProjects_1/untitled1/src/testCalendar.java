import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;
public class testCalendar
{
    testCalendar()
    {
        this.enterDate();
        this.isDay();
        this.showResult();
    }
    int dayNext;
    int newDayNext;
    int day;
    int month;
    int year;
    int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


    Scanner scn = new Scanner(System.in);

    public void enterDate()
    {

        while (year<=0)
        {
                System.out.print("Введите год: ");
                year = scn.nextInt();
                isHighYear();
                if (year < 0)
                    System.err.println("Введите год > 0!");
        }
        while (month <= 0 || month > 12)
        {
                System.out.print("Введите месяц: ");
                month = scn.nextInt();
                if (month <= 0)
                    System.err.println("Введите месяц > 0!");
                if (month > 12)
                    System.err.println("Введите месяц <= 12!");
        }
        while (day <= 0 || day > months[month-1])
        {
            System.out.print("Введите день: ");
            day = scn.nextInt();
            if(day <= 0)
                System.err.println("Введите день > 0!");
            if(day > months[month-1])
                System.err.println("Введите день <= дней в месяце!");
        }
    }
    public void isHighYear()
    {
        if (year % 4 == 0)
        {
            months[1] = 29;
        }
    }
    public void isDay()
    {
        dayNext = day - 7;
        if (day == 7) {
            if (month == 1) {
                month = 12;
                dayNext = months[month - 1];
                year--;
            } else {
                dayNext = months[month - 2];
                month--;
            }
        }
        else if (day < 7) {
            if (month == 1) {
                month = 12;
                newDayNext = months[month - 1] + dayNext;
                dayNext = newDayNext;
                year--;
            } else {
                newDayNext = months[month - 2] + dayNext;
                dayNext = newDayNext;
                month--;
            }
        }
    }
        public void showResult()
        {
            System.out.println("День: " + dayNext);
            System.out.println("Месяц: " + month);
            System.out.println("Год: " + year);
        }
}
