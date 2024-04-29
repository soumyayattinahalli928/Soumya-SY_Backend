package com.demo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperations {
	public static int[] createArray() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter size of an array");
		int size = sc.nextInt();
		
		int[] arr1 = new int[size];
		System.out.println("enter array elements");
		
		
		for(int i=0;i<size;i++) {
			arr1[i] = sc.nextInt();
		}
		int[] res = new int[arr1.length];
		for(int j=0;j<arr1.length;j++) {
			int k=0;
			res[k++] = arr1[j];
		}
		return res;
		
		
	}
	public static void printArray(int arr1[]) {
		
		for(int i=0;i<arr1.length;i++) {
			System.out.println(arr1[i]);	
		}
		
	}
	public static void reverseArray() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter size of an array");
		int size = sc.nextInt();
		
		int[] arr1 = new int[size];
		System.out.println("enter array elements");
		
		
		for(int i=0;i<size;i++) {
			arr1[i] = sc.nextInt();
		}
		
		for(int i=0;i<size;i++) {
			System.out.println(arr1[i]);
			
		}
		System.out.println("---------");
		// reverse
		for(int i=size-1;i>=0;i--) {
			System.out.println(arr1[i]);	
		}
		
		
	}
	public static int[] sortArray(int arr[]) {
//		Scanner sc=new Scanner(System.in);
//		System.out.println("enter size of an array");
//		int size = sc.nextInt();
//		
//		int[] arr = new int[size];
//		System.out.println("enter array elements");
//		
//		
//		for(int i=0;i<size;i++) {
//			arr[i] = sc.nextInt();
//		}
		
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		int[] res = new int[arr.length];
		for(int j=0;j<arr.length;j++) {
			int k=0;
			res[k++] = arr[j];
		}
		return res;
		
	}
	public static int[] mergeArray(int arr1[], int arr2[]) {
		
		int[] arr3 = new int[arr1.length+arr2.length];
		int k=0;
		for(int i=0;i<arr3.length;i++) {
			if(i<arr1.length) {
				arr3[i] = arr1[i];
			}
			else {
				arr3[i] = arr2[k++];
			}
		}
		int[] res= new int[arr3.length];
		for(int i=0;i<arr3.length;i++) {
			
			int j=0;
			res[j++] = arr3[i];
		}
		
		return res;
		
		
	}
	public static void zigZagMergeArray(int arr1[], int arr2[]) {
			
		int[] arr3 = new int[arr1.length+arr2.length];
		int i=0;
		int j=0;
		int k=0;

			while(i<arr1.length && i<arr2.length) {
			arr3[i++] = arr1[k++];
			arr3[i++] = arr2[j++];
			
			}
			while(i<arr1.length) {
				arr3[i++] = arr1[k++];
			}
			while(i<arr2.length) {
				arr3[i++] = arr1[j++];
			}
			

		for(int x=0;x<arr3.length;x++) {
			System.out.println(arr3[x]);
		}
	}
	
	public static int maxElement() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter size of an array");
		int size = sc.nextInt();
		
		int[] arr1 = new int[size];
		System.out.println("enter array elements");
		
		
		for(int i=0;i<size;i++) {
			arr1[i] = sc.nextInt();
		}
		for(int i=0;i<size;i++) {
			System.out.println(arr1[i]);	
		}
		System.out.println("-----");
		int max = arr1[0];
		for(int i=0;i<arr1.length;i++) {
			if(arr1[i]>max) {
				max = arr1[i];
			}
		}
	 
		return max;
		
	}
	public static int minElement() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter size of an array");
		int size = sc.nextInt();
		
		int[] arr1 = new int[size];
		System.out.println("enter array elements");
		
		
		for(int i=0;i<size;i++) {
			arr1[i] = sc.nextInt();
		}
		for(int i=0;i<size;i++) {
			System.out.println(arr1[i]);	
		}
		System.out.println("-----");
		int min = arr1[0];
		for(int i=0;i<arr1.length;i++) {
			if(arr1[i]<min) {
				min = arr1[i];
			}
		}
		return min;
	}
	public static void unionArray(int arr1[], int arr2[]) {
		
		int count=0;
			
//		 arr3 = mergeArray(arr1, arr2);
//		int[] sort = new int[arr3.length];
//		sort = sortArray(arr3);
//		System.out.println(Arrays.toString(sort));
		
		int[] arr3 = new int[arr1.length+arr2.length];
		for(int i=0;i<arr3.length;i++) {
			for(int j=i;j<arr3.length;j++) {
				if(arr1[i]==arr2[j]) {
					arr2[j]=-1;
					count++;
				}
			}
		}
	
		int[] res=new int[arr3.length-count];
		int k=0;
		for(int i=0;i<arr3.length;i++) {
			if(arr3[i]!=-1) {
				res[k++]=arr3[i];
			}
		}
		
		System.out.println(Arrays.toString(res));
		
	}
	
	public static void pattern1() {
	int n=1;
		for(int i=1;i<=5;i++) {
			n=1;
			for(int j=1;j<=5;j++) {
				
				System.out.print(n++ + " ");
			
			}
			System.out.println();
		}
	}
	
	public static void pattern2() {
		int n=1;
			for(int i=1;i<=5;i++) {

				for(int j=1;j<=5;j++) {
					
					System.out.print(i + " ");
				}
				System.out.println();
			}
		}
	
	public static void pattern3() {
		int n=1;
			for(int i=1;i<=5;i++) {
					int k=i;
				for(int j=1;j<=i;j++) {
					
					System.out.print(k++ + " ");
				}
				System.out.println();
			}
	}
	
	public static void intersectionArray() {
		
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
//		
//		System.out.println(createArray());
//		
//		int arr1[] = {2,4,3,1,9,12};
//		
//		printArray(arr1);
		
//		reverseArray();
		
//		System.out.println(sortArray(arr1));
		
		int arr1[] = {1,6,5,7};
		int arr2[] = {5,4,6,8};
//		mergeArray(arr1, arr2);
		
//		zigZagMergeArray(arr1, arr2);
		
//		System.out.println("max element is:"+ maxElement());
		
//		System.out.println("min element is:"+ minElement());
		 unionArray(arr1,arr2);
		
//		pattern1();
//		pattern2();
//		pattern3();
		
	}

}
