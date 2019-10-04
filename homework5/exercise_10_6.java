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

package homework5;

import java.util.ArrayList;
import java.util.Iterator;

class StackOfIntegers
{
	private ArrayList<Byte> primes = new ArrayList<Byte>(0);
	
	// Function to determine whether number is prime or not
	private boolean isPrime(byte num) {
		boolean prime = true;
		
		// Check num against all primes currently in our primes list
			// If num is not divisible by any of the primes in the FIRST HALF of our primes list
			// Then it is prime and we can continue
			// But as  soon as we find a prime divisor, will set prime to false and break out of loop
		
		Iterator<Byte> primeList = primes.iterator();
		
		// FIND NEW METHOD TO CHECK VALUES OF OUR ARRAY LIST
		// HERE WE EVALUATE EVERY PRIME IN LIST, WE ONLY NEED FIRST HALF
		while(primeList.hasNext()) {
			if ((num / primeList.next().floatValue()) % 1 == 0) {
				prime = false;
				break;
			}
		}
		
		if (prime) { return true; }
		else { return false; }
	}
	
	// Function to capture all primes less than 120
	// We do not need to evaluate even numbers after 2
	public ArrayList<Byte> getPrimes() {
		// Assuming we're given fixed value of 2 or greater
		primes.add((byte)2);
		
		for(byte i = 3; i <= 120; i+=2) {
			if(isPrime(i)) { primes.add((byte)i); }
		}
		
		return primes;
	}
		
	// Function to print all captured primes in reverse order
	public void primeReversePrint(ArrayList<Byte> primes) {
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
		
		stack.primeReversePrint(stack.getPrimes());
	}
}
