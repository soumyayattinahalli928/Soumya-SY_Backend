package com.patterns;

public class Patterns {
	
//	1 2 3 4 5 
//	1 2 3 4 5 
//	1 2 3 4 5 
//	1 2 3 4 5 
//	1 2 3 4 5 
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
	
//	1 1 1 1 1 
//	2 2 2 2 2 
//	3 3 3 3 3 
//	4 4 4 4 4 
//	5 5 5 5 5 
		
		public static void pattern2() {
			int n=1;
				for(int i=1;i<=5;i++) {

					for(int j=1;j<=5;j++) {
						
						System.out.print(i + " ");
					}
					System.out.println();
				}
			}
//		1 
//		2 3 
//		3 4 5 
//		4 5 6 7 
//		5 6 7 8 9 
		
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
//		1 0 1 0 1 
//		1 0 1 0 1 
//		1 0 1 0 1 
//		1 0 1 0 1 
//		1 0 1 0 1
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
//		1,1 2,1 3,1 4,1 5,1 
//		1,2 2,2 3,2 4,2 5,2 
//		1,3 2,3 3,3 4,3 5,3 
//		1,4 2,4 3,4 4,4 5,4 
//		1,5 2,5 3,5 4,5 5,5 

		
		public static void pattern5() {
			int n=5;
			for(int i=1;i<=n;i++) {
			
				for(int j=1;j<=n;j++) {
					System.out.print(j + "," + i + " ");	
				}
				System.out.println();
			}
		}
		
		//DAY2
		
//		A B C D E 
//		A B C D E 
//		A B C D E 
//		A B C D E 
//		A B C D E 
		public static void pattern6() {
				char c='A';
				int n=5;
				for(int i=1;i<=n;i++) {
					c='A';
					for(int j=1;j<=n;j++) {
						
						System.out.print(c++ + " ");
					
					}
					System.out.println();
				}
			}
//		a a a a a 
//		b b b b b 
//		c c c c c 
//		d d d d d 
//		e e e e e 
		
		public static void pattern7() {
			char c='a';
			int n=5;
			for(int i=1;i<=n;i++) {
				
				for(int j=1;j<=n;j++) {
					
					System.out.print(c + " ");
					
				}
				System.out.println();
				c++;
			}
		}
//		5 4 3 2 1 
//		5 4 3 2 1 
//		5 4 3 2 1 
//		5 4 3 2 1 
//		5 4 3 2 1 
		
		public static void pattern8() {
		
			int n=5;
			for(int i=n;i>=1;i--) {
			
				for(int j=n;j>=1;j--) {
					
					System.out.print(j + " ");
					
				}
				System.out.println();
				
			}
		}
		
//		* 
//		* * 
//		* * * 
//		* * * * 
//		* * * * * 
//		
		public static void pattern10() {
			int n=5;
				for(int i=1;i<=n;i++) {
					
					for(int j=1;j<=i;j++) {
						
						System.out.print("*" + " ");
					}
					System.out.println();
				}
		}
		
//		* * * * * 
//		* * * * 
//		* * * 
//		* * 
//		* 

		
		public static void pattern11() {
			int n=5;
				for(int i=1;i<=n;i++) {
					
					for(int j=n;j>=i;j--) {
						
						System.out.print("*" + " ");
					}
					System.out.println();
				}
		}
//		5 5 5 5 5 
//		4 4 4 4 
//		3 3 3 
//		2 2 
//		1 
		
		public static void pattern12() {
			int n=5;
			for(int i=n;i>=1;i--) {
				
				for(int j=1;j<=i;j++) {
					
					System.out.print(i + " ");
				}
				System.out.println();
				
			}
		}
		
//		1 
//		2 2 
//		3 3 3 
//		4 4 4 4 
//		5 5 5 5 5 
		
		public static void pattern13() {
			int n=5;
			for(int i=1;i<=n;i++) {
				
				for(int j=1;j<=i;j++) {
					
					System.out.print(i + " ");
				}
				System.out.println();
				
			}
		}
	
//		1 1 1 1 1 
//		2 2 2 2 
//		3 3 3 
//		4 4 
//		5 
		
		public static void pattern14() {
			int n=5;
			for(int i=1;i<=n;i++) {
				
				for(int j=n;j>=i;j--) {
					
					System.out.print(i + " ");
				}
				System.out.println();
				
			}
		}
		
//		1 2 3 4 5 
//		2 3 4 5 
//		3 4 5 
//		4 5 
//		5
		
		public static void pattern15() {
			int n=5;
			for(int i=1;i<=n;i++) {
				
				for(int j=i;j<=n;j++) {
					
					System.out.print(j + " ");
				}
				System.out.println();
				
			}
		}
		
//		5 
//		5 4 
//		5 4 3 
//		5 4 3 2 
//		5 4 3 2 1 
		
		public static void pattern16() {
			int n=5;
			for(int i=n;i>=1;i--) {
				
				for(int j=n;j>=i;j--) {
					
					System.out.print(j + " ");
				}
				System.out.println();
				
			}
		}
		
//        * 
//      * * * 
//    * * * * * 
//  * * * * * * * 
//* * * * * * * * * 
		
		public static void pattern17() {
			int n=5;
			for(int i=1;i<=n;i++) {
				
				for(int j=1;j<=n-i;j++) {	
					System.out.print("  ");
				}
				for(int j=1;j<=i*2-1;j++) {	
					System.out.print("* " );
				}
				System.out.println();
				
			}
		}
		
//        1 
//      0 0 0 
//    1 1 1 1 1 
//  0 0 0 0 0 0 0 
//1 1 1 1 1 1 1 1 1 
		
