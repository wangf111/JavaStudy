package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrivateReflectField {

	private String name = "x";
	@Override
	public String toString() {
		return "PrivateReflectField [name=" + name + "]";
	}
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		PrivateReflectField p = new PrivateReflectField();
		Class<? extends PrivateReflectField> clazz = p.getClass();
		Field nameObj = clazz.getDeclaredField("name");
//		nameObj.setAccessible(true);
		nameObj.set(p, "y");
		System.out.println(p.toString());
	}
}
