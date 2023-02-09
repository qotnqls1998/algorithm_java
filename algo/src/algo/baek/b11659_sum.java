package algo.baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class b11659_sum {
	static int n;
	static int m;
	static int[] numbers;
	static int[] sums;
	static int t1;
	static int t2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = null;
	    StringBuilder sb = new StringBuilder();
	    
		st = new StringTokenizer(br.readLine());
        
	    n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        numbers=new int[n+1];
        sums=new int[n+1];
        
        
        st = new StringTokenizer(br.readLine());
        
		for(int i=1;i<=n;i++) {
			numbers[i]=Integer.parseInt(st.nextToken());
			if(i==1)
				sums[i]=numbers[i];
			else sums[i]=sums[i-1]+numbers[i];
		}
		
		for(int i=1;i<=m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int sum=0;
			t1=Integer.parseInt(st.nextToken());
			t2=Integer.parseInt(st.nextToken());
			
			sum = sums[t2]-sums[t1-1];		
			
			sb.append(sum);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
