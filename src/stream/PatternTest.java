package stream;

import java.util.LinkedHashMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PatternTest {
	public static void main(String[] args) {
		String tt = "aa:11;bb:22;cc:33";
		Pattern.compile(";").splitAsStream(tt).collect(Collectors.toMap(x->x.split(":")[0],x->x.split(":")[1],(x,y)->{throw new IllegalStateException("");},LinkedHashMap::new)).forEach((x,y)->System.out.println(x+"--"+y));
	}
}
