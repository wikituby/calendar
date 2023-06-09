package com.calenderproject;

import java.util.*;

public class HolidayCalendar {

    public void holidayCalendar() {
        Scanner scanner = new Scanner(System.in);
        Calendar cal = new GregorianCalendar();
        int currentYear = cal.get(Calendar.YEAR);

        int year = 0;
        while (true) {
            System.out.print("Enter year After(1800): ");
            try {
                //year = Integer.parseInt(input.nextLine());
                year = scanner.nextInt();

                if (year < 1800 || year > currentYear) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid year. Please enter a valid year after 1800.");
            }
        }

        int month = 0;
        while (true) {
            System.out.print("Enter month (1-12): ");
            try {
                //month = Integer.parseInt(input.nextLine());
                month = scanner.nextInt();

                if (month < 1 || month > 12) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid month. Please enter a valid month between 1 and 12.");
            }
        }

        // prompt the user to input year and month
        /*System.out.print("Enter year: ");
        int year = scanner.nextInt();
        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt() - 1;
        subtract 1 to convert to 0-based index
         */

        // check if the user wants to print holidays for the month or the year
        System.out.print("Print holidays for month (m) or year (y)? ");
        String choice = scanner.next();

        // reassign my variables with the client inputs from the scanner
        Calendar calendar = new GregorianCalendar();

        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);

        if (choice.equalsIgnoreCase("m")) {
            String monthName = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
            System.out.println("\nHolidays in " + monthName + " " + year + ":");
            List<String> holidays = getHolidaysInMonth(calendar);
            if (holidays.isEmpty()) {
                System.out.println("No holidays in " + monthName);
            } else {
                for (String holiday : holidays) {
                    System.out.println(holiday);
                }
            }
        } else if (choice.equalsIgnoreCase("y")) {
            System.out.println("\nHolidays in " + year + ":");
            List<String> holidays = getHolidaysInYear(year);
            if (holidays.isEmpty()) {
                System.out.println("No holidays in " + year);
            } else {
                for (String holiday : holidays) {
                    System.out.println(holiday);
                }
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static List<String> getHolidaysInMonth(Calendar calendar) {
        List<String> holidays = new ArrayList<>();
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int day = 1; day <= daysInMonth; day++) {
            if (isHoliday(day, calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR))) {
                holidays.add(day + " " + calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()));
            }
        }
        return holidays;
    }

    private static List<String> getHolidaysInYear(int year) {
        List<String> holidays = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        for (int month = 0; month < 12; month++) {
            calendar.clear();
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            holidays.addAll(getHolidaysInMonth(calendar));
        }
        return holidays;
    }

    /// still checking these holiday
    private static boolean isHoliday(int day, int month, int year) {
        if (month == Calendar.JANUARY && day == 1) {
            return true; // by we have only new year...return true

        } else if (month == Calendar.DECEMBER && day == 25) {
            return true; // by we have only one ...return true
        } else {
            return false;
        }
    }

}

