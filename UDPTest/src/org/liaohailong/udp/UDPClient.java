package org.liaohailong.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
	public static void main(String[] args) {
		try {
			System.out.println("UDP ¿Í»§¶ËÆô¶¯....");
			DatagramSocket datagramSocket = new DatagramSocket();
			String message = "hello world, i am client";
			byte[] buffer = message.getBytes();
			DatagramPacket datagramPacket = new DatagramPacket(buffer, 0, buffer.length,
					InetAddress.getByName("192.168.1.23"), 8080);
			datagramSocket.send(datagramPacket);
			datagramSocket.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
