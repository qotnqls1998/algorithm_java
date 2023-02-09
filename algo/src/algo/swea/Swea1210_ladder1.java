package algo.swea;
import java.util.Scanner;

public class Swea1210_ladder1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//좌, 우, 상
		int[] dx= {0,0,-1};
		int[] dy= {-1,1,0};

		int res = -100;
		int end=2;
		int endx=0;
		int endy=0;
		
		for(int i=0;i<10;i++) {
		
			int n = sc.nextInt();
			int[][] map = new int[100][100];
			int[] gx = new int[3];
			int[] gy = new int[3];//계속 바뀌는 수
			
			//계산 시작
			for(int j=0;j<100;j++)
				for(int k=0;k<100;k++) {
					map[j][k]=sc.nextInt();
					if (map[j][k]==end) {
						endx=j;
						endy=k;
						}
					}
		
			//거꾸로 올라가자 1만따라서
			while(true) {
				
				int chk=0;
				if(endx==0)break;
				for(int l=0;l<3;l++) {
					// 상, 좌, 우 중에 값을 벗어나거나 
					// 현재 가는 방향과 같으면  continue
					
					gx[l] = endx+dx[l];
					gy[l] = endy+dy[l];
					if (gx[l]>=0 && gy[l]>=0 && gx[l]<100 && gy[l]<100)	
						if(map[gx[l]][gy[l]]==1) {	
							chk++;
							if(chk!=2) {
								endx = gx[l];
								endy = gy[l];
							}
						}		
					}
				
				map[endx][endy]=2; //최종 가는 길만 맵에 표시 
				res = endy;
				}
			//출력 부분
			System.out.print("#"+n+" ");
			System.out.println(res);
			
//			for(int j=0;j<100;j++) {
//				for(int k=0;k<100;k++) {
//					System.out.print(map[j][k]);
//					}
//				System.out.println();
//			}
		}
	
	}
}
