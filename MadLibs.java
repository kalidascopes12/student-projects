// Paul Hansen
// Javier King
// Dominique Bouchard
// 8/2/2022
// CS 141
// Lab 4: Mad Libs
//
// this program will present a user with options to create a new madlib, view a previous madlib, or quit

import java.util.*; // for Scanner

public class MadLibs {
   public static void main(String[] args) {
   
   Scanner console = new Scanner(System.in); // for reading console from user
   Scanner input = new Scanner(new File(xxxx)); // for reading the main mad lib file 
   
   // this method will initiate the program and prompt the user for an entry from the menu
   prompt()
      // "type n for new mad lib"
      // "type v to view old lib" etc
      
   String choice = console.next(); 
   
   // this method will take a string from a Scanner from the console as a parameter from user to chose new, view, or quit, and prompt user for a 
   // valid entry if they submit something invalid
   menu(String choice)
   
   String fileName = console.next(); 
   // this method will be the primary driver for the new madLib creation. it will follow a prompt to the user for a specific mad lib file
   // and start a method within to edit the placeholders. it will also generate a printstream output to a file
   newLib(String fileName, PrintStream output)
   
   // nested method from newLib which will take lines from fileName file as a String parameter and turn them into strings to be processed as tokens and then a further
   // target variable to find places that need to be edited for placeholders.
   // will return string back into newLib()
   editLib(String lineFromFile, String target)  
      // this segment must use "console.nextLine()" to account for users entering multiple words or tokens
   
   // this is a method that will parse a placeholder (string parameter) and return a boolean true if a vowel for giving a correct prompt
   vowelStart()