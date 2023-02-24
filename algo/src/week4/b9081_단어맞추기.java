package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b9081_단어맞추기 {

	static char[] output;
	static StringBuilder sb ;
	static int size;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int i=0;i<tc;i++) {
			sb = new StringBuilder();
			
			String s = br.readLine();
			
			size =s.length();
			output = new char[size];
			
			for(int j=0;j<s.length();j++) {
				output[j]=s.charAt(j);
			}
			
			next_perm(output);
	
		}
	}
	
	static void next_perm(char[] output) {
		//현재 단어에서 다음 순서의 단어
		
		//현재 글자
		int i = size-1;
		while (i > 0 && output[i - 1] >= output[i]) i--;
		
		if(i==0) {//다음순서가 없음을 의미 
			System.out.println(output);
			return;
		}
		
		int j=size-1;
		while(output[i-1] >= output[j]) j--;
		
		swap(output,i-1,j);
		
		int k = size - 1;
		while(i < k) {
				swap(output, i++, k--);		
		}
		
		System.out.println(output);
	}
	
	static void swap(char numbers[], int i, int j) {
		char temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
