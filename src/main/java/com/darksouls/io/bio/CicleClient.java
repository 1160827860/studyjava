package com.darksouls.io.bio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class CicleClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket client = new Socket("localhost",8888);
			Scanner in = new Scanner(System.in);
			DataInputStream di = new DataInputStream(client.getInputStream());
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			while(true) {
				double radius = in.nextDouble();
				dos.writeDouble(radius);
				dos.flush();
				System.out.println(di.readDouble());
			}
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
