/*
Author:     Victor J. Bezak III
Date:       October 3rd, 2019
Assignment: Homework 5, Exercise 10.6

Description:
	Utilizes a StackOfIntegers class to find all prime numbers less than 120,
	and to ouput them in reverse order.
	Could have been executed with far more readability, however I wanted to
	utilize the byte primitive type and Byte wrapper class as an exercise in
	memory optimization.
*/

//package homework5;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

class StackOfIntegers
{
	private ArrayList<Byte> primes = new ArrayList<Byte>(0);
	
	// Function to determine whether number is prime or not
	private boolean isPrime(byte num) {
		boolean prime = true;
		
		// Check num against first half of primes currently in our primes list
			// If num is divisible by any of these primes
				//set prime to false and break out of loop
		
		Iterator<Byte> primeList = primes.iterator();
		byte checkTo = (byte)(primes.size() / 2);

		for(byte i = 0; i < checkTo; i++) {
			if ((num / primeList.next().floatValue()) % 1 == 0) {
				prime = false;
				break;
			}
		}
		if (prime) { return true; }
		else { return false; }
	}
	
	// Function to capture all primes less than 120
	public ArrayList<Byte> getPrimes(byte val) {
		if(val < 2) {
			System.out.print("there are no prime numbers less than " + val);
		}
		else {
			primes.add((byte)2);
			
			// Conditional (i < 115) is set to safeguard against post-increment overflow
			for(byte i = 3; i <= val && i < 115; i+=2) {
				if(isPrime(i)) { primes.add((byte)i); }
			}
		}		
		return primes;
	}
		
	// Function to print all captured primes in reverse order
	public void reversePrint(ArrayList<Byte> primes) {
		for(byte i = (byte)(primes.size() - 1); i >= 0; i--) {
			System.out.print(primes.get(i) + " ");
		}		
	}
}


public class exercise_10_6
{
	public static void main(String[] args)
	{
		StackOfIntegers stack = new StackOfIntegers();
		Scanner input = new Scanner(System.in);
		byte value;
		
		System.out.print("Enter value: ");
		try {
			value = input.nextByte();
			stack.reversePrint(stack.getPrimes(value));
		}
		catch(Exception InputMismatch) {
			System.out.println("byte input must be within range (-128 : 127)");
		}
		
		input.close();
	}
}
