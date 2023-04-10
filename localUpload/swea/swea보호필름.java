package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class swea보호필름 {
	static int ans;
	static int D,W,K;
	static int[][] film;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer("");
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1 ; t<=TC ; t++) {
			st = new StringTokenizer(br.readLine());
			
			D=Integer.parseInt(st.nextToken());
			W=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			
			film = new int[D][W];
			
			for(int i=0 ; i<D ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			Func();
			
			visit = new boolean[D];
			
			for(int r=1; r<D; r++) {
				comb(0, r);
				//내가 지금 1개를 뽑은 상태 ->
				
				//a넣을건지 b넣을건지 
				
				
			}
			
			System.out.println("#"+t+" "+ans);
		}
	}
	
	static void comb(int idx, int r) {
		 if (r == 0) {
			 return;
		 }
		 if (idx == D) {
		    return;
		 }

		 visit[idx] = true;
		 comb(idx + 1, r - 1);

		 visit[idx] = false;
		 comb(idx + 1, r);
	}
	
	private static void Func() {
		
		ans = 1;
	}
}
