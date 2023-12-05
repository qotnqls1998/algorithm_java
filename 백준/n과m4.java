import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n과m4 {
    static int n;
    static int m;
    static int num[];
    static boolean select[];
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder("");
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        num = new int[m];
        select = new boolean[n+1];
        backTrack(0,0);
        System.out.println(sb);
    }
    private static void backTrack(int dep, int r){
        if(r==0){
            //종료조건
            for(int i=0;i<m;i++){
                sb.append(num[i]+" ");
            }
            sb.append("\n");
            return;
        }
        if(dep==m){
            return;
        }
        for(int i=1;i<=n;i++){
            select[i]=true;
            num[dep]=i;
            backTrack(dep+1,r+1);

            select[i]=false;
            backTrack(dep+1,r);

        }

    }
}
