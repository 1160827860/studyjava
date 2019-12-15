package com.darksouls.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("test.txt");
		try(ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(file))){
			person one = new person();
			one.name = "zzzz";
			one.age = 10;
			o.writeObject(one);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
class person implements Serializable{

	/**
	 *transient 不进行序列化 
	 */
	private static final long serialVersionUID = 5354267378451752054L;
	transient String name;
	static String conturny;
 	int age;
 	@Override
 	public String toString() {
 		return "person" + name + conturny + age;
 	}
	public static void main(String args[]) {
		File file = new File("test.txt");
		try(ObjectInputStream oi = new ObjectInputStream(new FileInputStream(file))){
			person one = (person)oi.readObject();
			System.out.println(one.name + one.age);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
