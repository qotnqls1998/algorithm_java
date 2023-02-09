package week2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1260_bfsdfs {
	static StringBuilder sb = new StringBuilder();
	static boolean[] check;
	static int[][] arr;
	
	static int node, line, start;
	
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		node = Integer.parseInt(st.nextToken()); //정점 수 (1~N)
		line = Integer.parseInt(st.nextToken()); //간선 
		start= Integer.parseInt(st.nextToken()); // 시작점
		
		arr = new int[node+1][node+1]; //정점은 1부터 있다고 가정
		check = new boolean[node+1]; //체크도 
		
		for(int i = 0 ; i < line ; i ++) { //간선 수만큼 !! (간선의 개수만큼 입력이 들어오겠즁)
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			//그냥 입력받오
			int a = Integer.parseInt(str.nextToken()); 
			int b = Integer.parseInt(str.nextToken());
			
			//입력받은 값 있잖아 그 배열이 연결되있다믄 .. 1로 변경 !!
			//근데 왜 두개 다 1로 처리하는거지 ?? 이어져있다는뜻 !! 
			arr[a][b] = arr[b][a] =  1;	//양방향이래
		}
		
			//정점찍었으니..dfs
			dfs(start);
			
			sb.append("\n");
			
			//check = new boolean[node+1];
			//bfs(start);
			
			System.out.println(sb);
		
		}
	//깊이 우선 탐색 먼저 가죠
	public static void dfs(int start) {
		//방금 체크한 정점은 true로 ㄱ ㄱ
		check[start] = true; //
		sb.append(start + " ");
		
		for(int i = 0 ; i <= node ; i++) {
			if(arr[start][i] == 1 && !check[i])
				dfs(i);
		}
		
	}
	
	public static void bfs(int start) {
		q.add(start);
		check[start] = true;
		
		while(!q.isEmpty()) {	
			start = q.poll();
			sb.append(start + " ");
			for(int i = 1 ; i <= node ; i++) {
				if(arr[start][i] == 1 && !check[i]) {
					q.add(i);
					check[i] = true;
				}
			}
		}	
	}
}




