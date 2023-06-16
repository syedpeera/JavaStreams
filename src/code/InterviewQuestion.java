package code;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class InterviewQuestion {

	public static void main(String[] args) {
		//Print Sum of all Numbers
		List<Integer> list = Arrays.asList(1, 4, 5, 6, 22, 3, 90, 89, 2, 1, 3, 4, 55, 6, 26);
		Optional<Integer> sum = list.stream().reduce((a, b)-> {return a+b;});
		System.out.println(sum.get());
		int result = list.stream().mapToInt(Integer::intValue).sum();
		System.out.println(result);
		
		//Print Average of all Numbers
		double avg = list.stream().mapToInt(e->e).average().getAsDouble();
		System.out.println(avg);
		avg = list.stream().mapToInt(Integer::intValue).average().orElse(0);
		System.out.println(avg);
		
		//Square, Filter and Average of Numbers
		double finalAvg = list.stream().map(n->n*n).filter(n->n>100).mapToInt(e->e).average().getAsDouble();
		System.out.println(finalAvg);
		finalAvg = list.stream().map(n->n*n).filter(n->n>100).mapToInt(Integer::intValue).average().getAsDouble();
		System.out.println(finalAvg);
		
		//Print Even and Odd Numbers
		List<Integer> evenList = list.stream().filter(n->n%2==0).collect(Collectors.toList());
		System.out.println(evenList);
		List<Integer> oddList = list.stream().filter(n->n%2!=0).collect(Collectors.toList());
		System.out.println(oddList);
		
		//Print Numbers Starts with Prefix 2
		List<Integer> answer = list.stream().map(e->String.valueOf(e)).filter(s->s.startsWith("2")).map(e->Integer.valueOf(e)).collect(Collectors.toList());
		System.out.println(answer);
		answer = list.stream().map(String::valueOf).filter(s->s.startsWith("2")).map(Integer::valueOf).collect(Collectors.toList());
		System.out.println(answer);
		
		//***Print Duplicate Numbers using Streams
		//e is passed to list and see what all have count more than 1 and collect the values in a set
		Set<Integer> duplicateVal = list.stream().filter(e->Collections.frequency(list,e)>1).collect(Collectors.toSet());
		System.out.println(duplicateVal);
		Set<Integer> duplicateValues = new HashSet<>();
		duplicateVal = list.stream().filter(e->!duplicateValues.add(e)).collect(Collectors.toSet());
		System.out.println(duplicateVal);
		
		//Find max and min numbers
		int max = list.stream().mapToInt(Integer::intValue).max().orElse(0);
		System.out.println(max);
		max = list.stream().max(Comparator.comparing(Integer::intValue)).get();
		System.out.println(max);
		
		int min = list.stream().mapToInt(Integer::intValue).min().orElse(0);
		System.out.println(min);
		min = list.stream().min(Comparator.comparing(Integer::intValue)).get();
		System.out.println(min);
		
		//Sort Numbers ASC and DESC
		List<Integer> ascSorted = list.stream().sorted().collect(Collectors.toList());
		System.out.println(ascSorted);
		List<Integer> descSorted = list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		System.out.println(descSorted);
		
		//Get/Ignore first 5 numbers using Limit & Skip in streams
		List<Integer> listVal = list.stream().limit(3).collect(Collectors.toList());
		System.out.println(listVal);
		int limitSum = list.stream().limit(3).reduce((a, b)-> {return a+b;}).get();
		System.out.println(limitSum);
		
		listVal = list.stream().skip(3).collect(Collectors.toList());
		System.out.println(listVal);
		limitSum = list.stream().skip(3).reduce((a, b)-> {return a+b;}).get();
		System.out.println(limitSum);
		
		//Get Second Highest/Lowest Number from Stream
		int secondHighest = list.stream().sorted(Collections.reverseOrder()).distinct().skip(1).findFirst().get();
		System.out.println(secondHighest);
		int secondLowest = list.stream().sorted().distinct().skip(1).findFirst().get();
		System.out.println(secondLowest);
	}

}
