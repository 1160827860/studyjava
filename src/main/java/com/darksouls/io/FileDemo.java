package com.darksouls.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * 对文件的操作
 * @author 李正阳
 *
 */
public class FileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("test.txt");
		if(file.exists()) {
			System.out.println("存在");
		}else {
			System.out.println("不存在");
		}
		System.out.println(file.canRead()? "是":"不是");
		/**
		 * 字符流会写入缓冲流中
		 */
		try (FileWriter w = new FileWriter(file);){
			w.write("字符写入\r\n这里是换行\n这里是第三行");
			w.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
