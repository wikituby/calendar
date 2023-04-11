package com.calenderproject;

import java.util.*;

public class CustomHolidayCalendar {
    public void customHoliday() {
        Scanner scanner = new Scanner(System.in);
        Calendar calendar = new GregorianCalendar();

        int year = 0;
        while (true) {
            System.out.print("Enter year (1800-2023): ");
            try {
                //year = Integer.parseInt(input.nextLine());
                year = scanner.nextInt();

                if (year < 1800 || year > 2023) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid year. Please enter a valid year between 1800 and 2023.");
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



       /* System.out.print("Enter the year: ");
        int year = scanner.nextInt();
        System.out.print("Enter the month (1-12): ");
        int month = scanner.nextInt();*/
        scanner.nextLine(); // consume the newline character left by nextInt()

        // create a Calendar object for the given year and month
        //Calendar calendar = GregorianCalendar();

        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1); // Calendar months are 0-based

        // prompt user to enter custom holidays
        List<Integer> holidays = new ArrayList<>();
        System.out.print("Enter custom holidays (separated by spaces): ");
        String[] holidayStrings = scanner.nextLine().split(" ");
        for (String holidayString : holidayStrings) {
            holidayString = holidayString.trim(); // remove leading/trailing whitespace
            if (!holidayString.isEmpty()) {
                int holiday = Integer.parseInt(holidayString);
                holidays.add(holiday);
            }
        }

        // print the calendar header
        System.out.println("  S  M  T  W  T  F  S");

        // get the number of days in the month
        int numDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // get the day of the week for the first day of the month
        int startDay = calendar.get(Calendar.DAY_OF_WEEK);

        // print leading spaces if necessary
        for (int i = 1; i < startDay; i++) {
            System.out.print("   ");
        }

        // print the days of the month, highlighting holidays
        for (int day = 1; day <= numDays; day++) {
            boolean isHoliday = holidays.contains(day);
            if (isHoliday) {
                System.out.print("\033[31m"); // ANSI escape code for red text
            }
            System.out.printf("%2d ", day);
            if (isHoliday) {
                System.out.print("\033[0m"); // ANSI escape code to reset text color
            }

            if (startDay == Calendar.SATURDAY) {
                System.out.print("\n");
            }
            startDay = (startDay % 7) + 1; // increment the day of the week
        }

        // print trailing spaces if necessary
        if (startDay != Calendar.SUNDAY) {
            System.out.println();
        }

        // print custom holidays now
        if (!holidays.isEmpty()) {
            System.out.println("\nCustom Holidays:");
            for (int holiday : holidays) {
                System.out.printf("%2d\n", holiday);
            }
        }
    }
}
