package com.calenderproject;

import com.calenderproject.GoToDate;
import com.calenderproject.HolidayFinder;
import com.calenderproject.MonthView;
import com.calenderproject.YearCalendar;

import java.util.*;
import java.util.Scanner;

public class CalendarProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please chose an option ");

        String homeView = """
                          1. Go To Date
                          2. View Month
                          3. View Year
                          4. View Holidays
                          0. Exit
                          """;
        System.out.println(homeView);
        int mySwitch = scanner.nextInt();
        switch (mySwitch){
            case 1 -> {
                GoToDate myGoToDateObject = new GoToDate();
                myGoToDateObject.myGoToDate();            }
            case 2 ->{
                MonthView myMonthViewObject = new MonthView();
                myMonthViewObject.monthView();
            }
            case 3 ->{
                YearCalendar myYearCalenderObject = new YearCalendar();
                myYearCalenderObject.yearCalendar();
            }
            case 4 ->{
                HolidayFinder myHolidayFinderObject = new HolidayFinder();
                myHolidayFinderObject.holidayFinder();
            }
            case 0 ->{
                System.exit(0);
            }


        }



    }
}