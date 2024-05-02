package com.stringoperations;

public class Anagram {
		
	public static void sort(char[] c)
	{
			for(int i=0;i<c.length;i++)
			{
				for(int j=i+1;j<c.length;j++)
				{	
					if(c[i]>c[j])
					{
						char temp=c[i];
						c[i]=c[j];
						c[j]=temp;
					}
				}
			}
			
		}
	
	public static boolean equals(char[] c1,char[] c2)
	{
		boolean flag=true;
		for(int i=0;i<c1.length;i++)
		{
			if(c1[i]!=c2[i])
			{
				flag=false;  //if any one char is not matching no need to check other 
				break;
			}
			
		}
		return flag;
	}
	
	public static void main(String[] args) {
		String s1="silent";
		String s2="listen";
		
		if(s1.length()!=s2.length())
		{
			System.out.println("The given String is not a anagram");
		}
		else
		{
			char[] c1=s1.toCharArray();
			char[] c2=s2.toCharArray();
			
			sort(c1);
			sort(c2);
			
			if(equals(c1,c2))
			{
				System.out.println("given String is Anagram");
			}
			else
			{
				System.out.println("Not a anagram");
			}
		}
}
}
