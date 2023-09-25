package com.arrays;

import java.util.Arrays;

public class ArraysDemo {
	public static void main(String args[]) {

		System.out.println("Problem 1.....Middle Numbers");
		int myArray[] = { 1, 2, 3, 4, 5 };
		int retArray[] = middle(myArray);
		for (int a : retArray) {
			System.out.println(a);
		}

		System.out.println("Problem 1.....Top 2 Greatest Number");
		int myArray1[] = { 184, 85, 86, 187, 85, 90, 85, 83, 23, 45, 84, 2111, 2, 3000 };
		int retArray1[] = findTopTwoScores(myArray1);
		for (int a : retArray1) {
			System.out.println(a);
		}

		System.out.println("Problem 3.....Missing Number");
		int myArray3[] = { 1, 2, 3, 4, 5, 7, 8 };
		int retValue = findMissingNumberInArray(myArray3);
		System.out.println(retValue);

		System.out.println("Problem 4.....Remove Duplicate Number");
		int myArray4[] = { 2, 3, 8, 1, 1, 2, 2, 3, 4, 8, 5 };
		int retArray4[] = removeDuplicates(myArray4);
		for (int val : retArray4) {
			System.out.print(val + " ");
		}

		System.out.println("\nProblem 5.....Remove Duplicates from Sorted Array");
		int myArray5[] = { 1, 1, 1, 2, 3, 3, 4, 5, 6, 6, 6, 8 };
		int retArray5[] = removeDuplicatesFromSortedArray(myArray5);
		for (int val : retArray5) {
			System.out.print(val + " ");
		}

		System.out.println("\nProblem 6.....Best Time to Buy and Sell Stock");
		int myArray6[] = { 7, 1, 5, 3, 6, 4 };
		int retValue6 = maxProfit(myArray6);
		System.out.println(retValue6);

		System.out.println("\nProblem 7.....Two Sum");
		int myArray7[] = { 11, 15, 2, 7 };
		int retArray7[] = twoSum(myArray7, 9);
		for (int val : retArray7) {
			System.out.print(val + " ");
		}

		System.out.println("\nProblem 8.....Finding a Number");
		int[] myArray8 = { 1, 2, 3, 4, 5, 6 };
		int retValue8 = searchInArray(myArray8, 6);
		System.out.println(retValue8);

		System.out.println("\nProblem 9.....Two Sum");
		int myArray9[] = { 11, 15, 212, 7 };
		String retArray9 = maxProduct(myArray9);
		System.out.println(retArray9);
		
		System.out.println("\nProblem 10.....IsUnique / Contains Duplicate");
		int myArray10[] = {1,2,3,4,5,6};
		boolean retArray10 = isUnique(myArray10);
		System.out.println(retArray10);
		
		System.out.println("\nProblem 11.....IsUnique / Contains Duplicate");
		int[] array1 = {1,2,3,4,5};
		int[] array2 = {5,1,2,3,4};
		boolean retArray11 = permutation(array1, array2);
		System.out.println(retArray11);
	}

	public static boolean permutation(int[] array1, int[] array2) {
		
		return false;
    }
	public static boolean isUnique(int[] intArray) {
		for (int i = 0; i < intArray.length; i++) {
			for (int j = i + 1; j < intArray.length; j++) {
				if(intArray[i]==intArray[j])
					return false;
			}
		}
        return true;
    }
	
	public static String maxProduct(int[] intArray) {
		int maxProduct = 0;
		String maxValue = "";
		for (int i = 0; i < intArray.length; i++) {
			for (int j = i + 1; j < intArray.length; j++) {
				if( maxProduct < (intArray[i]*intArray[j]))
				{
					maxProduct = intArray[i]*intArray[j];
					maxValue = intArray[i]+","+intArray[j];
				}
			}
		}
		return maxValue;
	}

	public static int searchInArray(int[] intArray, int valueToSearch) {
		int c = 0;
		while (c < intArray.length) {
			if (intArray[c] == valueToSearch) {
				break;
			}
			c++;
		}
		return c;
	}

	public static int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		return new int[] { 0, 0 };
	}

	public static int maxProfit(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}
		int profit = 0;
		int investAmount = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			if (investAmount > prices[i]) {
				investAmount = prices[i];
			} else if (prices[i] - investAmount > profit) {
				profit = prices[i] - investAmount;
			}
		}

		return profit;
	}

	public static int[] removeDuplicatesFromSortedArray(int[] nums) {
		if (nums.length == 0) {
			return new int[0];
		}

		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
			}
		}

		return Arrays.copyOf(nums, i + 1);
	}

	public static int[] removeDuplicates(int[] arr) {

		boolean duplicatePresent = false;
		int[] uniqueArray = new int[arr.length];
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			duplicatePresent = false;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					duplicatePresent = true;
					break;
				}
			}
			if (!duplicatePresent) {
				uniqueArray[index++] = arr[i];
			}
		}

		return Arrays.copyOf(uniqueArray, index);
	}

	public static int findMissingNumberInArray(int[] arr) {

		int size = arr.length + 1;
		int sumOfGivenArrayUsingValue = 0;
		int sumOfGivenArrayUsingLength = (size * (size + 1)) / 2;
		System.out.println(sumOfGivenArrayUsingLength);
		for (int value : arr) {
			sumOfGivenArrayUsingValue += value;
		}
		System.out.println(sumOfGivenArrayUsingValue);
		return sumOfGivenArrayUsingLength - sumOfGivenArrayUsingValue;
	}

	public static int[] findTopTwoScores(int[] array) {
		if (array.length < 2) {
			return array;
		}
		int firstHighest = Integer.MIN_VALUE;
		int secondHighest = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (firstHighest < array[i]) {
				secondHighest = firstHighest;
				firstHighest = array[i];
			}
			if (secondHighest < array[i] && firstHighest > array[i]) {
				secondHighest = array[i];
			}
		}
		return new int[] { firstHighest, secondHighest };
	}

	public static int[] middle(int array[]) {
		if (array.length > 2) {
			int size = 0;
			int[] retArr = new int[array.length - 2];
			for (int i = 1; i < array.length - 1; i++) {
				retArr[size++] = array[i];
			}
			return retArr;
		} else
			return new int[0];
	}

}
