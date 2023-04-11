package com.calenderproject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MonthView {

    public void monthView() {
        Scanner scanner = new Scanner(System.in);

        // Define a map of holidays for the year
        Map<LocalDate, String> holidays = new HashMap<>();
        holidays.put(LocalDate.of(2023, 1, 1), "New Year's Day");
        holidays.put(LocalDate.of(2023, 7, 4), "Independence Day");
        holidays.put(LocalDate.of(2023, 12, 25), "Christmas Day");
        holidays.put(LocalDate.of(2023, 4, 7), "Good Friday");



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
            System.out.print("Enter year After(1800): ");
            try {
                //month = Integer.parseInt(input.nextLine());
                month = scanner.nextInt();

                if (month < 1 || month > 12) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid year. Please enter a valid year after 1800.");
            }
        }


        // Prompt the user to input a month and year
        /*int year = 0;
        while (year < 1800 || year > 2023) {
            System.out.print("Enter year (1800-2023): ");
            year = scanner.nextInt();
        }
        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();
        scanner.close();*/

        LocalDate date = LocalDate.of(year, month, 1);
        DateTimeFormatter monthNameFormatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        System.out.println(date.format(monthNameFormatter));
        System.out.println("Su Mo Tu We Th Fr Sa");
        int daysInMonth = date.lengthOfMonth();
        int firstDayOfWeek = date.getDayOfWeek().getValue() % 7;
        int day = 1;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == 0 && j < firstDayOfWeek) {
                    System.out.print("   ");
                } else if (day > daysInMonth) {
                    System.out.print("   ");
                } else {
                    date = LocalDate.of(year, month, day);
                    String holidayName = holidays.get(date);
                    if (holidayName != null) {
                        System.out.print("\u001B[93m");
                    } else if (j == 0 || j == 6) {
                        System.out.print("\u001B[91m");
                    }
                    System.out.printf("%2d ", day);
                    if (holidayName != null || j == 0 || j == 6) {
                        System.out.print("\u001B[0m");
                    }
                    day++;
                }
            }
            System.out.println();
        }

        // holidays for the year full
        System.out.println("Holidays:");
        for (LocalDate holidayDate : holidays.keySet()) {
            if (holidayDate.getYear() == year) {
                String holidayName = holidays.get(holidayDate);
                System.out.println(holidayDate.format(DateTimeFormatter.ofPattern("MMM d")) + " - " + holidayName);
            }
        }
    }

}
