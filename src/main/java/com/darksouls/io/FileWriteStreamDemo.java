package com.darksouls.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * 字符流一定要刷新才能写入
 * @author 李正阳
 *
 */
public class FileWriteStreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("test.txt");
		try (FileWriter w = new FileWriter(file);){
			w.write("字符写入\r\n这里是换行");
			w.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
