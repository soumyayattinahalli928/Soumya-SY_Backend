package com.java8programs;

import java.nio.file.DirectoryStream.Filter;
import java.security.Identity;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Programs {
	public static void main(String[] args) {
		
		List<Integer> asList = Arrays.asList(1,2,4,5,5,67,167);
		List<Integer> asList1 = Arrays.asList(3,2,4,5,68,167);
		
		//print even numbers
		List<Integer> collect = asList.stream().filter(e -> e%2==0).collect(Collectors.toList());
		System.out.println(collect);
		
		//print nor starts with 1
		asList.stream().map(e -> Integer.toString(e)).filter(e -> e.startsWith("1"))
			.forEach(System.out::println);

		//remove duplicates
		Set<Integer> set = new HashSet<>();
		asList.stream().filter(e -> !set.add(e)).forEach(System.out::println);
		
		//print first element
		Integer orElse = asList.stream().findFirst().orElse(0);
		System.out.println(orElse);
		
		//count nor of elements
		Long count = asList.stream().count();
		System.out.println(count);
		
		//max element
		Integer max = asList.stream().max((o1,o2) -> o1.compareTo(o2)).get();
		System.out.println(max);
		
		//1st non repeated char
		String input = "Java articles are awesome";
		Character character = input.chars().mapToObj(c -> (char)c).filter(e -> input.indexOf(e)==input.lastIndexOf(e))
				.findFirst().get();
		System.out.println(character);
		
		//1st repeated char
		Character character1 = input.chars().mapToObj(c -> (char)c).filter(e -> input .indexOf(e)!=input.lastIndexOf(e))
					.findFirst().get();
		System.out.println(character1);
		
		//sort elements
		asList.stream().sorted().forEach(System.out::println);
		
		//to reverse
		asList.stream().sorted((o1,o2)->o2.compareTo(o1)).forEach(System.out::println);
		
		//cube of nor
		asList.stream().map(e -> e*e*e).filter(e -> e>50).forEach(System.out::println);
		
		//any value repeated twice
		 int size = asList.stream().distinct().collect(Collectors.toList()).size();
		System.out.println(size!=asList.size());
		 
		//nor of duplicates with occurrence
		List<String> names = Arrays.asList("AA", "BB" ,"AA", "CC");
		
		names.stream().filter(e -> Collections.frequency(names, e)>1)
			.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	
	
		//Separate odd and even
		Map<Boolean, List<Integer>> evenOdd = asList.stream().collect(Collectors.partitioningBy(e -> e%2==0));
		System.out.println(evenOdd);
		
		//print multiple of 5
		asList.stream().filter(e -> e%5==0).forEach(System.out::println);
		
		//merge 2 arrays into single sorted array
		int[] arr1 = {2,1,5,3};
		int[] arr2 = {4,2,7,6};
		
		int[] arr3 = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).sorted().toArray();
		System.out.println(Arrays.toString(arr3));
		
		//merge 2 arrays into single sorted array without duplicates
		int[] arr4 = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).sorted().distinct().toArray();
		System.out.println(Arrays.toString(arr4));
		
		//3 max and min 
		asList.stream().sorted().limit(3).forEach(System.out::println);
		
		asList.stream().sorted((o1,o2)->o2.compareTo(o1)).limit(3).forEach(System.out::println);
		
		//Sort String length 
		List<String> str = Arrays.asList("Seeta", "Ram", "Harish");
		str.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
	
		//sum and avg of all ele of an array
//		int[] arr1 = {2,1,5,3};
		
		System.out.println(Arrays.stream(arr1).sum());
		
		System.out.println(Arrays.stream(arr1).average());
		
		//palindrome
		String str1 = "malayalam";
		System.out.println(IntStream.range(0, str1.length()/2).noneMatch(i -> str1.charAt(i)!=str1.charAt(str1.length()-i-1)));
		
		//last element of an array
//		int[] arr1 = {2,1,5,3};
		Arrays.stream(arr1).skip(arr1.length-1).forEach(System.out::println);
		
		//remove duplicates
		asList.stream().distinct().forEach(System.out::println);
		
		//anagram
		String s1 = "silent";
		String s2 = "listen";
		
		s1 = Stream.of(s1.split("")).sorted().collect(Collectors.joining());
		s2 = Stream.of(s2.split("")).sorted().collect(Collectors.joining());
		
		System.out.println(s1.equals(s2));
		
		//2nd largest number in an int array

		System.out.println(asList.stream().sorted((o1,o2)-> o2.compareTo(o1)).skip(1).findFirst().get());
//	
//		//sum of digits
		int num = 123;
		int num1 = Stream.of(String.valueOf(num).split(""))
				.collect(Collectors.summingInt(Integer::parseInt));
		
		System.out.println(num1);
		
		//common elements between 2 array
		asList.stream().filter(asList1::contains).forEach(System.out::println);
		
		//sum of 1st 10 natural numbers
		System.out.println(IntStream.range(1, 11).sum());
		
		//string starts with number
		List<String> str2 = Arrays.asList("1hii","hello","3bye");
		str2.stream().filter(e -> Character.isDigit(e.charAt(0))).forEach(System.out::println);
		
		
		//duplicate elem from an array
//		List<Integer> asList = Arrays.asList(1,2,4,5,5,67,167);
		Set<Integer> set1 = new HashSet<>();
		Set s =asList.stream().filter(e -> !set1.add(e)).collect(Collectors.toSet());
		System.out.println(s);
		
		//fibonacci series
		Stream.iterate(new int[] {0,1}, f -> new int[] {f[1], f[0]+f[1]}).limit(10)
			.map(f -> f[0]).forEach(i -> System.out.print(i + " "));
		
		//add suffix and prefix
//		List<String> names = Arrays.asList("AA", "BB" ,"AA", "CC");
		
		System.out.println(names.stream().collect(Collectors.joining("4", "Mrs.", "e")));
		
	}	
	
}
