import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int ans=Integer.MAX_VALUE;
    static ArrayList<Pos> house = new ArrayList<>();
    static ArrayList<Pos> chicken = new ArrayList<>();
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //치킨집 체크

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp==1){
                    house.add(new Pos(i,j));
                }else if(tmp==2){
                    chicken.add(new Pos(i,j));
                }
            }
        }
        check = new boolean[chicken.size()];
        backTracking(0,0);
        System.out.println(ans);
    }
    private static void backTracking(int cnt, int idx){
        if(cnt == m){
            int total = 0;
            for(int i=0;i<house.size();i++){

                int min = Integer.MAX_VALUE;
                for(int j=0;j< chicken.size();j++){
                    if(check[j]){
                        int dis = getDis(house.get(i).x,house.get(i).y,chicken.get(j).x,chicken.get(j).y);
                        min = Math.min(min,dis);
                    }
                }
                total += min;
            }
            ans = Math.min(ans,total);
            return;
        }

        for(int i=idx;i< chicken.size();i++){
            if(check[i] == false){
                check[i]=true;
                backTracking(cnt+1,i+1);
                check[i]=false;
            }
        }
    }
    private static int getDis(int x,int y,int x1,int y1){
        return Math.abs(x-x1)+Math.abs(y-y1);
    }

    public static class Pos{
        int x,y;

        public Pos(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

}