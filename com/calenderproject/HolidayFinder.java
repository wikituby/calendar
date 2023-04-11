package com.calenderproject;

import java.time.LocalDate;

public class HolidayFinder {

    public void holidayFinder() {
        LocalDate startDate = LocalDate.parse(getInput("Enter start date (yyyy-mm-dd): "));
        LocalDate endDate = LocalDate.parse(getInput("Enter end date (yyyy-mm-dd): "));

        LocalDate date = startDate.plusDays(1);
        while (date.isBefore(endDate)) {
            if (isHoliday(date)) {
                System.out.println(date + " is a holiday.");
            }
            date = date.plusDays(1);
        }
    }

    public static String getInput(String prompt) {
        System.out.print(prompt);
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        return scanner.nextLine();
    }

    public static boolean isHoliday(LocalDate date) {

        return date.getDayOfWeek() == java.time.DayOfWeek.SATURDAY ||
                date.getDayOfWeek() == java.time.DayOfWeek.SUNDAY;
    }
}

