package com.calenderproject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int year, month;

        //prompting user to input month and the year
        do {
            System.out.print("Enter year (must be after 1800): ");
            year = scanner.nextInt();
        } while (year < 1800);
        do {
            System.out.print("Enter month (1-12): ");
            month = scanner.nextInt();
        } while (month < 1 || month > 12);

        // Now Print calendar for full one month
        System.out.println(month + " " + year);
        System.out.println(" Su Mo Tu We Th Fr Sa");
        int daysInMonth = 30;
        int firstDayOfWeek = 7;
        for (int i = 1; i < firstDayOfWeek; i++) {
            System.out.print("   ");
        }
        for (int i = 1; i <= daysInMonth; i++) {
            System.out.printf("%3d", i);
            if ((i + firstDayOfWeek - 1) % 7 == 0 || i == daysInMonth) {
                System.out.println();
            }
        }
    }
}
