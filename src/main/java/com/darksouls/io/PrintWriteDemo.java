package com.darksouls.io;

import java.io.File;
import java.io.PrintWriter;

public class PrintWriteDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("test.txt");
		try(PrintWriter pw = new PrintWriter(file)){
			pw.print("aadaw");
			pw.println();
			pw.printf("%d,%s", 5,"tttt");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
