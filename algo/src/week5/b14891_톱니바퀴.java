package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b14891_톱니바퀴 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer("");
		int[][] wheel = new int[5][9];
		
		for(int i=1;i<=4;i++) {
			String s = br.readLine();
			for(int j=1;j<=8;j++) {
				
				wheel[i][j]= s.charAt(j) - '0';
				System.out.print(wheel[i][j]);
			}
			System.out.println();
		}
		
		int K = Integer.parseInt(br.readLine());
		
		for(int i=0;i<K;i++) {
			int wheel_num = Integer.parseInt(br.readLine()) ;
			int dir = Integer.parseInt(br.readLine());
			
			
			
			
			
			
			
			
		}
		
		//이제 톱니바퀴 점수 계산
		
	}
}
