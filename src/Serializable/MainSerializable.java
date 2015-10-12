package Serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MainSerializable {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File("person.out");  
		 
        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));  
        Person person = new Person("John", 101, Gender.MALE);  
        oout.writeObject(person);  
        oout.close();  
 
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));  
        Object newPerson = oin.readObject(); // 没有强制转换到Person类型  
        oin.close();  
        System.out.println(newPerson);
        
        
        
        ArrayList<String> a = new ArrayList<String>();
        a.add("d");
        ArrayList<String> kk = (ArrayList<String>) a.clone();
        kk.add("lp");
        //a.set(1, "de");
        System.out.println(a.toString());
        System.out.println(kk);
	}
}
