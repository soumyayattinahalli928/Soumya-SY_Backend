package com.patterns;
import java.util.Scanner;

//    * 
//  * * * 
//* * * * * 
//  * * * 
//    * 

public class Pattern37 {
	public static void main(String[] args)
	{
	   Scanner sc=new Scanner(System.in);
	System.out.println("enetr the size");
	int n=sc.nextInt();
	int star=1;
	int space=n-1;

	if(n%2==0)
	n++;

	for(int i=1;i<=n;i++)
	{
	for(int j=1;j<=space;j++)
	{
	System.out.print(" "+" ");
	}
	for(int k=1;k<=star;k++)
	{
	System.out.print("*" +" ");
	}
	System.out.println();
	if(i<n/2+1)
	{
	space--;
	star=star+2;
	}
	else
	{
	space++;
	star=star-2;
	}
	}
	}
}
