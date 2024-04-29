package com.demo;

import java.util.Arrays;

public class ArrayOperations {
	public static void printDuplicateElements(int arr[]) {
		
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]==arr[j]) {
				System.out.println(arr[j]);
			
				}			
			}		
		}	
	}
	
	public static void removeDuplicates(int arr[]){
		
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]==arr[j]) {
					arr[j] = -1;
			
				}			
			}
			
		}
	
		int res[] = new int[arr.length];
		int k=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=-1){
				res[k++] = arr[i];	
				}	
		}
	
		
		System.out.println(Arrays.toString(res));
		
	}
	
	public static void countPrime(int[] arr) {
		
		int primecount=0;
		for(int i=0;i<arr.length;i++) {
			int count=0;
			for(int j=1;j<=arr[i];j++) {
				if(arr[i]%j==0) {
					count++;
				}
			}
				
		if(count==2) {
			primecount++;
		}
		
	}
		System.out.println("prime count="+primecount);
	}
	
	public static void occuranceArray(int arr[]) {
		int freq[]=new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			freq[i]=1;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]==arr[j]) {
					arr[j]=-1;
					freq[i]++;
			
				}			
			}		
		}	
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=-1) {
			System.out.println(arr[i] + "======>" + freq[i]);
		}
		}
	}
	
	public static void pattern4() {
		int n=5;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(j%2==0) {
					System.out.print("0"+" ");
				}
				else {
					System.out.print("1"+" ");
				}
			}
			System.out.println();
		}
	}
	
	public static void pattern5() {
		int n=5;
		for(int i=1;i<=n;i++) {
		
			for(int j=1;j<=n;j++) {
				System.out.print(j + "," + i + " ");	
			}
			System.out.println();
		}
	}
public static void main(String[] args) {
	int arr[] = {2,4,3,9,4,3,12,2,1};
//	removeDuplicates(arr);
//	printDuplicateElements(arr);
//	countPrime(arr);
//	occuranceArray(arr);
	
//	pattern4();
	pattern5();
}
}
