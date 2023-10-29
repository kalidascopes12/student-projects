import java.util.*;

// Written by Ryan Parsons, modified by Katie Davis
// Assignment 1 - Calendar Part 1

// Prompts the user for a date and prints out an ASCII calendar for that month 
// and displays the date underneath the calendar. Then, prints out an ASCII 
// calendar and the date for today.

public class MyCalendar {

   // Number of days in a week and cells in a row
   public static final int DAYS_IN_WEEK = 7;
   // How many days in the month
   public static final int DAYS_IN_MONTH = 35;
   // Size for scaling
   public static final int CELL_WIDTH = 12;

   public static void main(String[] args) {		
      Scanner input = new Scanner(System.in);
   	
      String date = getDate(input);
      int month = monthFromDate(date);
      int day = dayFromDate(date);
      drawMonth(month);
      displayDate(month, day);
      date = getToday();
      month = monthFromDate(date);
      day = dayFromDate(date);
      drawMonth(month);
      displayDate(month, day);
   }

   // Given a Scanner, prompts the user for a date and returns the input 
   // as a String
   public static String getDate(Scanner input) {
      System.out.print("What date would you like to look at? ");
      String date = input.next();
      return date;
   }

   // Gets todays date and returns it as a String in the format of "m/d"
   public static String getToday() {
      String date = "";
      Calendar today = Calendar.getInstance();
      date += today.get(Calendar.MONTH) + 1;
      date += "/" + today.get(Calendar.DATE);
      return date;
   }

   // Given a String representation of the date in the format of "m/d", returns 
   // the month portion as an int value
   public static int monthFromDate(String date) {
      int index = date.indexOf("/");
      String month = date.substring(0, index);
      return Integer.parseInt(month);
   }

   // Given a String representation of the date in the format of "m/d", returns 
   // the day portion as an int value
   public static int dayFromDate(String date) {
      int index = date.indexOf("/");
      String day = date.substring(index + 1);
      return Integer.parseInt(day);
   }

   // Given int values for the month and the day, prints out the given 
   // month and day
   public static void displayDate(int month, int day) {
      System.out.println("Month: " + month);
      System.out.println("Day: " + day);
   }

   // Given an integer value for the month, prints out an ASCII representation 
   // of said month
   public static void drawMonth(int month) {
      for(int i = 0; i < (CELL_WIDTH * DAYS_IN_WEEK) / 2 - 1; i++) {
         System.out.print(" ");
      }
      System.out.println(month);
      for(int i = 0; i < CELL_WIDTH * DAYS_IN_WEEK; i++) {
         System.out.print("=");
      }
      System.out.println();
      for(int i = 0; i < DAYS_IN_MONTH / (DAYS_IN_WEEK - 1); i++) {
         drawRow(i);
      }	
   }

   // Given an int for the row, prints out the ASCII representation of one 
   // week of the month's calendar
   public static void drawRow(int row) {
      drawNumberRow(row);
      for(int i = 0; i < CELL_WIDTH / 2 - 1; i++) {
         System.out.print("|");
         for (int j = 0; j < DAYS_IN_WEEK; j++) {
            for (int k = 0; k < CELL_WIDTH - 1; k++) {
               System.out.print(" ");
            }
            System.out.print("|");
         }
         System.out.println();
      }
      for(int j = 0; j < CELL_WIDTH * DAYS_IN_WEEK; j++) {
         System.out.print("=");
      }
      System.out.println();
   }

   // Given an int for the row, prints out the first line with the numbers for 
   // the given row
   public static void drawNumberRow(int row) {
      int rowStart = row * DAYS_IN_WEEK + 1;
      System.out.print("|");
      for (int j = 0; j < DAYS_IN_WEEK; j++) {
         System.out.print(" " + rowStart);
         int numLength = (rowStart + "").length();
         rowStart++;
         for (int k = 0; k < CELL_WIDTH - numLength - 2; k++) {
            System.out.print(" ");
         }
         System.out.print("|");
      }
      System.out.println();
   }
}