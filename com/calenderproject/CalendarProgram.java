package com.calenderproject;

import java.util.Scanner;

public class CalendarProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please chose an option ");

        String homeView = """
                1. Go To Specific Date
                2. View Full Month
                3. View Full Year
                4. View Holidays in Month or Year
                5. Add Custom Holidays
                6. Holiday Finder Randomly
                7. Events Planner
                0. Exit
                """;
        System.out.println(homeView);
        int mySwitch = scanner.nextInt();

        switch (mySwitch) {
            case 1 -> {
                GoToDate myGoToDateObject = new GoToDate();
                myGoToDateObject.myGoToDate();
            }
            case 2 -> {
                MonthView myMonthViewObject = new MonthView();
                myMonthViewObject.monthView();
            }
            case 3 -> {
                YearCalendar myYearCalenderObject = new YearCalendar();
                myYearCalenderObject.yearCalendar();
            }
            case 4 -> {
                HolidayCalendar myHolidayObject = new HolidayCalendar();
                myHolidayObject.holidayCalendar();
            }
            case 5 -> {
                System.out.println("Still implementing this!!!!");
                //CustomHolidayCalendar myCustomHolidays = new CustomHolidayCalendar();
                //myCustomHolidays.customHoliday();
            }
            case 6 -> {
                System.out.println("Still implementing this holiday finder!!!!");
                //HolidayFinder myHolidayFinder = new HolidayFinder();
               // myHolidayFinder.holidayFinder();
            }
            case 7 -> {
                EventPlannerWithList myPlannerObject = new EventPlannerWithList();
                myPlannerObject.myEventPlannerWithList();
            }
            case 0 -> {
                System.exit(0);
            }


        }


    }
}