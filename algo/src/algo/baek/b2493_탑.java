package algo.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2493_탑 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());	
		int[][] map = new int[n][2];
		int[] top = new int[n];
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			map[i][0]=i+1;
			map[i][1]= Integer.parseInt(st.nextToken());
		}
		
		for(int i=n-1;i>=1;i--) {
			int j=i;
			
			while(j-1>0) {
				if(map[i][1]<map[j-1][1]) {
					top[i]=map[j-1][0];
					break;
				}else {
					j--;
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			System.out.print(top[i]+" ");
		}
	}
}