package phonebook;

import java.util.Comparator;

public class Person {
	// Properties
	private String firstName;
	private String middleName;
	private String lastName;
	private long phone;
	private Address address;
	
	// Constructors
	public Person() {}
	public Person(String firstName, String middleName, String lastName, long phone, Address address) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	// No middle name constructor
	public Person(String firstName, String lastName, long phone, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}

	// Methods
	// Return phone number as String
	public static String returnPhoneNumberAsString(long phoneNumber) {
		String phoneString = Long.toString(phoneNumber);
		String areaCode = phoneString.substring(0,3);
		String first3 = phoneString.substring(3,6);
		String last4 = phoneString.substring(6,10);
		phoneString = "(" + areaCode + ")-" + first3 + "-" + last4;
		return phoneString;
	}
	
	public String toString() {
		if (this.middleName == null) {
			return this.firstName + " " + this.lastName + ", " + this.address + ", " + returnPhoneNumberAsString(this.phone);			
		} else {
			return this.firstName + " " + this.middleName + " " + this.lastName + ", " + this.address + ", " + returnPhoneNumberAsString(this.phone);
		}
	}
	
	public static Comparator<Person> personComparator = new Comparator<Person>() {
		public int compare(Person p1, Person p2) {
//			String person1WholeName = p1.getLastName() + p1.getFirstName() + p1.getMiddleName();
//			String person2WholeName = p2.getLastName() + p2.getFirstName() + p2.getMiddleName();
			String person1WholeName = p1.getLastName() + p1.getFirstName();
			String person2WholeName = p2.getLastName() + p2.getFirstName();
			
			return person1WholeName.compareTo(person2WholeName);
		}
	};
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}	
	
}
