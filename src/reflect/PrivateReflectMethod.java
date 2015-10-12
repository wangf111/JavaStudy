package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrivateReflectMethod {

	private  String sayHello(String name){
		return "Hello "+name;
	}
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		PrivateReflectMethod p = new PrivateReflectMethod();
		Class<? extends PrivateReflectMethod> clazz = p.getClass();
		Method sayHello = clazz.getDeclaredMethod("sayHello", new Class[]{String.class});
//		sayHello.setAccessible(true);
		Object ll = sayHello.invoke(p, new Object[]{"ะกร๗"});
		System.out.println(ll);
	}

}
