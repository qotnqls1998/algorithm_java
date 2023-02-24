package algo.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b17406_배열돌리기4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
	    int res;
		st = new StringTokenizer(br.readLine());
	
		//step1.입력 받기
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		int[][] oper = new int[k][3];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());	
			}	
		}
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				oper[i][j]=Integer.parseInt(st.nextToken());	
			}
		}
		//oper[0][0] oper[0][1] oper[0][2]
		// r         c          s
		
		
		//배돌 시작!!
		for(int p=0; p<k; p++) {//2번 ..
			int x1= oper[p][0]-oper[p][2];
			int y1= oper[p][1]-oper[p][2];
			
			int x2= oper[p][0]+oper[p][2];
			int y2= oper[p][1]+oper[p][2];
			
			int new_n = x2-x1+1;
			int new_m =  y2-y1+1;
			
			int check = Math.min(new_n, new_m )/ 2; 
			
			for(int l=0;l<check;l++) { //사각형 몇개 돌려??
					int n_max = new_n- l-1;
					int m_max = new_m- l-1;
					
					int tmp = map[l][l];
					
					for(int i = l; i < m_max; i++){
						map[l][i] = map[l][i + 1];
					}
					// 오른쪽 변 : 아래 <- 위
					for(int i = l; i < n_max; i++){
						map[i][m_max] = map[i + 1][m_max];
					}
					// 아래쪽 변 : 왼 -> 오
					for(int i = m_max; i > l; i--){
						map[n_max][i] = map[n_max][i - 1];
					}
					// 왼쪽 변 : 위 -> 아래
					for(int i = n_max; i > l; i--){
						map[i][l] = map[i - 1][l];
					}
					map[l+1][l] = tmp;
				
			}
			
		}
		//배돌 끝 ... 힘들다
		
		//step4.마지막 출력
		int tmp=0;
		int Max=0;
		
		for(int i=0; i<n; i++) {
			tmp=0;
			for(int j=0;j<m;j++) {
				tmp += map[i][j];
			}	
			Max = Math.max(tmp, Max);
		}
		System.out.println(Max);
	}
}
