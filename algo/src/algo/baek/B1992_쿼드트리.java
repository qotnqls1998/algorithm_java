package algo.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//분할정복
public class B1992_쿼드트리 {
	static int white = 0;
	static int green = 0;
	static int[][] spaces;
	//
	// 주어진 영역의 공간의 셀 체크하여 모두 1이거나 0으로 이루어져있는지 확인 후
	// 4개로 쪼개기.
	public static void cut(int r, int c, int size) {
		int sum=0;
		
		for(int i=r, rEnd=r+size; i<rEnd; i++) {
			for(int j=c, cEnd=c+size;j<cEnd;j++) {
				sum+=spaces[i][j];
			
			}
		}
		if(sum==size*size) {
			
			System.out.print(1);
		}else if(sum==0) {
			System.out.print(0);
		}else {//혼합된 상황
			int half = size/2;
			System.out.print("(");
			cut(r,c,half);
			cut(r,c+half,half);
			cut(r+half, c, half);
			cut(r+half, c+half, half);

			System.out.print(")");
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		int n = Integer.parseInt(br.readLine());
		
		spaces = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				spaces[i][j] = s.charAt(j)-'0';
			}
		}

		cut(0,0,n);//크기는 n으로 출발
		
	}
}
