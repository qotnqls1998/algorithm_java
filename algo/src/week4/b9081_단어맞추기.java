package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b9081_단어맞추기 {

	static char[] output;
	static List<String> arr;
	static StringBuilder sb ;
	static int size;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int i=0;i<tc;i++) {
			sb = new StringBuilder();
			arr = new ArrayList<>();
			String s = br.readLine();
			
			size =s.length();
			output = new char[size];
			
			for(int j=0;j<s.length();j++) {
				output[j]=s.charAt(j);
			}
			
			
			while(next_perm(output)) {
				sb = new StringBuilder();
				
				for(int k=0;k<size;k++)
					sb.append(output[k]);
				
				arr.add(sb.toString());
			}
			
			Collections.sort(arr);
			
			System.out.println(arr.get( (arr.indexOf(s)+1) ));
			}
	}
	
	static boolean next_perm(char[] output) {
		//System.out.println("실행");
		
		int i = output.length-1;
		
		while (i > 0 && output[i - 1] >= output[i]) {
			i--;
		}
		
		if(i==0) return false;
		
		
		int j=size-1;
		while(output[i-1] > output[j]) j--;
		
		swap(output,i-1,j);
		
		int k = size - 1;
		while(i < k) {
				swap(output, i++, k--);	
				
		}
		return true;
	}
	
	static void swap(char numbers[], int i, int j) {
		char temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
