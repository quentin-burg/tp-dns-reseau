package serverDNS;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DNSRequest {

	public static void main(String[] args) {
		
		
		byte[] message = DoRequestDNS.doRequest("www.lifl.fr");
		InetAddress dest = null;
		
		try {
			dest = InetAddress.getByName("193.49.225.90");
		}catch (Exception e){
			e.printStackTrace();
		}
		
		DatagramPacket p = new DatagramPacket (message, message.length, dest, 53);
	
		DatagramSocket s = null;
		try {
			s = new DatagramSocket();
		}catch (Exception e){
			e.printStackTrace();
		}
		
		
		try {
			s.send(p);
		}catch (Exception e){
			e.printStackTrace();
		}

		p = new DatagramPacket (new byte[512], 512);
		try{
			s.receive(p);
		}catch (Exception e){
			e.printStackTrace();
		}
	
		byte[] res = p.getData();
		System.out.println("Affichage de la réponse");
		for (int i = 0 ; i < p.getLength() ; i++){
			System.out.print(Integer.toHexString((res[i])&0xff)+",");
			if ((i+1)%16 == 0)
				System.out.println("");
		}
		System.out.println("");
	}

}
