package test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.LinkedList; //import
import java.util.Queue; //import

public class b17135_castle_queue {

	static int N,M,D;
	static int[][] map;
	static int[][] new_map;
	static boolean[] visit;
	static int max_enemy=0;
	static int kill_enemy=0;
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		D=sc.nextInt();
		
		map= new int[N][M];
		new_map= new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		int map_sum=0;
		int cnt=0;
		
		//조합으로 0~m-1 m개 중에서 3개만뽑아 -> 궁수의 위치 (N, x1) (N, x2) (N, x3)  
		int[][] arr= { {0,1,2},{0,1,3},{0,1,4},{0,2,3},{0,2,4},{0,3,4},{1,2,3},{1,2,4},{1,3,4},{2,3,4}};
		//int[][] arr= { {0,2,4}};
		for(int k=0;k<arr.length;k++) {
			//궁수의 위치가 달라지는 개수만큼 반복하자 
			kill_enemy=0;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					new_map[i][j]=map[i][j];
				}
			}
			
			//한타임마다 ( 궁수 죽여서 1초 지날때 마다 ) -> 모든걸 리셋
			cnt=0;
		
			while(true) {
				
				Queue<Point> q = new LinkedList<>();
				Set<Point> hs=new HashSet<>();
				
				visit= new boolean[3];
				map_sum=0;
				
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						map_sum+=new_map[i][j];
					}
				}
				
				if(map_sum==0)break;
				//궁수 죽여!
				//맨끝에 행부터 왼-> 오 순으로 1 인지, 거리 되는지 탐색
				
				
				for(int a=0;a<3;a++) {//3개 . 1인 1 쏨
					int min_value=Integer.MAX_VALUE;
					int tmp=-1;
					int tmp_i=-1,tmp_j=-1;
					int min_j=Integer.MAX_VALUE;
					
					for(int i=N-1;i>=0;i--) {
						for(int j=0;j<M;j++) {			
							
							//이부분을 수정해야함.. 가장 가까운 적을 어떻게 죽이지 ?
							if(!visit[a]&&new_map[i][j]==1) {
								int tmp_dist=Dist(i, N, j , arr[k][a] );
								
								if( tmp_dist <= D ) {
									//System.out.println("i,j: "+i+","+j);
									min_value=Math.min(Dist(i, N, j , arr[k][a]) , min_value );
									
									if(min_value==tmp_dist) {
										//가장 왼쪽 적
										if(j < min_j) {
												//System.out.println("here!!");
												tmp=a;
												tmp_i=i;
												tmp_j=j;
												min_j=j;
											
											}
										
									}
								 }
							}
							
						}		
					}
					//System.out.println();
					
					if(tmp!=-1) {
						//System.out.println(tmp);
						visit[tmp]=true;
						Point p = new Point(tmp_i,tmp_j);
						hs.add(p);
					}
				}
				
			     
			    for(Point p:hs) {
			        //System.out.println(p.x +" "+p.y);
					kill_enemy++;
					new_map[p.x][p.y]=0;
			    }
			   // System.out.println();
				
//				System.out.println("쐈다");
//				
//				for(int i=0;i<N;i++) {
//					for(int j=0;j<M;j++) {
//						System.out.print(new_map[i][j]+" ");
//						map_sum+=new_map[i][j];
//					}
//					System.out.println();
//				}
//				System.out.println("죽인 적: "+kill_enemy);
//				System.out.println();
			
				//적군 들어온다
				for(int i=N-1;i>=1;i--) {
					for(int j=0;j<M;j++) {
						new_map[i][j]=new_map[i-1][j];
					}
				}
				for(int j=0;j<M;j++) {
					new_map[0][j]=0;
				}
				
				//출력 테스트 
//				System.out.println("바꿨다");
//				for(int i=0;i<N;i++) {
//					for(int j=0;j<M;j++) {
//						System.out.print(new_map[i][j]+" ");
//						map_sum+=new_map[i][j];
//					}
//					System.out.println();
//				}
//				
				
		//		System.out.println();
//				
				
			}	
			//System.out.println("끝 ! 다음 궁수 위치해 이번에는 "+kill_enemy+"명 죽였어");
			max_enemy = Math.max(max_enemy, kill_enemy);
		}
		
		System.out.println(max_enemy);
	}

	private static int  Dist(int r1, int r2, int c1, int c2) {
		return (Math.abs(r1-r2) + Math.abs(c1-c2));
	}
}
class Point{
	int x;
	int y;
	Point(int x, int y){
		this.x=x;
		this.y=y;
	}
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point tmp = (Point)obj;
			return x==tmp.x && y==tmp.y;
		}
		return false;
	}
	public int hashCode() {
		return Objects.hash(x,y);
	}
}