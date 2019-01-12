package org.liaohailong.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket(InetAddress.getByName("192.168.1.23"), 8080);
			OutputStream outputStream = socket.getOutputStream();
			outputStream.write("hello world from client!".getBytes());
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