		public static void pattern18() {
			int n=5;
			for(int i=1;i<=n;i++) {
				
				for(int j=1;j<=n-i;j++) {	
					System.out.print("  ");
				}
				for(int j=1;j<=i*2-1;j++) {	
					if(i%2==0) {
						System.out.print("0"+" " );
					}
					else {
						System.out.print("1"+" " );
					}
					
				}
				System.out.println();
				
			}
		}
		
//        1 
//      0 1 0 
//    1 0 1 0 1 
//  0 1 0 1 0 1 0 
//1 0 1 0 1 0 1 0 1 
		
		public static void pattern19() {
			int n=5;
			int num=1;
			for(int i=1;i<=n;i++) {
				
				for(int j=1;j<=n-i;j++) {	
					System.out.print("  ");
				}
				for(int j=1;j<=i*2-1;j++) {	
					System.out.print(num-- + " " );
					if(num<0) {
						num=1;
					}
				}
				System.out.println();
				
			
				
			}
		}
		
//        1 
//      1 0 1 
//    1 0 1 0 1 
//  1 0 1 0 1 0 1 
//1 0 1 0 1 0 1 0 1 
		
		public static void pattern20() {
			int n=5;
			
			for(int i=1;i<=n;i++) {
				int num=1;
				for(int j=1;j<=n-i;j++) {	
					System.out.print("  ");
				}
				for(int j=1;j<=i*2-1;j++) {	
					System.out.print(num-- +" " );
					if(num<0) {
						num=1;
					}
				}
				System.out.println();
				
			}
		}
		
//		* * * * * * * * * 
//		  * * * * * * * 
//		    * * * * * 
//		      * * * 
//		        * 
		
		public static void pattern21() {
			int n=5;
			for(int i=n;i>=1;i--) {
				
				for(int j=1;j<=n-i;j++) {	
					System.out.print("  ");
				}
				for(int j=1;j<=i*2-1;j++) {	
					System.out.print("* " );
				}
				System.out.println();
				
			}
		}
		
//        1 
//      1 2 3 
//    1 2 3 4 5 
//  1 2 3 4 5 6 7 
//1 2 3 4 5 6 7 8 9 
		
		public static void pattern22() {
			int n=5;
			
			for(int i=1;i<=n;i++) {
				int num=1;
				for(int j=1;j<=n-i;j++) {	
					System.out.print("  ");
				}
				for(int j=1;j<=i*2-1;j++) {	
					System.out.print(j+" " );
					
				}
				System.out.println();
				
			}
		}
		
//         *
//       * *
//     * * *
//   * * * *
// * * * * *

		
		public static void pattern23() {
			int n=5;
			for (int i=1; i<=n; i++) {
				for (int j=n; j>=1; j--) {
					
					if (j > i) {
						System.out.print("  ");
					} else {
						System.out.print(" *");
					}

				}
				System.out.println();
			}
			
		}
		
//        1
//      2 1
//    3 2 1
//  4 3 2 1
//5 4 3 2 1
		
		public static void pattern24() {
			int n=5;
			for (int i=1; i<=n; i++) {
				for (int j=n; j>=1; j--) {
					
					if (j > i) {
						System.out.print("  ");
					} else {
						System.out.print(" "+j);
					}

				}
				System.out.println();
			}
			
		}
		
//		1 
//		2 1 
//		3 2 1 
//		4 3 2 1 
//		5 4 3 2 1 
		
		public static void pattern25() {
			int n=5;
			int num=1;
			for(int i=1;i<=n;i++) {
				
				for(int j=i;j>=1;j--) {
					
					System.out.print(j + " ");
				}
				System.out.println();
				
			}
		}
//		1
//		2 6
//		3 7 10
//		4 8 11 13
//		5 9 12 14 15
	
		public static void pattern26() {
			int n=5;
			   for (int i = 1; i <= n; i++)  
		        { 
		            int k = i;
		            for (int j = 1; j <= i; j++)  
		            { 
		                System.out.print(k + " ");   
		                k = k + n - j; 
		            } 
		            System.out.println(); 
		        } 
		}
	
//        1 
//      1 2 1 
//    1 2 3 2 1 
//  1 2 3 4 3 2 1 
//1 2 3 4 5 4 3 2 1 
		public static void pattern27() {
			int n=5;
			
			for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n - i; j++) {
	                System.out.print("  ");
	            }
	            for (int k = 0; k <= i; k++) {
	                System.out.print(k + 1+" ");
	            }
	            for (int l = i - 1; l >= 0; l--) {
	                System.out.print(l + 1+" ");
	            }
	            System.out.println();
	        }
		}
		
//      1 
//    2 1 2 
//  3 2 1 2 3 
//4 3 2 1 2 3 4 
//5 4 3 2 1 2 3 4 5 
		
		public static void pattern28() {
			int n=5;
			
			 for (int i = 1; i <= n; i++) {
		            for (int j = n; j >= 1; j--) {
		                if (j <= i) {
		                    System.out.print(j +" ");
		                } else {
		                    System.out.print("  ");
		                }
		            }
		            for (int k = 2; k <= i; k++) {
		                System.out.print(k + " ");
		            }
		            System.out.println();
		        }
		}
		
		
		public static void main(String[] args) {
//			pattern1();
//			pattern2();
//			pattern3();
//			pattern4();
//			pattern5();
//			pattern6();
//			pattern7();
//			pattern8();
//			pattern9();
//			pattern10();
//			pattern11();
//			pattern12();
//			pattern13();
//			pattern14();
//			pattern15();
//			pattern16();
//			pattern17();
//			pattern18();
//			pattern19();
//			pattern20();
//			pattern21();
//			pattern22();
//			pattern23();
//			pattern24();
//			pattern25();
//			pattern26();
			pattern27();
//			pattern28();
		}
}
