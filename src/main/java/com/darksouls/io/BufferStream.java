package com.darksouls.io;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
/**
 * �ַ����������ļ��������
 * @author ������
 *
 */
public class BufferStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("test.txt");
		try(FileReader r = new FileReader(file)) {
			BufferedReader br = new BufferedReader(r);
			String str = br.readLine();
			while(str != null) {
				 str = br.readLine();
				 System.out.println(str);
			}
			br.close();
			r.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
