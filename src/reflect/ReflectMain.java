package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectMain {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		PrivateReflectField p = new PrivateReflectField();
		Class<? extends PrivateReflectField> clazz = p.getClass();
		Field nameObj = clazz.getDeclaredField("name");
		nameObj.setAccessible(true);
		nameObj.set(p, "y");
		System.out.println(p.toString());
		
		
		
		PrivateReflectMethod p1 = new PrivateReflectMethod();
		Class<? extends PrivateReflectMethod> clazz1 = p1.getClass();
		Method sayHello = clazz1.getDeclaredMethod("sayHello", new Class[]{String.class});
		sayHello.setAccessible(true);
		Object ll = sayHello.invoke(p1, new Object[]{"ะกร๗"});
		System.out.println(ll);
		
	}
}
