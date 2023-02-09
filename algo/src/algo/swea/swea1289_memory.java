package algo.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class swea1289_memory {
	static int res=0;
	static String num ="";
	static String base ="";
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc= Integer.parseInt(br.readLine());
		
		for(int i=0; i<tc;i++) {
			res=0;
			base ="";
			num = br.readLine();
			for(int j=0;j<num.length();j++) {
				base+="0";
				//System.out.println("base:"+base);
			}
			while(true) {
				if(base.equals(num)) break;
				for(int j=0;j<num.length();j++) {
					if(base.charAt(j)!=num.charAt(j)) {
						int chk=j;
						break;
						}					
					}
				
				//num.replace("0", "1");
				res++;
			}
			
			//출력 부
			System.out.print("#"+(i+1)+" ");
			System.out.println(res);
		}
	}
}
