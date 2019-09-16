/**  This class serves as the purpose to read the log file and place each instance of an IP address and username into their respective hashmaps.
*  This class will also track the amount of unique IP addresses and usernames.
* @author rmeyer
* @version 1.0
* Programming Project One
* CS322 - Compiler Construction
* Spring 2019
*/

import java.util.*;
import java.util.regex.*;
import java.io.*;
import java.util.*;

public class MatchingClass {
	//creates two Hash Maps one for IP addresses and one for usernames
	static HashMap<String, Integer> ip = new HashMap<String, Integer>();
	static HashMap<String, Integer> user = new HashMap<String, Integer>();
	static String ipFormat = ("\\b(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\b");
	static String userFormat  = ("\\b(user)\\s(\\w+)\\b");
	static Pattern u = Pattern.compile(userFormat);
	static Pattern p = Pattern.compile(ipFormat);
	static int parse = 0;

public static void  readFile(String file) {
//this method will read through the log file typed in and search for the desired regex and place into respective Hash Map
	int counter = 0;
	String line = "";

	String fileName = file;
	ArrayList<String> first = new ArrayList<>();
	ArrayList<String> second = new ArrayList<>();

	try{

		FileReader inputFile = new FileReader(fileName);
		BufferedReader bufferReader = new BufferedReader(inputFile);

		//reads the file line by line
		while((line = bufferReader.readLine()) != null) {

			Matcher ipMatch = p.matcher(line);
			Matcher userMatch = u.matcher(line);
			parse++;
			//if a match is found then it is placed into respective Hash Map
			if(ipMatch.find()) {
				first.add(ipMatch.group());
			}
			if(userMatch.find()) {
				second.add(userMatch.group().substring(5));
			}
		}
				//will see if this username/IP exists. If it does, it will add one to the number of instances. If not, adds a new line to map.
				for(String r: first) {
					Integer i = ip.get(r);
					if(i == null) {
						ip.put(r,1);
					}else{
						ip.put(r, i+1);
					}
				}

				for(String z : second) {
					Integer b = user.get(z);
					if(b == null) {
						user.put(z,1);
					}else{
						user.put(z, b+1);
					}
				}
		bufferReader.close();
	//throws an exception and reads error if occurs.
	}catch(Exception e) {
		System.out.println("Error while reading file line by line:" + e.getMessage());
	}
}

public static void printUser() {
	//prints the contents of the Username Hash Map.
	user.forEach((key, value) -> 
		System.out.println(key + ": " + value));

}

public static void printIp() {
	//prints the contents of the IP address Hash Map.
	ip.forEach((key, value) ->
		System.out.println(key + ": " + value));
}

public static int  sizeUser() {
	//prints the size of the Username Hash Map.
	int uSize = user.size();
	return uSize;
}

public static int sizeIp() {
	//prints the size of the IP address Hash Map.
	int uIp = ip.size();
	return uIp;
}

public static int parseTimes() {
	//counts the number of times the file is parsed and will record this.
	int num = 0;
	num = parse;
	return num;	
}


}
