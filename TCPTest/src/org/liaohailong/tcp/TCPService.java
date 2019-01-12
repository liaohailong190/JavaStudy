package org.liaohailong.tcp;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPService {
	public static void main(String[] args) {
		System.out.println("TCP 服务端启动...");
		try {
			ServerSocket serverSocket = new ServerSocket(8080);
			Socket accept = serverSocket.accept();
			InputStream inputStream = accept.getInputStream();
			byte[] buffer = new byte[1024 * 1024];
			StringBuilder stringBuilder = new StringBuilder();
			int length = 0;
			while ((length = inputStream.read(buffer)) != -1) {
				String string = new String(buffer, 0, length);
				stringBuilder.append(string);
			}
			String message = stringBuilder.toString();
			System.out.println("来自客户端发来的信息：" + message);
			serverSocket.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
