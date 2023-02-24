package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b11723_집합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null; 
		
		int m = Integer.parseInt(br.readLine());
		long flag=0;
		long num=0;
		StringBuilder sb = new StringBuilder();
		String s="";
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			s = st.nextToken();
			
			if(s.equals("all")) {
				flag = 1048575;
			}
			else if(s.equals("empty")) {
				flag=0;
			}else if(s.equals("add")){
				num = Integer.parseInt(st.nextToken());	
				num=1<<(num-1);
				flag|=num;
			
			}else if(s.equals("remove")){
				num = Integer.parseInt(st.nextToken());	
				num=1<<(num-1);
				flag &= ~num;
			
			}else if(s.equals("check")){
				num = Integer.parseInt(st.nextToken());	
				num=1<<(num-1);
				if( (flag&num) == num ) {
					sb.append(1+"\n");
				}
				else {
					sb.append(0+"\n");
				}
		
			}else if(s.equals("toggle")){
				num = Integer.parseInt(st.nextToken());	
				num=1<<(num-1);
				if( (flag&num) == num ) {
					flag &= ~num;
				}
				else {
					flag|=num;
				}
			
			}
			
			
//				num = Integer.parseInt(st.nextToken());	
//				num=1<<(num-1);
				
				
				
				/*
				switch (s) {
					case "add": 
						flag|=num;
						break;
						
					case "remove": 
						if( (flag&num) == num ) {
							flag &= ~num;
						}
						break;
						
					case "check": 
						if( (flag&num) == num ) {
							System.out.println(1);
						}
						else {
						}
						break;
						
					case "toggle":
						if( (flag&num) == num ) {
							flag &= ~num;
						}
						else {
							flag|=num;
						}
						break;
				}*/
		}	
		System.out.println(sb);
	}
}
