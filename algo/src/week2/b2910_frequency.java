package week2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class b2910_frequency{
	public static void main(String[] args) {
		Map<Integer,Integer> map = new LinkedHashMap<Integer, Integer>();
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int c = sc.nextInt();
		
		int[] cnt = new int[c+1];
		
		for(int i=0;i<n;i++) {
			int num = sc.nextInt();
			cnt[num]+=1;
			  // 키가 존재하면 value를 +1
            if (map.containsKey(num)) {
            	map.replace(num, map.get(num) + 1);
            }
            // 키가 없을시 value 값을 1로 생성한다.
            else {
            	map.put(num, 1);
            }
//			if (cnt[num]>1) {
//				map.replace(num, cnt[num]);
//	           }
//	            // 키가 없을시 value 값을 1로 생성한다.
//	         else {
//	            	map.put(num, cnt[num]);
//	            }
		}

		ArrayList<Integer> v = new ArrayList<Integer>(map.keySet());
	    
		Collections.sort(v, new Comparator<Integer>() {
	            @Override
	            public int compare(Integer a, Integer b) {
	                return Integer.compare(map.get(b), map.get(a));
	            }
	        });

		  Iterator<Integer> it = v.iterator();
	        while (it.hasNext()) {
	            Integer element = it.next();
	            for(int i=0; i<map.get(element); i++){
	                System.out.print(element+" ");    
	            }
	            
	        }
	
	}
}