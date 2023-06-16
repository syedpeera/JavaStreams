package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Product{
	private int id;
	private String name;
	private int price;

	public Product(int id, String name, int price) {
		this.id=id;
		this.name=name;
		this.price=price;
	}
	public int getPrice() {
		return price;
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
}

class Employee{
	private int id;
	private String name;
	private int salary;

	public Employee(int id, String name, int salary) {
		this.id=id;
		this.name=name;
		this.salary=salary;
	}
	public int getSalary() {
		return salary;
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
}

class Student{
	private String name;
	private int score;
	private int age;

	public Student(String name, int score, int age) {
		this.name = name;
		this.score = score;
		this.age = age;
	}
	public int getScore() {
		return score;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + ", age=" + age + "]";
	}
}

public class JavaStreams {

	public static void main(String[] args) {  
		/* filter method */
		List<Integer>	numbersList = Arrays.asList(10,15,17,20,23,25,28,30,31,43);
		List<Integer> evenList = numbersList.stream().filter(n->n%2==0).collect(Collectors.toList());
		numbersList.stream().filter(n->n%2!=0).forEach(n->System.out.println(n));
		System.out.println(evenList);
		numbersList.stream().filter(n->n%2!=0).forEach(System.out::println);
		
		List<String> names = Arrays.asList("Melisandre", "Sansa", "Jon", "Daenerys", "Joffery");
		List<String> longNames = names.stream().filter(str->str.length()>6 && str.length()<8).collect(Collectors.toList());
		System.out.println(longNames);
		names.stream().filter(str->str.length()>6 && str.length()<8).forEach(System.out::println);
		
		List<String> words = Arrays.asList("cup", null, "forest", "sky", "book", null, "theatre");
		List<String> validWords = words.stream().filter(str->str!=null).collect(Collectors.toList());
		System.out.println(validWords);
		words.stream().filter(str->str!=null).forEach(str->  System.out.println(str));
		
		List<Product> productList = new ArrayList<>();
		productList.add(new Product(1, "HP Laptop", 25000));
		productList.add(new Product(2, "Dell Laptop", 30000));
		productList.add(new Product(3, "Lenovo Laptop", 28000));
		productList.add(new Product(4, "Sony Laptop", 23000));
		productList.add(new Product(5, "Apple Laptop", 90000));
		
		productList.stream().filter(p->p.getPrice()>25000).forEach(p->System.out.println(p.getPrice()));
		
		/* map method */
		List<String> vehicles = Arrays.asList("bus", "car", "bike", "flight", "train");
		List<String> uppercaseVehicles = vehicles.stream().map(name->name.toUpperCase()).collect(Collectors.toList());
		System.out.println(uppercaseVehicles);
		
		vehicles.stream().map(name->name.toUpperCase()).forEach(name->System.out.println(name));
		
		vehicles.stream().map(name->name.length()).forEach(System.out::println);
		
		List<Integer> numbers = Arrays.asList(2,3,4,5,9,7);
		numbers.stream().map(n->n*3).forEach(n->System.out.println(n));
		
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(101, "Alex", 10000));
		employees.add(new Employee(102, "Brain", 20000));
		employees.add(new Employee(103, "Charles", 30000));
		employees.add(new Employee(104, "David", 40000));
		employees.add(new Employee(105, "Edward", 50000));
		
		List<Integer> employeeSalary = employees.stream().filter(e->e.getSalary()>20000).map(e->e.getSalary()).collect(Collectors.toList());
		System.out.println(employeeSalary);
		
		/* flatmap method */
		List<Integer> list1 = Arrays.asList(1,2);
		List<Integer> list2 = Arrays.asList(3,4);
		List<Integer> list3 = Arrays.asList(5,6);
		
		List<List<Integer>> finalList = Arrays.asList(list1, list2, list3);
		
		List<Integer> finalResult = finalList.stream().flatMap(x->x.stream()).collect(Collectors.toList());  
		System.out.println(finalResult);
		
		List<Integer> finalAnswer = finalList.stream().flatMap(x->x.stream().map(n->n+10)).collect(Collectors.toList());  
		System.out.println(finalAnswer);
		
		List<String> teamA = Arrays.asList("Scott", "David", "John");
		List<String> teamB = Arrays.asList("Mary", "Luna", "Tom");
		List<String> teamC = Arrays.asList("Ken", "Jony", "Kitty");
		
		List<List<String>> players = new ArrayList<>();
		players.add(teamA);
		players.add(teamB);
		players.add(teamC);
		
		players.stream().flatMap(x->x.stream().map(str->str.toUpperCase())).forEach(x->System.out.println(x));
		
		/* distinct and limit method */
		List<String> vehicleList = Arrays.asList("car", "car", "bike", "car", "bike", "train", "bus");
		
		List<String> uniqueVehicleList = vehicleList.stream().distinct().collect(Collectors.toList());
		System.out.println(uniqueVehicleList);
		
		vehicleList.stream().distinct().forEach(x->System.out.println(x));
		long count = vehicleList.stream().distinct().count();
		System.out.println(count);
		
		vehicleList.stream().distinct().limit(3).forEach(System.out::println);
		vehicleList.stream().limit(3).forEach(System.out::println);
		
		/* count method */
		List<Integer> values = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		long evenCount = values.stream().filter(n->n%2==0).count();
		System.out.println(evenCount);
		
		/* min and max methods */
		List<Integer> input = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		Optional<Integer> minValue = input.stream().min((a, b)-> {return a.compareTo(b);});
		System.out.println(minValue.get());
		
		Optional<Integer> maxValue = input.stream().max((a, b)-> {return a.compareTo(b);});
		System.out.println(maxValue.get());
		
		
		/* reduce method */
		List<String> stringList = Arrays.asList("A", "B", "C", "1", "2", "3");
		Optional<String> stringListResult = stringList.stream().reduce((a, b)-> {return a+b;});
		System.out.println(stringListResult.get());
		
		/* Primitive Int Array and Not Collections */
		Object arr[] = input.stream().toArray();
		for(int i=0;i<arr.length;i++) {  
			System.out.println(arr[i]);
		}
		
		/* sorting */
		List<Integer> nums = Arrays.asList(7,8,3,2,5,6,1,4,10,9);
		List<Integer> ascSortedValues = nums.stream().sorted().collect(Collectors.toList());
		System.out.println(ascSortedValues);
		List<Integer> descSortedValues = nums.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(descSortedValues);
		
		List<String> stringInput = Arrays.asList("John", "Mary", "Kim", "David", "Smith");
		List<String> ascSortedString = stringInput.stream().sorted().collect(Collectors.toList());
		System.out.println(ascSortedString);
		List<String> descSortedString = stringInput.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(descSortedString);
		
		/* anyMatch, allMatch and noneMatch */
		List<String> fruits = new ArrayList<>();
		fruits.add("One Apple Only");
		fruits.add("One Mango Only");
		fruits.add("Two Apples Only");
		fruits.add("One Guava Only");
		fruits.add("Two Grapes Only");
		
		boolean result = fruits.stream().anyMatch((str)->{return str.startsWith("One");});
		System.out.println(result);
		
		result = fruits.stream().allMatch((str)->{return str.endsWith("Only");});
		System.out.println(result);

		//None of the values startWith 1 so we get true otherwise we get false 
		result = fruits.stream().noneMatch((str)->{return str.startsWith("1");});
		System.out.println(result);
		
		/* findAny(mostly used while using parallel streams) and findFirst */
		List<String> stringValues = Arrays.asList("One", "Two", "Three", "Four");
		Optional<String> answer1 =  stringValues.stream().findAny();
		System.out.println(answer1.get());
		Optional<String> answer2 = stringValues.stream().findFirst();
		System.out.println(answer2.get());
		
		/* stream concatenation */
		List<String> animalsList = Arrays.asList("Dog", "Cat", "Elephant");
		List<String> birdsList = Arrays.asList("Peacock", "Parrot", "Crow");
		
		Stream<String> stream1 = animalsList.stream();
		Stream<String> stream2 = birdsList.stream();
		
		List<String> livingBeings = Stream.concat(stream1, stream2).collect(Collectors.toList());
		System.out.println(livingBeings);
		
		/* Parallel streams */
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student("David", 82, 24));
		studentList.add(new Student("Bob", 90, 25));
		studentList.add(new Student("John", 65, 24));
		studentList.add(new Student("Canedy", 55, 25));
		studentList.add(new Student("Eric", 88, 26));
		studentList.add(new Student("Smith", 88, 26));
		studentList.add(new Student("Scott", 55, 26));
		studentList.add(new Student("Alex", 57, 27));
		
		/* using stream() - sequential */
		studentList.stream().filter(s->s.getScore()>=80).limit(3).forEach(x->System.out.println(x.getName()+" "+x.getScore()));
		
		/* using parallelStream() */
		studentList.parallelStream().filter(s->s.getScore()>=80).limit(3).forEach(x->System.out.println(x.getName()+" "+x.getScore()));
		
		/* convert stream() to parallelStream() using parallel() */
		studentList.stream().parallel().filter(s->s.getScore()>=80).limit(3).forEach(x->System.out.println(x.getName()+" "+x.getScore()));
		
		/*
		 * 1. groupingBy(function)
		 * 2. groupingBy(function, collector)
		 * 3. groupingBy(function, supplier, collector)
		 * */
		
		 //1. groupingBy(function)
		 Map<Integer, List<Student>> groupByAgeList = studentList.stream().collect(Collectors.groupingBy(Student::getAge));
		 System.out.println(groupByAgeList);
		 groupByAgeList = studentList.stream().collect(Collectors.groupingBy(s->s.getAge()));
		 System.out.println(groupByAgeList);
		 
		 //2. groupingBy(function, collector)
		 Map<Integer, Set<Student>> groupByAgeSet = studentList.stream().collect(Collectors.groupingBy(Student::getAge, Collectors.toSet()));
		 System.out.println(groupByAgeSet);
		 groupByAgeSet = studentList.stream().collect(Collectors.groupingBy(s->s.getAge(), Collectors.toSet()));
		 System.out.println(groupByAgeSet);
		 
		 Map<Integer, List<String>> groupByAgeNameList = studentList.stream().collect(Collectors.groupingBy(Student::getAge, Collectors.mapping(Student::getName, Collectors.toList())));
		 System.out.println(groupByAgeNameList);
		 groupByAgeNameList = studentList.stream().collect(Collectors.groupingBy(s->s.getAge(), Collectors.mapping(s->s.getName(), Collectors.toList())));
		 System.out.println(groupByAgeNameList);
		 
		 Map<Integer, Set<Integer>> groupByAgeScoreSet = studentList.stream().collect(Collectors.groupingBy(Student::getAge, Collectors.mapping(Student::getScore, Collectors.toSet())));
		 System.out.println(groupByAgeScoreSet);
		 groupByAgeScoreSet = studentList.stream().collect(Collectors.groupingBy(s->s.getAge(), Collectors.mapping(s->s.getScore(), Collectors.toSet())));
		 System.out.println(groupByAgeScoreSet);
		 
		 //3. groupingBy(function, supplier, collector)
		 HashMap<Integer, List<String>> groupByAgeNamesList = studentList.stream().collect(Collectors.groupingBy(Student::getAge, HashMap::new, Collectors.mapping(Student::getName, Collectors.toList())));
		 System.out.println(groupByAgeNamesList);
		 studentList.stream().collect(Collectors.groupingBy(s->s.getAge(), ()->new HashMap<>(), Collectors.mapping(s->s.getName(), Collectors.toList())));
		 System.out.println(groupByAgeNamesList);
	}
}  
   