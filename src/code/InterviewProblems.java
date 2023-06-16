package code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Person{
	private	String name;
	private int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}

public class InterviewProblems {
	public static void main(String[] args) {
		//Find the sum of all elements in a list using Java 8 Streams
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		
		int finalSum = numbers.stream().mapToInt(Integer::intValue).sum();
		System.out.println(finalSum);
		
		Optional<Integer> sum = numbers.stream().reduce((a, b)-> {return a+b;});
		System.out.println(sum.get());
		
		//Filter a list of strings to get only the strings starting with a specific letter
		List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Dave", "Alex");
		names.stream().filter(str->str.startsWith("Al")).forEach(str->System.out.println(str));
		
		//Find the maximum value in a list of integers using Java 8 Streams
		List<Integer> nums = Arrays.asList(10, 5, 20, 15, 30);
		
		int max = nums.stream().mapToInt(Integer::intValue).max().orElse(0);
		System.out.println(max);
		
		Optional<Integer> maxVal = nums.stream().max((a, b)-> {return a.compareTo(b);});
		System.out.println(maxVal.get());
		
		//Given a list of objects, filter and collect only certain properties into a new list
		List<Person> persons = Arrays.asList(new Person("Alice", 25), new Person("Bob", 30), new Person("Charlie", 35));
		List<String> personNames = persons.stream().map(p->p.getName()).collect(Collectors.toList());
		System.out.println(personNames);
		List<String> finalPersonNames = persons.stream().map(Person::getName).collect(Collectors.toList());
		System.out.println(finalPersonNames);
		
		//Count the number of elements in a list that satisfy a specific condition using Java 8 Streams
		List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
		long evenCount = input.stream().filter(n->n%2==0).count();
		System.out.println(evenCount);
		
		//Group a list of objects by a specific attribute using Java 8 Streams
		List<Person> humans = Arrays.asList(new Person("Alice", 25), new Person("Bob", 30), new Person("Charlie", 35), new Person("Tom", 25), new Person("John", 30), new Person("Peter", 35), new Person("Victor", 43), new Person("Steve", 27), new Person("Harry", 27));
		Map<Integer, List<Person>> filterAge = humans.stream().collect(Collectors.groupingBy(h->h.getAge()));
		System.out.println(filterAge);
		filterAge = humans.stream().collect(Collectors.groupingBy(Person::getAge));
		System.out.println(filterAge);
		
		//Find the average of a list of numbers using Java 8 Streams
		List<Integer> inputNums = Arrays.asList(1, 2, 3, 4, 5);
		double avg = inputNums.stream().mapToDouble(Integer::intValue).average().orElse(0);
		System.out.println(avg);
		
		//Given a list of strings, convert them to uppercase using Java 8 Streams
		List<String> words = Arrays.asList("apple", "banana", "orange");
		List<String> uppercaseWords = words.stream().map(str->str.toUpperCase()).collect(Collectors.toList());
		System.out.println(uppercaseWords);
		uppercaseWords = words.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(uppercaseWords);
		
		//Sort a list of objects based on a specific property using Java 8 Streams
		List<Person> people = Arrays.asList(new Person("Alice", 25), new Person("Bob", 30), new Person("Charlie", 35));
		List<Person> sortAge = people.stream().sorted((a,b)-> {return a.getAge()-b.getAge();}).collect(Collectors.toList());
		System.out.println(sortAge.toString());
		sortAge = people.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
		System.out.println(sortAge.toString());
		
		//Given a list of integers, remove duplicates using Java 8 Streams
		List<Integer> values = Arrays.asList(1, 2, 3, 2, 4, 3, 5);
		values.stream().distinct().forEach(System.out::println);
		
		//Move null to the end
		List<String> wordsInput = Arrays.asList("Apple", null, "Cherry", null, null, "Orange", "PineApple", null, "Apricot");
		wordsInput.stream().sorted(Comparator.nullsLast(Comparator.naturalOrder())).forEach(System.out::println);
		
		//Custom Sort
		List<Person> members = Arrays.asList(new Person("Alice", 25), new Person("Bob", 30), new Person("Alice", 20));
		List<Person> membersList = members.stream().sorted((p1,p2)->{
			if(p1.getName().equals(p2.getName())) {
				return p1.getAge()-p2.getAge();
			}
			else {
				return p1.getName().compareTo(p2.getName());
			}
		}).collect(Collectors.toList());
		System.out.println(membersList);
		
		membersList =  members.stream().sorted(Comparator.comparing(Person::getName).thenComparing(Person::getAge)).collect(Collectors.toList());
		System.out.println(membersList);		
	}
}
