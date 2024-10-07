import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static int[][] note;
    static boolean[][] isVisit;
    static int cnt;
    static int maxArea;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        note = new int[n][m];
        isVisit = new boolean[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                note[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(note[i][j]==1 && !isVisit[i][j]){
                    maxArea = Math.max(bfs(i,j),maxArea);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(maxArea);
    }
    private static int bfs(int x,int y){
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        isVisit[x][y] = true; // 탐색 완
        int area = 0;

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{x,y});

        while(!queue.isEmpty()){
            area++;
            int[] arr = queue.poll();
            int arrx = arr[0];
            int arry = arr[1];

            for(int i=0;i<4;i++){
                int nx = arrx + dx[i];
                int ny = arry + dy[i];

                if(!check(nx,ny)) continue;
                if(isVisit[nx][ny] || note[nx][ny] !=1 )continue;

                isVisit[nx][ny] = true;
                queue.offer(new int[]{nx,ny});
            }

        }

        return area;
    }

    private static boolean check(int x,int y){
        if(x<0||x>=n||y<0||y>=m) return false;
        return true;
    }
}