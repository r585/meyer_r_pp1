/*
* This class will launch the application and allow two arguements once ran.
* @author Ryan Meyer
* @version 1.0
* Programming Project One
* CS 322 - Compiler Construction
* Spring 2019
*/

import java.util.*;

public class MatchingRunner extends MatchingClass {

	public static void main(String []args) {
		//creates object of java file this instantiates
		MatchingClass matching1 = new MatchingClass();
		boolean cancel = false;
		Scanner reader = new Scanner(System.in);
		//gives user the option to parse the file name of their choice
		System.out.println("Welcome to the HashMap Program. Please type the name of the file you would like to read(auth.log is the name of the file saved): ");
		args[0]  = reader.nextLine();
		matching1.readFile(args[0]);
		//asks them which option they would like to print to the screen
		System.out.println("Next, please type in the option of 0, 1, or 2 to print the output you desire. An Explanation of each option is shown below.");
		System.out.println("Option 0: Print default output, Option 1: Print the hashmap of IP addresses and default output, Option 2: Print the hashmap of usernames and default output.");
		System.out.println("Type your option number desired here: ");
		args[1] = reader.nextLine();
		//goes through loop to ask user if they would like to print a different output
		while(cancel == false) {
			if(args[1].equals("0")) {
				System.out.println("arg[1] ='0'");
				System.out.println(matching1.parseTimes()+" lines in the log file were parsed.");
				System.out.println("There are "+ matching1.sizeIp() + " unique IP addresses in the log.");
				System.out.println("There are "+ matching1.sizeUser() + " unique users in the log.");
			}else if(args[1].equals("1")) {
				System.out.println("arg[1] = '1'");
				matching1.printIp();
				System.out.println(matching1.parseTimes() + " lines in the log file were parsed.");
				System.out.println("There are " + matching1.sizeIp() + " unique IP addresses in the log.");
				System.out.println("There are " + matching1.sizeUser() + " unique users in the log.");
			}else if(args[1].equals("2")) {
				System.out.println("arg[1] = '2'");
				matching1.printUser();
				System.out.println(matching1.parseTimes() + " lines in the log file were parsed.");
				System.out.println("There are " + matching1.sizeIp() + " unique IP addresses in the log.");
				System.out.println("There are " + matching1.sizeUser() + " unique users in the log.");
			}else{
				System.out.println("args[1] = '0'");
				System.out.println(matching1.parseTimes() + " lines in the log file were parsed.");
				System.out.println("There are " + matching1.sizeIp() + " unique IP addressed in the log.");
				System.out.println("There are " + matching1.sizeUser() + " unique users in the log.");
			}
			System.out.println();
			args[1] = "";
			//if the user does not want to continue, they type exit to terminate the program
			System.out.println("Type 'exit' to terminate the program. Type any another option number to print different output: ");
			args[1]  = reader.nextLine();
			if(args[1].equals("exit"))
				cancel = true;
		 
		}

	}
}



