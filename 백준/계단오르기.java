import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 계단오르기 {
    static int n;
    static int stairs[];
    static int num[];
    static int total;
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        stairs=new int[n];
        num = new int[n];

        //입력
        for(int i=0;i<n;i++){
            stairs[i]=Integer.parseInt(br.readLine());
        }

        //계산
        num[0]=1;
        num[1]=2;
        for(int i=2;i<n;i++){
            num[i]=num[i-1]+num[i-2];
        }

        


        System.out.println(total);
    }
}
