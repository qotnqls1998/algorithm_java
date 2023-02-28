package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1032_명령 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		String[] word=new String[N];
		char[] same=new char[50];
		
		for(int i=0;i<N;i++) {
			word[i]=br.readLine();
			if(i==0) {
				for(int j=0;j<word[i].length();j++) {
					same[j]=word[i].charAt(j);
				}	
			}
			else {
				for(int j=0;j<word[i].length();j++) {
					//if(i==0)continue;
					if(word[i].charAt(j)==same[j]) {
						same[j]=word[i].charAt(j);
					}
					else {
						same[j]='?';
					}	
				}		
			}
		}
		
		for(int i=0;i<50;i++) {
			if(same[i] != 0)
				System.out.print(same[i]);
		}
		
	}
}
