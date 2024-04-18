import java.util.*;
import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		int n =0;
		int answer =0;
	
		n = Integer.parseInt(br.readLine());
		
		int point[][] = new int[n][2];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			point[i][0]=Integer.parseInt(st.nextToken());
			point[i][1]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(point, Comparator.comparingInt((int[] o) ->o[0]));
		
		int min=point[0][0];
		int max = point[0][1];
		answer = max-min;
		for(int i=1;i<n;i++) {
			int x = point[i][0];
			int y = point[i][1];
			//System.out.println(x +"," +y+"/" +min+","+max);
			
			if(min>=x && max <=y) continue;
		
			else if(max<=x) {
				answer += y-x;
				min = x;
				max = y;
				//System.out.println("ans3:" + answer);
			}
			else if(min<=x && max<=y) {
				answer += y-max;
				max = y;
				//System.out.println("ans2:" + answer);
			}
			//System.out.println("ans:" + answer);
			
		}
		
		
		
		System.out.println(answer);
	}
	
}