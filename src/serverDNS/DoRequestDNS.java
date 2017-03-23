package serverDNS;

public class DoRequestDNS {

	public static void main(String[] args){
		DoRequestDNS d = new DoRequestDNS();
		byte[] b = d.doRequest("www.lifl.fr");
		for (int i = 0 ; i < b.length ; i++){
			System.out.print(Integer.toHexString(b[i]));
		}
	}
	
	
	public static byte[] doRequest(String name){
		int i;
		byte[] b = new byte[512];
		
		b[0] = (byte) 0;
		b[1] = (byte) 1;
		b[2] = (byte) 1;
		b[3] = (byte) 1;
		b[4] = (byte) 0;
		b[5] = (byte) 1;
		b[6] = (byte) 0;
		b[7] = (byte) 0;
		b[8] = (byte) 0;
		b[9] = (byte) 0;
		b[10] = (byte) 0;
		b[11] = (byte) 0;
		
		byte[] temp = toLabel(name);
		for (i=0 ; i < temp.length ; i++){
			b[i+12] = (byte) temp[i];
		}
		i+=13;
		b[i] = (byte) 0;
		b[i+1] = (byte) 0;
		b[i+2] = (byte) 1;
		b[i+3] = (byte) 0;
		b[i+4] = (byte) 1;
		for (int j = i+5; j< 512 ; j++){
			b[j] = (byte) 0;
		}
		return b;
		
	}
	
	
	
	public static byte[] toLabel (String name){
		int cpt = 0;
		String[] partOfname = name.split("\\.");
		
		
		byte[]b = new byte[name.length()+2];
		
		for (String str : partOfname){
			int n = str.length();
			b[cpt] = (byte)n;
			for (int i = 0 ; i < n ; i++){
				cpt++;
				System.out.println("char : " + str.charAt(i) + " = "+ Integer.toHexString((byte)str.charAt(i)));
				b[cpt] = (byte) str.charAt(i);
			}
			cpt++;
		}
		b[name.length()+1] = 0;
		for (int i = 0 ; i < b.length ; i++){
			System.out.print(","+Integer.toHexString(b[i]));
		}
		System.out.println("");
		return b;
	}
	
	public void fromDNS (byte[] data){
		int taille = data.length;
		int nameLength = 2;
		
		byte[] tabName = new byte[nameLength];
		
		for(int i = 0; i < nameLength; i++){
			tabName[i] = data[i];
			System.out.println("name: "+ (int)tabName[i]);
		}
	}
	
}
