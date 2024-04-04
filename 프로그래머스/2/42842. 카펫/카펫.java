class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown + yellow;
        int w=brown/2;
        int h=0;
        
        for(int i=w;i>0;i--){
            int th = sum / i;
            int c = sum % i;
            if(c==0 && th*i == sum ){
                w=i;
                h = th;
                if( 2*(w+h)-4 == brown){
                    break;
                }
            }
        }
        answer[0]=w;
        answer[1]=h;
        //System.out.println(w+","+h);
        
        return answer;
    }
}