package com.framework.utilities;

import java.util.Random;

public class MockDataGenerator {

	private static final Random RANDOM = new Random();

	public static String generateUsername() {
		return "user" + RANDOM.nextInt(10000);
	}

	public static String generatePassword() {
		return "password" + RANDOM.nextInt(10000);
	}

	public static String generateEmail() {
		return "test" + RANDOM.nextInt(10000) + "@example.com";
	}

	public static String generatePhoneNumber() {
		return "+1-" + (100000000 + RANDOM.nextInt(900000000));
	}

	public static String generateAddress() {
		return "1234 Main St, City" + RANDOM.nextInt(100) + ", Country";
	}

	public static String generateDOB() {
		int day = RANDOM.nextInt(28) + 1;
		int month = RANDOM.nextInt(12) + 1;
		int year = RANDOM.nextInt(30) + 1990; // Between 1990 and 2020
		return String.format("%02d/%02d/%d", day, month, year);
	}

	public static void main(String[] args) {
		System.out.println("Username: " + generateUsername());
		System.out.println("Password: " + generatePassword());
		System.out.println("Email: " + generateEmail());
		System.out.println("Phone Number: " + generatePhoneNumber());
		System.out.println("Address: " + generateAddress());
		System.out.println("Date of Birth: " + generateDOB());
	}
}
