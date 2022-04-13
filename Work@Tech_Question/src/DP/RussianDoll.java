package DP;

import java.util.Arrays;

public class RussianDoll {

	class Pair implements Comparable<Pair>{
        int w;
        int h;
        
        Pair(int w,int h){
            this.w = w;
            this.h = h;
        }
        
        public int compareTo(Pair o){
            if(this.w!=o.w)
            return this.w-o.w;
            else
                return this.h-o.h;
        }
        
    }
    public int maxEnvelopes(int[][] envelopes) {
     
        int n = envelopes.length;
        Pair[] arr = new Pair[n]; 
        
        for(int i=0;i<n;i++){
            arr[i] = new Pair(envelopes[i][0],envelopes[i][1]);
        }
        
        Arrays.sort(arr);
        
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j].h<arr[i].h && dp[i]<dp[j]+1){
                    dp[i] = dp[j]+1;
                    max = Math.max(dp[i],max);
                }
            }
        }
        
        return max;
        
    }
	
}
