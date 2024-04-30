package com.demo;

public class Patterns {
	
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
//			pattern1();
//			pattern2();
//			pattern3();
//			pattern4();
			pattern5();
		}
}
