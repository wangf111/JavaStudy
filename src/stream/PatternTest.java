package stream;

import java.util.regex.Pattern;

public class PatternTest {
	public static void main(String[] args) {
		String tt = "aa;bb;cc";
		Pattern.compile(";").splitAsStream(tt).forEach(System.out::println);
	}
}
