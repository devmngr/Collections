// ***************************************************
// File name  : Recursive.java
// Start date : 
// Programmer : Hans So.
// Java       : Java 1.7
// Description:
// ***************************************************

package util;

public class Math {

	public static long fac(int n) // factorial
	{
		if (n == 0) {
			return 1;
		} else
			return n * fac(n - 1);
	}

	public static int sum(int n) // 1 + 2 + .. + n
	{
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else
			return n + sum(n - 1);

	}

	public static double power(double x, int n) // x raised to n'th power; n >=
												// 0
	{
		if (n == 0) {
			return 1;
		} else if (n == 1 && x != 0) {
			return x;
		} else if (x == 0) {
			return 0;
		}

		else

			return x * power(x, n - 1);

	}

	public static long fib(int n) // Fibonacci numbers
	{
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else
			return fib(n - 2) + fib(n - 1);
	}

	public static long iterativeFib(int n) // Fibonacci numbers, iterative
											// solution
	{
		int result = 0;
		int x = 1;
		int y = 1;
		for (int i = 0; i < n; i++) {
			x = y;
			y = result;
			result = x + y;
		}
		return result;
	}

	// a: from, b: to, c: using
	public static void moveHanoiTower(int n, char a, char b, char c) // perhaps
	// static
	{
		if (n == 1) {
			System.out.println(a + " -> " + b);
		} else {
			moveHanoiTower(n - 1, a, c, b);
			System.out.println(a + " -> " + b);
			moveHanoiTower(n - 1, c, b, a);
		}
	}

	// prints the string s reverse; e.g if s = "abcd", the method prints "dcba"
	public static void printString(String s) {

		char[] in = s.toCharArray();
	    int begin=0;
	    int end=in.length-1;
	    char temp;
	    while(end>begin){
	        temp = in[begin];
	        in[begin]=in[end];
	        in[end] = temp;
	        end--;
	        begin++;
	    }
	    System.out.println(in);

	}

	// prints val in base 2; e.g. if val = 3, 101 is printed
	public static void printInt(int val) {
		 String binary = "";
		    int temp = val/2+1;
		    for (int j = 0; j < temp ; j++) {
		        try {
		            binary += "" + val % 2;

		            val /= 2;
		        } catch (Exception e) {
		        }
		    }
		    for (int j = binary.length() - 1; j >= 0; j--) {
		        System.out.print(binary.charAt(j));
		    }
	}

	// prints val in base; e.g. if base is 16, the value is printed in
	// hexadecimal.
	// Example: val = 19 is printed as A3; base = 2 and value = 19: 10011 is
	// printed
	public static void printInt(int value, int base) {

		if (base == 16)
			System.out.println(String.format("%x", value));
		else
			printInt(value);
	}

	public static void main(String[] args) {

		 moveHanoiTower(5, 'a', 'b','c');
		
	}
}