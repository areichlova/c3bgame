package client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		
		int port = 65535;
		String ip = "10.2.240.124";
		
		DatagramSocket datagramSocket = null;
		try {
			
			byte [] data = {1,2,2};
			
			InetAddress ipAddress = InetAddress.getByName(ip);
	
			DatagramPacket packet = new DatagramPacket(data, data.length, ipAddress, port);
			
			datagramSocket = new DatagramSocket();
			datagramSocket.send(packet);
			datagramSocket.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}
}
