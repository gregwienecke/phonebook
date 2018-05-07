/**
Project 2 PhoneBook Application
Write a program to simulate the actions of a phonebook.
Your program should be able to :
Add new entries 
Search for an existing entry
Search by first name *
Search by last name *
Search by full name *note name is not unique therefore the result should be an array of Person Objects.
Search by telephone number
Search by city or state
Delete a record for a given telephone number
Update a record for a given telephone number
Show all records in asc order
An option to exit the program 
Your program should operate on the console. It should display all the choices when the program loads. Eg 1. Add new record
    2. Delete a record
               Etc.. where 1 representing the action for adding a record and 2 representing the action
               for deleting a record.
Your program should run until the user selects the exit option. 
Your program should have a minimum of 2 classes a Person class, an Address  class.

Test case :
John Doe, 114 Market St, St Louis, MO, 63403, 6366435698
John E Doe, 324 Main St, St Charles, MO,63303, 8475390126
John Michael West Doe, 574 Pole ave, St. Peters, MO, 63333, 5628592375

Searching for John should return a list of all 3 records above, displaying the telephone number in this order (636)-453-8563.

Optional add additional features to your program, for storing cell, home, work and fax numbers. 
Also features for storing events like birthday, anniversary, email… etc   
 */

package phonebook;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Test {
	
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {		
		// Instantiate people 
		Address address1 = new Address("114 Market St", "St. Louis", "MO", "63403");
		Person person1 = new Person("John", "Doe", 2223334444L, address1);
		
		Address address2 = new Address("324 Main St", "St. Charles", "MO", "63303");
		Person person2 = new Person("John", "E", "Doe", 3145556767L, address2);
		
		Address address3 = new Address("574 Pole Ave", "St. Peters", "MO", "63333");
		Person person3 = new Person("John", "Michael West", "Doe", 3142124546L, address3);
		
		Person person4 = new Person();
		person4.setFirstName("Greg");
		person4.setLastName("Wienecke");
		person4.setMiddleName("K");
		person4.setPhone(4444444444L);
		Address gregAddress = new Address("444 Test St", "St. Louis", "MO", "63130");
		person4.setAddress(gregAddress);

		
		// Instantiate a phonebook (array of people objects)
		ArrayList<Person> phonebook = new ArrayList<Person>();
		phonebook.add(0, person1);
		phonebook.add(1, person2);
		phonebook.add(2, person3);
		phonebook.add(3, person4);
		
		printArrayList(phonebook);
		
		boolean runProgram = true;

		while (runProgram) {
			// Display menu of choices
			System.out.println("");
			System.out.println("1. Search by first name");
			System.out.println("2. Search by last name");
			System.out.println("3. Search by whole name");
			System.out.println("4. Search by city or state");
			System.out.println("5. Search by phone number");
			System.out.println("6. Add new record");
			System.out.println("7. Delete a record for a given phone number");
			System.out.println("8. Update a record for a given phone number");
			System.out.println("9. Show all records");
			System.out.println("10. Exit");
			System.out.println("");
			System.out.println("What would you like to do? Enter a number (1-10):");
			int answer = input.nextInt();
			input.nextLine();

			switch(answer){
				case 1: 
					// SEARCH FIRST NAME
					System.out.println("You chose " + answer + ": Search by first name"); 
					System.out.println("");
					System.out.println("Please enter the first name to search for ");
					String firstNameSearch = input.next();
					ArrayList<Person> results = searchFirstName(phonebook, firstNameSearch);
					if (results.size() < 1) {
						System.out.println("No matches");
					} else {
						printArrayList(results);
					}
					break;	

				case 2: 
					// SEARCH LAST NAME
					System.out.println("You chose " + answer + ": Search by last name"); 
					System.out.println("");
					System.out.println("Please enter the last name to search for ");
					String lastNameSearch = input.next();
					ArrayList<Person> lastNameresults = searchLastName(phonebook, lastNameSearch);
					if (lastNameresults.size() < 1) {
						System.out.println("No matches");
					} else {
						printArrayList(lastNameresults);
					}
					break;
				
				case 3: 
					// SEARCH WHOLE NAME
					System.out.println("You chose " + answer + ": Search by whole name"); 
					System.out.println("");
					System.out.println("Please enter the first and last names separated by a space");
					String[] wholeName = input.nextLine().split(" ");
					String wholeFirst = wholeName[0];
					String wholeLast = wholeName[1];
					ArrayList<Person> wholeNameresults = searchWholeName(phonebook, wholeFirst, wholeLast);
					if (wholeNameresults.size() < 1) {
						System.out.println("No matches");
					} else {
						printArrayList(wholeNameresults);
					}
					break;
					
				case 4: 
					// SEARCH CITY OR STATE
					System.out.println("You chose " + answer  + ": Search by city or state");
					System.out.println("");
					System.out.println("Please enter the city or state to search for ");
					String cityStateSearch = input.nextLine();
					
					ArrayList<Person> cityStateresults = searchCityOrState(phonebook, cityStateSearch);
					if (cityStateresults.size() < 1) {
						System.out.println("No matches");
					} else {
						printArrayList(cityStateresults);
					}
					break;	
					
				case 5:
					// SEARCH BY PHONE NUMBER
					System.out.println("You chose " + answer   + ": Search by phone number");
					System.out.println("");
					System.out.println("Enter the phone number to search");
					long inputNumber = input.nextLong();
					input.nextLine();
					searchByPhoneNumber(phonebook, inputNumber);
					break;
					
				case 6: 
					// ADD NEW ENTRY
					System.out.println("You chose " + answer + ": Add new record");
					System.out.println("");
					
					Person newPerson = createNewRecord();
					phonebook.add(phonebook.size(), newPerson);
					System.out.println("New record added");
					break;	
					
				case 7: 
					// DELETE RECORD FOR A GIVEN PHONE NUMBER 
					System.out.println("You chose " + answer   + ": Delete a record for a given phone number");
					System.out.println("");
					System.out.println("Enter the phone number to delete");
					long inputDeleteNumber = input.nextLong();
					input.nextLine();
					deleteRecordByNumber(phonebook, inputDeleteNumber);
					break;	
					
				case 8: 
					// UPDATE A RECORD FOR A GIVEN PHONE NUMBER
					System.out.println("You chose " + answer  + ": Update a record for a given phone number");
					System.out.println("");
					System.out.println("Enter the phone number to update the record");
					long updateNumber = input.nextLong();
					input.nextLine();
					updateRecord(phonebook, updateNumber);
					break;	
					
				case 9: 
					// SHOW ALL RECORDS
					System.out.println("You chose " + answer  + ": Show all records");
					System.out.println("");
					sort(phonebook);
					for (Person per : phonebook) {
						System.out.println(per);
					}
					System.out.println("");
					break;	
					
				case 10: 
					// EXIT
					System.out.println("Bye");
					runProgram = false;
					break;	
				default: System.out.println("Invalid input");
					break;
			}
		} // end while
		input.close();
	} // end main
	
	
	// 1 Search ArrayList by firstName and return all matching results
	public static ArrayList<Person> searchFirstName(ArrayList<Person> phonebook, String firstName){
		ArrayList<Person> firstNameMatches = new ArrayList<Person>();
		for (int i = 0; i < phonebook.size(); i++) {
			if (phonebook.get(i).getFirstName().equals(firstName)) {
				firstNameMatches.add(phonebook.get(i));
			}
		}
		return firstNameMatches;
	}
	
	// 2 Search ArrayList by lastName and return all matching results
	public static ArrayList<Person> searchLastName(ArrayList<Person> phonebook, String lastName){
		ArrayList<Person> lastNameMatches = new ArrayList<Person>();
		for (int i = 0; i < phonebook.size(); i++) {
			if (phonebook.get(i).getLastName().equals(lastName)) {
				lastNameMatches.add(phonebook.get(i));
			}
		}
		return lastNameMatches;
	}
	
	// 3 Search ArrayList by whole name and return all matching results
	public static ArrayList<Person> searchWholeName(ArrayList<Person> phonebook, String firstName, String lastName){
		ArrayList<Person> wholeNameMatches = new ArrayList<Person>();
		for (int i = 0; i < phonebook.size(); i++) {
			if ( phonebook.get(i).getFirstName().equals(firstName) && phonebook.get(i).getLastName().equals(lastName) ) {
				wholeNameMatches.add(phonebook.get(i));
			}
		}
		return wholeNameMatches;
	}
	
	// 4 Search ArrayList by city or state and return all matching results
	public static ArrayList<Person> searchCityOrState(ArrayList<Person> phonebook, String userInput){
		ArrayList<Person> cityStateMatches = new ArrayList<Person>();
		for (int i = 0; i < phonebook.size(); i++) {
			if (phonebook.get(i).getAddress().getCity().equals(userInput) || phonebook.get(i).getAddress().getState().equals(userInput)) {
				cityStateMatches.add(phonebook.get(i));
			}
		}
		return cityStateMatches;
	}
	
	// 5 Search ArrayList by phone number
	public static void searchByPhoneNumber(ArrayList<Person> phonebook, long phoneNumber){
		boolean foundMatch = false;
		for (int i = 0; i < phonebook.size(); i++) {
			if (phonebook.get(i).getPhone() == phoneNumber) {
				System.out.println(phonebook.get(i));		
				foundMatch = true;
			}
		}
		if (!foundMatch) {
			System.out.println("That number is not in the phone book");
		}
	}
	
	// 6 Create new record
	public static Person createNewRecord() {
		// Get user input
		System.out.println("Enter the new record with info separated by comma and space");
		System.out.println("(ex: John Example Doe, 213 Test St, Springfield, IL, 63130, 3143334444)");
		String userInput = input.nextLine();
		String[] userInputArray = userInput.split(", ");
		
		String[] names = userInputArray[0].split(" ");
		
		// Create the first, middle, and last name variables
		boolean hasMiddleName = false;
		String firstName = names[0];
		String middleName = "";
		String lastName = "";
		if (names.length == 3) {
			middleName = names[1];			
			hasMiddleName = true;
			lastName = names[2];
		} else {
			lastName = names[1];
		}

		// Create the phone and address variables
		String street = userInputArray[1];
		String city = userInputArray[2];
		String state = userInputArray[3];
		String zipCode = userInputArray[4];
		String phone = userInputArray[5];
		
		// Create the address object
		Address address = new Address(street, city, state, zipCode);
		
		// Create the person object using the appropriate constructor, and then return it
		if (hasMiddleName) {
			Person newPerson = new Person(firstName, middleName, lastName, Long.parseLong(phone), address);
			return newPerson;
		} else {
			Person newPerson = new Person(firstName, lastName, Long.parseLong(phone), address);				
			return newPerson;
		}
	}
	
	// 7 Delete record by phone number
	public static void deleteRecordByNumber(ArrayList<Person> arrayToSearch, long inputNumber) {
		boolean foundNumber = false;
		for (int i = 0; i < arrayToSearch.size(); i++) {
			if (arrayToSearch.get(i).getPhone() == inputNumber) {
				foundNumber = true;
				// Delete the record
				arrayToSearch.remove(i);
				System.out.println("The record has been deleted");
			}
		}
		if (foundNumber == false) {
			System.out.println("That number is not in the phonebook");
		}
	}
	
	
	// 8 Update a record for a given phone number
	public static void updateRecord(ArrayList<Person> phonebook, long phoneNumber) {
		Person targetRecord = new Person();
		boolean match = false;
		String successMessage = "Record has been updated:";
		// Loop through the phone and find matching record
		for (int i = 0; i < phonebook.size(); i++) {
			if (phonebook.get(i).getPhone() == phoneNumber) {
				targetRecord = phonebook.get(i);
				match = true;
			}
		}
		// Ask user what data they want to update
		if (match) {
			System.out.println("What would you like to update? Choose a number(1-5):");
			System.out.println("1. First name");
			System.out.println("2. Middle name");
			System.out.println("3. Last name");
			System.out.println("4. Phone number");
			System.out.println("5. Address");
			
			// Get user answer
			int updateAnswer = input.nextInt();
			input.nextLine();
			
			// Update desired data
			switch(updateAnswer) {
				case 1:
					// 8.1 Update first name
					System.out.println("Enter the new first name:");
					String newFirstName = input.next();
					targetRecord.setFirstName(newFirstName);
					System.out.println(successMessage);
					System.out.println(targetRecord);
					break;

				case 2:
					// 8.2 Update middle name
					System.out.println("Enter the new middle name:");
					String newMiddleName = input.next();
					targetRecord.setMiddleName(newMiddleName);
					System.out.println(successMessage);
					System.out.println(targetRecord);
					break;

				case 3:
					// 8.3 Update last name
					System.out.println("Enter the new last name:");
					String newLastName = input.next();
					targetRecord.setLastName(newLastName);
					System.out.println(successMessage);
					System.out.println(targetRecord);
					break;

				case 4:
					// 8.4 Update phone number
					System.out.println("Enter the new phone number:");
					long newPhone = input.nextLong();
					input.nextLine();
					targetRecord.setPhone(newPhone);
					System.out.println(successMessage);
					System.out.println(targetRecord);
					break;

				case 5:
					// 8.5 Update the address
					System.out.println("Enter the new street name");
					String newStreet = input.nextLine();
					System.out.println("Enter the new city");
					String newCity = input.nextLine();
					System.out.println("Enter the new state abbreviation");
					String newState = input.next();
					System.out.println("Enter the new zip code");
					String newZip = input.next();
					
					Address updateAddress = new Address(newStreet, newCity, newState, newZip);
					targetRecord.setAddress(updateAddress);
					System.out.println(successMessage);
					System.out.println(targetRecord);
					break;

				default: System.out.println("Invalid input");
					break;	
			}
		} else {
			System.out.println("That number is not in the phone book");
		}

	}
	
	
	// 9 Print all records SORTED in a Person ArrayList
	public static void sort(ArrayList<Person> people) {
		Collections.sort(people, Person.personComparator);		
	}

	//Print each element in an Person ArrayList
	public static void printArrayList(ArrayList<Person> arrayToPrint) {
		for (int i = 0; i < arrayToPrint.size(); i++) {
			System.out.println(arrayToPrint.get(i));
		}
	}
	
} // end class
