package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b11723_집합 {
	static int num;
	static String s;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		int cnt =1; 
		int m = Integer.parseInt(br.readLine());
		int bit = 0;
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			s = st.nextToken();
			
			if(s.equals("all")||s.equals("empty")) {
				continue;
			}else {
				num =  Integer.parseInt(st.nextToken());
				
				//long tmp =  (long) Math.pow(2, num-1);
				
				switch (s) {
					case "add": 
						
						break;
					case "remove": break;
					case "check": 
						System.out.println(num +" : "+tmp);
						break;
					case "toggle": break;
					
				}
			}
		}
		
		
	}
}
