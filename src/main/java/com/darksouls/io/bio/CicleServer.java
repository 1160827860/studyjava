package com.darksouls.io.bio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class CicleServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			ServerSocket server = new ServerSocket(8888);
			Socket client = server.accept();
			DataInputStream di = new DataInputStream(client.getInputStream());
			DataOutputStream dio = new DataOutputStream(client.getOutputStream());
			while(true) {
				double radius = di.readDouble();
				double areo = radius*Math.PI*radius;
				dio.writeDouble(areo);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
