class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0;i<n;i++){
            String item = Integer.toBinaryString(arr1[i] | arr2[i] );
            item = String.format("%" + n + "s", item);
            
            
            
            
            
            // if(item.length() < n){
            //     for(int j=0;j< n-item.length();j++){
            //         item = "0" + item;   
            //     }
            // }
            item = item.replaceAll("0"," ");
            item = item.replaceAll("1","#");
            
            // System.out.println(item);
            answer[i]=item;
        }
       
        return answer;
    }
}