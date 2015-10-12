package innerClass;

public class Outer {
	private String name;
	private int age;
	
	public Outer(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Outer [name=" + name + ", age=" + age + "]";
	}
	public static void main(String[] args) {
		Outer o = new Outer("dd",3);
		
		System.out.println(o.toString());
	}
	
}
