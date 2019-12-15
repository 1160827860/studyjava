package com.darksouls.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * �ֽ���
 * @author ������
 *
 */
public class FileInputStreamDemo {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		File file = new File("test.txt");
		File outFile = new File("res.txt"); 
		byte[] content = null;
		try(FileInputStream in = new FileInputStream(file)){
			content = new byte[in.available()];
			in.read(content);
			FileOutputStream out = new FileOutputStream(outFile,false);
			out.write(content);
			out.flush();
			System.out.println("��ȡ�ɹ���");
			out.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("��ȡʧ��");
			e.printStackTrace();
		}
		System.out.println(new String(content));
		
	}

}
