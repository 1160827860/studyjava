package com.darksouls.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 键盘打，在控制台输出
 * @author 李正阳
 *
 */
public class BufferedStreamDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 将字节流转换为字符流主要是因为BufferedReader创建的时候只能用字符流
		 * 但是System.in返回是字节流
		 */
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String str = br.readLine();
			
			
			while(str != null) {
				System.out.println(str);
				str = br.readLine();
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
