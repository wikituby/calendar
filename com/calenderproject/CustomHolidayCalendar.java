package com.calenderproject;

import java.util.*;

public class CustomHolidayCalendar {
    public void customHoliday() {
        Scanner scanner = new Scanner(System.in);
        Calendar calendar = new GregorianCalendar();


        int year = 0;
        while (true) {
            System.out.print("Enter year After(1800): ");
            try {
                //year = Integer.parseInt(input.nextLine());
                year = scanner.nextInt();
                //current update year After 1800...no limit forward
                if (year < 1800) {
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

       /* System.out.print("Enter the year: ");
        int year = scanner.nextInt();
        System.out.print("Enter the month (1-12): ");
        int month = scanner.nextInt();*/
        scanner.nextLine(); // consume the newline character left by nextInt()

        // create a Calendar object for the given year and month
        //Calendar calendar = GregorianCalendar();

        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1); // problem solved from research months are 0 based

        // tell user to enter custom holidays
        List<Integer> holidays = new ArrayList<>();
        System.out.print("Enter custom holidays (separated by spaces): ");
        String[] holidayStrings = scanner.nextLine().split(" ");
        for (String holidayString : holidayStrings) {
            holidayString = holidayString.trim(); // space
            if (!holidayString.isEmpty()) {
                int holiday = Integer.parseInt(holidayString);
                holidays.add(holiday);
            }
        }

        // print on console calendar heading
        System.out.println("  S  M  T  W  T  F  S");

        // total number of days in a month
        int numDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // day of the week
        int startDay = calendar.get(Calendar.DAY_OF_WEEK);

        // leading spaces
        for (int i = 1; i < startDay; i++) {
            System.out.print("   ");
        }

        // print the days of the month, highlighting holidays
        for (int day = 1; day <= numDays; day++) {
            boolean isHoliday = holidays.contains(day);
            if (isHoliday) {
                System.out.print("\033[31m"); // from my research ANSI escape code for red text
            }
            System.out.printf("%2d ", day);
            if (isHoliday) {
                System.out.print("\033[0m"); // from research ANSI escape code to reset text color
            }

            if (startDay == Calendar.SATURDAY) {
                System.out.print("\n");
            }
            startDay = (startDay % 7) + 1;
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
