package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTester {

	// 方法实现对Customer对象的拷贝操作
	public Object copy(Object object) throws Exception {
		/*Class<?> classType = object.getClass();
		
		 * Constructor cons = classType.getConstructor(new Class[]{});
		 * 
		 * Object obj = cons.newInstance(new Object[]{});
		 * System.out.println(obj); System.out.println("-----------");
		 

		// 以上的两行代码等价于下面一行
		// Object obj2 = classType.newInstance();
		Constructor cons2 = classType.getConstructor(new Class[] {
				String.class, int.class });
		Object obj2 = cons2.newInstance(new Object[] { "hello", 3 });
//		System.out.println(obj2);

		return obj2;*/
		/*Class<? extends Object> clazz = object.getClass();
		Constructor<? extends Object> cons = clazz.getConstructor(new Class[]{Long.class,String.class,int.class});
		Object obj = cons.newInstance(new Object[]{2L,"dd",4});
		Field kk = clazz.getField("name");
		Field[] allFields = clazz.getDeclaredFields();
		for(int i=0;i<allFields.length;i++){
			System.out.println(allFields[i].getName());;
		}
		
		
		System.out.println(kk.getType());
		return obj;*/
		
		Class<?> clazz = object.getClass();
		Constructor<?> constructor = clazz.getConstructor(new Class[]{});
		Object copyObj = constructor.newInstance(new Object[]{});
		Field[] filedArray = clazz.getDeclaredFields();
		for(int i=0;i<filedArray.length;i++){
			Field fie = filedArray[i];
			String filedName = upperFirstWord(fie.getName());
			String getMethodName = "get"+filedName;
			String setMethodName = "set"+filedName;
			Method getMethod = clazz.getMethod(getMethodName, new Class[]{});
			Method setMethod = clazz.getMethod(setMethodName, new Class[]{fie.getType()});
			Object value = getMethod.invoke(object, new Object[]{});
			setMethod.invoke(copyObj, new Object[]{value});
		}
		return copyObj;
		
	}
	
	private String upperFirstWord(String name){
        /*char[] cs=name.toCharArray();
        cs[0]-=32;
        return String.valueOf(cs);*/
		
		char[] cs = name.toCharArray();
		cs[0] -=32;
		return String.valueOf(cs);
		
	}

	public static void main(String[] args) throws Exception {
		ReflectTester test = new ReflectTester();
		Customer x = (Customer) test.copy(new Customer(3L,"dd",4));
		System.out.println(x.toString());
	}

}

class Customer {
	private Long id;

	private int age;

	private String name;

	public Customer() {

	}
	
	public Customer(Long id,String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", age=" + age + ", name=" + name + "]";
	}

}
