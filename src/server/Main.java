package server;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Main {

	public static void main(String[] args) {
		
		int port = 65535;
		
		
		DatagramSocket datagramSocket = null;
		HerniPole hp= new HerniPole(5);
		try {
			datagramSocket = new DatagramSocket(port);
			
			while(true) {
				
				byte[] buffer = new byte[3];
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
					
				datagramSocket.receive(packet);
				
				byte[] data = packet.getData();
				hp.hraj(data[0], data[1], data[2]);
				
				
				
				System.out.println(hp.toString());
				System.out.println();
				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(datagramSocket != null) {
				datagramSocket.close();
			}
			
		}

	}

}
