package com.recursion;

import java.util.Arrays;

class OddFunction {
	boolean run(int num) {
		if (num % 2 == 0) {
			return false;
		} else {
			return true;
		}
	}
}

public class RecursionMain {
	public static void print_N_Number(int n) {
		if (n < 1) {
			return;
		}
		System.out.print(n + " ");
		print_N_Number(n - 1);
	}

	public static void printArray(int[] arr, int i) {
		if (i == 5) {
			return;
		}
		System.out.print(arr[i] + " ");
		printArray(arr, i + 1);
	}

	public static int sum(int[] arr, int i, int sum) {
		if (i == arr.length) {
			return sum;
		}
		sum = sum + arr[i];

		sum = sum(arr, i + 1, sum);
		return sum;
	}

	static int n1 = 0, n2 = 1, n3 = 0;

	public static void fibonacci(int count) {
		if (count > 0) {
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
			System.out.print(n3 + " ");
			fibonacci(--count);
		}
	}

	public static void fibonacci1(int n1, int n2, int i, int count) {
		if (i == count)
			return;
		if (i == 0)
			System.out.print(n1 + " " + n2 + " ");
		else
			System.out.print(n2 + " ");
		n1 = n1 + n2;
		i++;
		fibonacci1(n2, n1, i, count);
	}

	public static int power(int base, int exp) {
		if (exp == 0)
			return 1;
		return base * power(base, exp - 1);
	}

	public static int greatestCommonDivisor(int n1, int n2) {
		if (n2 == 0)
			return n1;
		return greatestCommonDivisor(n2, n1 % n2);

	}

	public static int decimalToBinary(int n) {
		if (n == 0)
			return 0;

		return n % 2 + 10 * decimalToBinary(n / 2);
	}

	public static int factorial(int num) {

		if (num == 0)
			return 1;
		return num * (factorial(num - 1));
	}

	public static int productofArray(int A[], int N) {
		if (N == 0) {
			return 1;
		}
		N--;
		return A[N] * productofArray(A, N);
	}

	public static int sumOfRange(int num) {
		if (num == 0) {
			return 0;
		}
		return num + sumOfRange(num - 1);
	}

	public static boolean someRecursive(int[] arr, OddFunction odd) {
		if (arr.length == 0)
			return false;

		if (odd.run(arr[arr.length - 1]))
			return true;

		return someRecursive(Arrays.copyOf(arr, arr.length - 1), odd);
	}

	

	public static String reverse(String str) {
		if (str.length() == 0)
			return "";
		
		return reverse(str.substring(1))+str.charAt(0);
	}

	public static boolean isPalindrome(String str) {
		if (str.length() <= 1)
			return true;
		char firstChar = str.charAt(0);
		char lastChar = str.charAt(str.length() - 1);
		if (firstChar != lastChar)
			return false;
		return isPalindrome(str.substring(1, str.length() - 1));
	}

	public static char first(String str) {
		if (str.length() == 0)
			return 0;
		char ch = str.charAt(0);
		if (ch >= 65 && ch <= 90)
			return ch;
		return first(str.substring(1, str.length()));
	}

	public static String capitalizeWord(String str) {
		if (str.length() == 1)
			return Character.toString(Character.toUpperCase(str.charAt(0)));
		char ch = str.charAt(str.length()-1);
		
		if(ch!=' ' && str.charAt(str.length()-2)==' ')
		{
			ch= Character.toUpperCase(ch);
		}
		System.out.print(ch);
		return capitalizeWord(str.substring(0, str.length()-1))+ch;
	}

	public static void main(String args[]) {
		RecursionMain.print_N_Number(5);
		System.out.println();
		RecursionMain.printArray(new int[] { 1, 2, 3, 4, 5 }, 0);
		int sum = RecursionMain.sum(new int[] { 1, 2, 3, 4, 5, 6 }, 0, 0);
		System.out.println("\nSum=" + sum);
		// RecursionMain.fibonacci1(0,1,0,10);
		System.out.println();
		System.out.print("Fibonacci Series... 0 1 ");
		RecursionMain.fibonacci(10);
		System.out.println();
		System.out.println("PowerUp 3^4=" + RecursionMain.power(3, 4));

		int gcd = RecursionMain.greatestCommonDivisor(13, 39);
		System.out.println(gcd);
		int binaryValue = RecursionMain.decimalToBinary(25);
		System.out.println(binaryValue);

		int factorial = RecursionMain.factorial(4);
		System.out.println(factorial);

		int arr[] = { 1, 2, 3, 4, 5 };
		int productArray = RecursionMain.productofArray(arr, arr.length);
		System.out.println(productArray);

		int value = RecursionMain.sumOfRange(6);
		System.out.println("Sum of 6 Numbers=" + value);

		boolean status = RecursionMain.someRecursive(new int[] { 1, 2, 3, 4 }, new OddFunction());
		System.out.println("Had Odd Number=" + status);

		String str = RecursionMain.reverse("Naren");
		System.out.println("Reverse=" + str);

		status = RecursionMain.isPalindrome("foobar");
		System.out.println("Palindrome=" + status);

		char ch = RecursionMain.first("narEndr");
		System.out.println("Palindrome=" + ch);
		
		String s = RecursionMain.capitalizeWord("i love you");
		System.out.println("Capitalize="+s);
		

	}
}
