package com.calenderproject;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EventPlannerWithList {
    private static final String FILENAME = "NewQeury/events.txt";

    public static void myEventPlannerWithList() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Display the main menu
            System.out.println("\nWelcome to Event planner App");
            System.out.println("1. Add Event");
            System.out.println("2. View Events");
            System.out.println("3. Edit Event");
            System.out.println("4. Delete Event");
            System.out.println("5. read Events and Add Them To Calendar");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            // Read the user's choice
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // consume the new line character

            // Handle the user's choice
            switch (choice) {
                case 1:
                    addEvent(scanner);
                    break;
                case 2:
                    viewEvents(scanner);
                    break;
                case 3:
                    editEvent(scanner);
                    break;
                case 4:
                    deleteEvent(scanner);
                    break;
                case 5:
                    readEventsAddThemToCalendar();
                    break;
                case 6:
                    System.out.println("Thanks for using the event planner!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 6);
    }

    private static void addEvent(Scanner scanner) {
        while (true) {
            System.out.print("Enter event name: ");
            String eventName = scanner.nextLine();

            System.out.print("Enter event date (DD/MM/YYYY): ");
            String eventDate = scanner.nextLine();

            System.out.print("Enter event time (HH:mm): ");
            String eventTime = scanner.nextLine();

            // Check if events file exists and create it if necessary
            File eventsFile = new File(FILENAME);
            if (!eventsFile.exists()) {
                try {
                    eventsFile.createNewFile();
                } catch (IOException e) {
                    System.err.println("Error creating events file: " + e.getMessage());
                    return;
                }
            }
            // Check if event already exists in file
            try (Scanner fileScanner = new Scanner(eventsFile)) {
                while (fileScanner.hasNextLine()) {
                    String[] parts = fileScanner.nextLine().split(",");
                    if (parts[0].equals(eventName) && parts[1].equals(eventDate)) {
                        System.out.println("An event with this name and date already exists.");
                        return;
                    }
                }
            } catch (FileNotFoundException e) {
                System.err.println("Error reading events file: " + e.getMessage());
                return;
            }
            // Add event to file
            /*try (PrintWriter writer = new PrintWriter(new FileOutputStream(eventsFile, true))) {
                writer.println(eventName + "," + eventDate + "," + eventTime);
                System.out.println("Event added successfully.");
            } catch (IOException e) {
                System.err.println("Error writing to events file: " + e.getMessage());
            }
        }*/

            try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME, true))) {
                writer.println(eventName + "," + eventDate + "," + eventTime);
                System.out.println("Event added successfully.");

                System.out.print("Do you want to add another event? (Y/N): ");
                String answer = scanner.nextLine().trim().toLowerCase();
                if (!answer.equals("y")) {
                    break;
                }
            } catch (IOException e) {
                System.err.println("Error adding event: " + e.getMessage());
            }
        }
    }

