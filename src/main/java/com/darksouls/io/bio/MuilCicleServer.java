package com.darksouls.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MuilCicleServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket server = new ServerSocket(8888);
			System.out.println("服务器已经启动");
			while(true) {
				Socket client = server.accept();
				Thread thread = new Thread(new CicleRunnable(client));
				thread.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
