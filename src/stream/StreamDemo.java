package stream;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Stream;
 
/**
 *
 * @author Kangjun Ways of Creating a Stream in Java 8
 */
public class StreamDemo {
 
    public static void main(String[] args) {
 
//        arraysStream();
// 
//        collectionStream();
// 
//        generate();
// 
//        iterateStream();
         
        //populaStream();
    	/*Map<String,Map<String,String>> kk = new HashMap<String,Map<String,String>>();
    	Map<String,String> kk1 = new HashMap<String, String>();
    	kk1.put("ddd1", "lo");
    	kk1.put("ddd2", "lo1");
    	kk.put("speed", kk1);
    	Map<String,String> kk2 = new HashMap<String, String>();
    	kk2.put("ddd3", "lo0");
    	kk2.put("ddd4", "lo12");
    	kk.put("direction", kk2);
    	StringBuffer result = new StringBuffer();
    	kk.forEach((x1,y1)->{
    		StringBuffer sb = new StringBuffer();
    		sb.append(x1+"=");
    		y1.forEach((x,y)->{
        		sb.append(x+":"+y+";");
        	});
        	result.append(sb.subSequence(0, sb.length()-1)+" ");
    	});
    	
    	System.out.println(result.subSequence(0, result.length()-1));*/
    	
    	Function<Integer,Function<Integer,Integer>> makeAdder = x->y->x+y;
    	Function<Integer, Integer> kk = makeAdder.apply(2);
    	Integer a = kk.apply(10);
    	System.out.println(a);
    	
    	
    }
 
    //From Arrays
    public static void arraysStream() {
        String[] arr = {"program", "creek", "program", "creek", "java", "web",
            "program"};
        Stream<String> stream = Stream.of(arr);
        System.out.println(Arrays.toString(arr));
 
    }
 
    //From Collections
    public static void collectionStream() {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("python");
        list.add("c++");
        list.add("c");
        list.add("lisp");
 
        Stream<String> stream = list.stream().filter(p -> p.length() > 3);
        String[] arr = stream.toArray(String[]::new);
        System.out.println(Arrays.toString(arr));
    }
 
    //Use Stream.generate()
    public static void generate() {
        Stream<String> stream = Stream.generate(() -> "test").limit(10);
        String[] strArr = stream.toArray(String[]::new);
        System.out.println(Arrays.toString(strArr));
    }
 
    //Use Stream.iterate()
    public static void iterateStream() {
        Stream<BigInteger> bigIntStream = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.TEN)).limit(10);
        BigInteger[] bigIntArr = bigIntStream.toArray(BigInteger[]::new);
        System.out.println(Arrays.toString(bigIntArr));
    }
 
    // From Popular APIs
    public static void populaStream() {
        String sentence = "Program creek is a Java site.";
        Stream<String> wordStream = Pattern.compile("\\W").splitAsStream(sentence);
        String[] wordArr = wordStream.toArray(String[]::new);
        System.out.println(Arrays.toString(wordArr));
    }
}