//recent working addevent method

    /*private static void addEvent(Scanner scanner) {
        System.out.println("Enter event name:");
        String eventName = scanner.nextLine();

        System.out.println("Enter event date (dd/MM/yyyy):");
        String eventDate = scanner.nextLine();

        System.out.println("Enter event time (HH:mm):");
        String eventTime = scanner.nextLine();

        // Check if events file exists and create it if necessary
        File eventsFile = new File(FILENAME);
        if (!eventsFile.exists()) {
            try {
                eventsFile.createNewFile();
            } catch (IOException e) {
                System.err.println("Error creating events file: " + e.getMessage());
                return;
            }
        }

        // Check if event already exists in file
        try (Scanner fileScanner = new Scanner(eventsFile)) {
            while (fileScanner.hasNextLine()) {
                String[] parts = fileScanner.nextLine().split(",");
                if (parts[0].equals(eventName) && parts[1].equals(eventDate)) {
                    System.out.println("An event with this name and date already exists.");
                    return;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error reading events file: " + e.getMessage());
            return;
        }

        // Add event to file
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(eventsFile, true))) {
            writer.println(eventName + "," + eventDate + "," + eventTime);
            System.out.println("Event added successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to events file: " + e.getMessage());
        }
    }*/


    /*private static void addEvent(Scanner scanner) {
        String eventName;
        String eventDate;
        String eventTime;

        // Ask the user for event details
        System.out.print("\nEnter the event name: ");
        eventName = scanner.nextLine();
        System.out.print("Enter the event date (MM/DD/YYYY): ");
        eventDate = scanner.nextLine();
        System.out.print("Enter the event time (HH:MM AM/PM): ");
        eventTime = scanner.nextLine();

        // Check if the event already exists in the text file
        try (FileReader fr = new FileReader(FILENAME);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(eventName) && parts[1].equals(eventDate)) {
                    System.out.println("\nError: Event already exists for this name and date.");
                    return;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading events.txt from file: " + e.getMessage());
        }

        // Save the event to a text file
        saveEventToFile(eventName, eventDate, eventTime);

        System.out.println("\nEvent added successfully!");
    }*/

    /*private static void viewEvents(Scanner scanner) {
        try (Scanner fileScanner = new Scanner(new File(FILENAME))) {
            int eventCount = 0;

            if (fileScanner.hasNextLine()) {
                System.out.println("\nHolidays:\n");

                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] parts = line.split(",");

                    System.out.println("Name: " + parts[0]);
                    System.out.println("Date: " + parts[1]);
                    System.out.println("Time: " + parts[2]);
                    System.out.println();
                }}
            else {
                System.out.println("\nNo Events to display.");
            }


            while (fileScanner.hasNextLine()) {
                String[] parts = fileScanner.nextLine().split(",");
                String eventName = parts[0];
                String eventDate = parts[1];
                String eventTime = parts[2];
                System.out.println(++eventCount + ". " + eventName + " on " + eventDate + " at " + eventTime);
            }

            if (eventCount == 0) {
                System.out.println("No events.txt found.");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error reading events.txt from file: " + e.getMessage());
        }
    }*/
    private static void viewEvents(Scanner scanner) {
        File eventsFile = new File(FILENAME);
        if (!eventsFile.exists()) {
            System.out.println("No events to show. please try adding an event first");
            return;
        }

        try (Scanner fileScanner = new Scanner(eventsFile)) {
            int eventCount = 0;
            System.out.println("");
            System.out.println("Event List");

            while (fileScanner.hasNextLine()) {
                String[] parts = fileScanner.nextLine().split(",");
                String eventName = parts[0];
                String eventDate = parts[1];
                String eventTime = parts[2];
                System.out.println(++eventCount + ". " + eventName + " on " + eventDate + " at " + eventTime);
            }

            if (eventCount == 0) {
                System.out.println("No events found.");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error reading events.txt from file: " + e.getMessage());
        }
    }


    /*private void viewEvents(Scanner scanner) {
        try (Scanner fileScanner = new Scanner(new File(FILENAME))) {
            int eventCount = 0;

            while (fileScanner.hasNextLine()) {
                String[] parts = fileScanner.nextLine().split(",");
                String eventName = parts[0];
                String eventDate = parts[1];
                String eventTime = parts[2];
                System.out.println(++eventCount + ". " + eventName + " on " + eventDate + " at " + eventTime);
            }

            if (eventCount == 0) {
                System.out.println("No events.txt found.");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error reading events.txt from file: " + e.getMessage());
        }
    }
*/


    /*private static void viewEvents() {
        // Read and print out the events.txt from the text file
        System.out.println("\nEvent List:");
        try (FileReader fr = new FileReader(FILENAME);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                System.out.println("Name: " + parts[0]);
                System.out.println("Date: " + parts[1]);
                System.out.println("Time: " + parts[2]);
                System.out.println();
            }
        } catch (IOException e) {
            System.err.println("Error reading events.txt from file: " + e.getMessage());
        }
    }*/
    /*private static void viewEvents() {
        try {
            File file = new File("holidays.txt");
            Scanner reader = new Scanner(file);

            if (reader.hasNextLine()) {
                System.out.println("\nEvent List:");

                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    System.out.println("Name: " + parts[0]);
                    System.out.println("Date: " + parts[1]);
                    System.out.println("Time: " + parts[2]);
                    System.out.println();
            }}
                else {
                System.out.println("\nNo Events to display.");
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading holidays from file.");
            e.printStackTrace();
        }
    }
*/

    private static void editEvent(Scanner scanner) {
        // Check if the events file exists and has events
        File eventsFile = new File(FILENAME);
        if (!eventsFile.exists() || eventsFile.length() == 0) {
            System.out.println("\nError: No events found.");
            return;
        }

        // Prompt the user for the name and date of the event to be edited
        System.out.print("\nEnter the name of the event to be edited: ");
        String eventName = scanner.nextLine();
        System.out.print("Enter the date of the event to be edited (MM/DD/YYYY): ");
        String eventDate = scanner.nextLine();

        // Check if the event exists in the file
        boolean eventFound = false;
        List<String> events = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(eventsFile)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                if (parts[0].equals(eventName) && parts[1].equals(eventDate)) {
                    eventFound = true;
                    String eventTime = parts[2];
                    System.out.println("\nCurrent event details:");
                    System.out.println("Name: " + eventName);
                    System.out.println("Date: " + eventDate);
                    System.out.println("Time: " + eventTime);

                    // Prompt the user for the new event details
                    System.out.print("\nEnter the new event name (leave blank to keep current): ");
                    String newEventName = scanner.nextLine().trim();
                    if (!newEventName.isEmpty()) {
                        eventName = newEventName;
                    }

                    System.out.print("Enter the new event date (MM/DD/YYYY) (leave blank to keep current): ");
                    String newEventDate = scanner.nextLine().trim();
                    if (!newEventDate.isEmpty()) {
                        eventDate = newEventDate;
                    }

                    System.out.print("Enter the new event time (HH:MM AM/PM) (leave blank to keep current): ");
                    String newEventTime = scanner.nextLine().trim();
                    if (!newEventTime.isEmpty()) {
                        eventTime = newEventTime;
                    }

                    // Store the new event details
                    events.add(eventName + "," + eventDate + "," + eventTime);
                    System.out.println("\nEvent details updated successfully!");
                } else {
                    events.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: Events file not found.");
            return;
        }

        // If the event was not found in the file, print an error message and return
        if (!eventFound) {
            System.out.println("\nError: Event not found.");
            return;
        }

        // Save the updated events to the file
        try (PrintWriter writer = new PrintWriter(eventsFile)) {
            for (String event : events) {
                writer.println(event);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: Events file not found.");
            return;
        }
    }




    /*private static void editEvent(Scanner scanner) {
        // Ask the user for the name and date of the event to be edited
        System.out.print("\nEnter the name of the event to be edited: ");
        String eventName = scanner.nextLine();
        System.out.print("Enter the date of the event to be edited (MM/DD/YYYY): ");
        String eventDate = scanner.nextLine();

        // Prompt the user for the updated event information
        System.out.println("\nEnter the updated event information:");
        System.out.print("Name (" + eventName + "): ");
        String newEventName = scanner.nextLine();
        System.out.print("Date (" + eventDate + "): ");
        String newEventDate = scanner.nextLine();
        System.out.print("Time: ");
        String newEventTime = scanner.nextLine();

        // Update the event in the text file
        try (FileReader fr = new FileReader(FILENAME);
             BufferedReader br = new BufferedReader(fr);
             FileWriter fw = new FileWriter(FILENAME + ".tmp");
             PrintWriter pw = new PrintWriter(fw)) {
            String line;
            boolean edited = false;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(eventName) && parts[1].equals(eventDate)) {
                    pw.println(newEventName + "," + newEventDate + "," + newEventTime);
                    edited = true;
                } else {
                    pw.println(line);
                }
            }
            if (!edited) {
                System.out.println("\nError: Event not found.");
                return;
            }
        } catch (IOException e) {
            System.err.println("Error reading/writing events.txt to/from file: " + e.getMessage());
            return;
        }

        // Replace the original file with the temporary file
        File originalFile = new File(FILENAME);
        File tempFile = new File(FILENAME + ".tmp");
        boolean success = tempFile.renameTo(originalFile);

        if (success) {
            System.out.println("\nEvent edited successfully!");
        } else {
            System.err.println("Error replacing events.txt file with temporary file.");
        }
    }
*/

    private static void deleteEvent(Scanner scanner) {
        // Check if the events file exists and has events
        File eventsFile = new File(FILENAME);
        if (!eventsFile.exists() || eventsFile.length() == 0) {
            System.out.println("\nError: No events found.");
            return;
        }

        // Ask the user for the name and date of the event to be deleted
        System.out.print("\nEnter the name of the event to be deleted: ");
        String eventName = scanner.nextLine();
        System.out.print("Enter the date of the event to be deleted (MM/DD/YYYY): ");
        String eventDate = scanner.nextLine();

        // Remove the event from the text file
        try (FileReader fr = new FileReader(FILENAME);
             BufferedReader br = new BufferedReader(fr);
             FileWriter fw = new FileWriter(FILENAME + ".tmp");
             PrintWriter pw = new PrintWriter(fw)) {
            String line;
            boolean deleted = false;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(eventName) && parts[1].equals(eventDate)) {
                    deleted = true;
                } else {
                    pw.println(line);
                }
            }
            if (!deleted) {
                System.out.println("\nError: Event not found.");
                return;
            }
        } catch (IOException e) {
            System.err.println("Error reading/writing events.txt to/from file: " + e.getMessage());
            return;
        }

        // Replace the original file with the temporary file
        File originalFile = new File(FILENAME);
        File tempFile = new File(FILENAME + ".tmp");
        boolean success = tempFile.renameTo(originalFile);

        if (success) {
            System.out.println("\nEvent deleted successfully!");
        } else {
            System.err.println("Error replacing events.txt file with temporary file.");
        }
    }


    private static void saveEventToFile(String name, String date, String time) {
        try (FileWriter fw = new FileWriter(FILENAME, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(name + "," + date + "," + time);
        } catch (IOException e) {
            System.err.println("Error saving event to file: " + e.getMessage());
        }
    }
    private static void readEventsAddThemToCalendar(){
        // Check if the events file exists and has events
        File eventsFile = new File(FILENAME);
        if (!eventsFile.exists() || eventsFile.length() == 0) {
            System.out.println("\nError: No events found.");
            return;
        }
        Calendar calendar = Calendar.getInstance();

        // Read events from file and add them to the calendar
        try (Scanner fileScanner = new Scanner(new File(FILENAME))) {
            while (fileScanner.hasNextLine()) {
                String[] parts = fileScanner.nextLine().split(",");
                String eventName = parts[0];
                String eventDateStr = parts[1];
                String eventTimeStr = parts[2];

                // Parse event date and time
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                Calendar eventCalendar = Calendar.getInstance();
                eventCalendar.setTime(dateFormat.parse(eventDateStr + " " + eventTimeStr));

                // Add event to calendar
                int eventDay = eventCalendar.get(Calendar.DAY_OF_MONTH);
                int eventMonth = eventCalendar.get(Calendar.MONTH);
                int eventYear = eventCalendar.get(Calendar.YEAR);
                int eventHour = eventCalendar.get(Calendar.HOUR_OF_DAY);
                int eventMinute = eventCalendar.get(Calendar.MINUTE);
                calendar.set(eventYear, eventMonth, eventDay, eventHour, eventMinute);

                // Print event on calendar
                System.out.println(eventName + ": " + calendar.getTime());

                Calendar cal = Calendar.getInstance();
                cal.set(eventYear, eventMonth-1, eventDay);

                int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

                System.out.println("Sun Mon Tue Wed Thu Fri Sat");

                for (int i = 1; i < cal.get(Calendar.DAY_OF_WEEK); i++) {
                    System.out.print("    ");
                }

                for (int i = 1; i <= maxDay; i++) {
                    if (i == eventDay) {
                        System.out.printf("\033[7m%3d\033[0m ", i);
                    } else {
                        System.out.printf("%3d ", i);
                    }

                    if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                        System.out.println();
                    }

                    cal.add(Calendar.DATE, 1);
                }

                System.out.printf("%nSelected date: %d/%d/%d (%s) %tR%n", eventMonth, eventDay, eventYear, cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault()), cal);







            }
        } catch (FileNotFoundException e) {
            System.err.println("Error reading events from file: " + e.getMessage());
        } catch (ParseException e) {
            System.err.println("Error parsing event date/time: " + e.getMessage());
        }
    }




}
