package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortTest {
	public static void main(String[] args) {
		 List<Integer> iList = Stream.of(10, 8, 3, 5).collect(Collectors.toList());
//		Stream.iterate(1, item->item+1).limit(10).forEach(x->System.out.println(x));
//		Stream.generate(Math::random).limit(10).forEach(System.out::println);
//		 iList.parallelStream().sorted((x1,x2)->comparing(x1,x2)).forEach(System.out::println);;
		 
		 
//		 System.out.println("sum is:"+integerStream.stream().filter(num -> num != null).distinct().mapToInt(num -> num * 2).peek(System.out::println).skip(2).limit(4).sum());

//		 Stream<List<Integer>> inputStream = Stream.of(
//				 Arrays.asList(1),
//				 Arrays.asList(2, 3),
//				 Arrays.asList(4, 5, 6)
//				 );
//		 inputStream.
//		flatMap((childList) -> childList.stream()).forEach(System.out::println);;
		 
		 
		 Stream.of("one", "two", "three", "four")
		 .filter(e -> e.length() > 3)
		 .peek(e -> System.out.println("Filtered value: " + e))
		 .map(String::toUpperCase)
		 .peek(e -> System.out.println("Mapped value: " + e))
		 .collect(Collectors.toList());
	}
	
}
