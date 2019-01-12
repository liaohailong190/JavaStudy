package org.liaohailong.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPService {

	public static void main(String[] args) {
		int port = 8080;
		try {
			DatagramSocket datagramSocket = new DatagramSocket(port);
			System.out.println("UDP ������������....");
			byte[] buffer = new byte[1024 * 1024 * 64];
			DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
			datagramSocket.receive(datagramPacket);
			String message = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
			System.out.println("�ӿͻ��˷����ģ�" + message);
			datagramSocket.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
