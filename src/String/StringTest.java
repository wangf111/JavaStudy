package String;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class StringTest {
	public static void main(String[] args) {
		Map<String,String>  kk = new LinkedHashMap<>();
		kk.put("1", "10");
		kk.put("12", "112");
		kk.put("2", "20");
		
		
		 kk.entrySet().stream().sorted(( x1,  x2)->Integer.compare(Integer.valueOf(x2.getValue()),Integer.valueOf(x1.getValue()))).collect(Collectors.toMap((Entry::getKey), (Entry::getValue),(u,v) -> { throw new IllegalStateException(String.format("Duplicate key %s", u)); },LinkedHashMap::new))
.forEach((x,y)->System.out.println(x+"=="+y));
//		ll.forEach((x,y)->System.out.println(x+"=="+y));
	}
}
