package com.calenderproject;

import java.util.*;

public class GoToDate {
    public void myGoToDate() {
        Scanner input = new Scanner(System.in);
        Calendar cal = new GregorianCalendar();


        int year = 0;
        while (true) {
            System.out.print("Enter year After(1800): ");
            try {
                year = Integer.parseInt(input.nextLine());
                //current update from 2023 validation to current year
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
                month = Integer.parseInt(input.nextLine());
                if (month < 1 || month > 12) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid month. Please enter a valid month between 1 and 12.");
            }
        }

        int day = 0;
        while (true) {
            System.out.print("Enter day (1-31): ");
            try {
                day = Integer.parseInt(input.nextLine());
                if (day < 1 || day > 31) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid day. Please enter a valid day between 1 and 31.");
            }
        }

        //Calendar cal = Calendar.getInstance();

        cal.set(year, month - 1, day);

        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        for (int i = 1; i < cal.get(Calendar.DAY_OF_WEEK); i++) {
            System.out.print("    ");
        }

        for (int i = 1; i <= maxDay; i++) {
            if (i == day) {
                System.out.printf("\033[7m%3d\033[0m ", i);
            } else {
                System.out.printf("%3d ", i);
            }

            if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                System.out.println();
            }

            cal.add(Calendar.DATE, 1);
        }

        System.out.printf("%nSelected date: %d/%d/%d (%s) %tR%n", month, day, year, cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault()), cal);
    }
}
