package com.calenderproject;

import java.util.*;

public class YearCalendar {

    public void yearCalendar() {
        Scanner scanner = new Scanner(System.in);

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
                System.out.print("Enter year After(1800): ");
            }
        }

        int month2 = 0;
        while (true) {
            System.out.print("Enter month (1-12): ");
            try {
                //month = Integer.parseInt(input.nextLine());
                month2 = scanner.nextInt();

                if (month2 < 1 || month2 > 12) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid year. Please enter a valid year after 1800.");
            }
        }

        //System.out.print("Enter year: ");
        //int year = scanner.nextInt();

        // Calendar calendar = Calendar.getInstance();
        Calendar calendar = new GregorianCalendar();

        calendar.clear();
        calendar.set(Calendar.YEAR, year);

        System.out.println("\n" + year + " Calendar\n");
        List<String> allHolidays = new ArrayList<>();
        for (int month = 0; month < 12; month++) {
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            int weekday = calendar.get(Calendar.DAY_OF_WEEK);

            String monthName = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
            System.out.println(monthName);
            System.out.println("Su Mo Tu We Th Fr Sa");

            int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            int day = 1;
            List<String> holidays = new ArrayList<>();
            for (int i = 1; i < weekday; i++) {
                System.out.print("   ");
            }
            while (day <= daysInMonth) {
                for (int i = weekday; i <= 7 && day <= daysInMonth; i++) {
                    String dayString = String.format("%2d", day);
                    if (i == Calendar.SATURDAY || i == Calendar.SUNDAY) {
                        System.out.print("\033[31m" + dayString + "\033[0m");
                    } else if (isHoliday(day, month, year)) {
                        System.out.print("\033[33m" + dayString + "\033[0m");
                        holidays.add(day + " " + monthName);
                        allHolidays.add(day + " " + monthName);
                    } else {
                        System.out.print(dayString);
                    }
                    System.out.print(" ");
                    day++;
                }
                weekday = 1;
                System.out.println();
            }
            System.out.println("Public holidays: " + String.join(", ", holidays) + "\n");
        }
        System.out.println("All public holidays in " + year + ": " + String.join(", ", allHolidays));
    }

    // check if the given day is a holiday if not we see what to add on
    private static boolean isHoliday(int day, int month, int year) {
        if (month == Calendar.JANUARY && day == 1) {
            return true; // New Year's Day
        } else if (month == Calendar.DECEMBER && day == 25) {
            return true; // Christmas Day
        } else {
            return false;
        }
    }

}
