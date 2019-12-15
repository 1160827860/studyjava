package com.darksouls.io;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * �Ӷ������ļ��ж�ȡ�ַ�
 * @author ������
 *
 */
public class DateInputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		person1 t = new person1("a");
		t.age = 18;
		File file = new File("test.txt");
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
			dos.writeUTF(t.name);
			dos.writeChar('\t');
			dos.writeInt(t.age);
			dos.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
class person1{
	String name;
	int age;
	public person1(String name) {
		this.name = name;
	}
}