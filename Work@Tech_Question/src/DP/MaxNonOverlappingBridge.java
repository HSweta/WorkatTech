package DP;

import java.util.Arrays;

public class MaxNonOverlappingBridge {

	class Bridge implements Comparable<Bridge>{
	
		int n;
		int s;
		
		Bridge(int n,int s){
			this.n = n;
			this.s = s;
		}
		
		public int compareTo(Bridge o) {
			if(this.n!=o.n)
			   return this.n-o.n;
			else
				return this.s-o.s;
		}
		
	}
	public static void main(String[] args) {
		
	}
	
	public int NoOfBridges(int[][] intervals) {
		int n = intervals.length;
		Bridge[] bdge = new Bridge[n];
		
		for(int i=0;i<n;i++) {
			bdge[i] = new Bridge(intervals[i][0],intervals[i][1]);
		}
		
		Arrays.sort(bdge);
		
		int[] dp = new int[n];
		int omax = 1;
		
		for(int i=0;i<n;i++) {
			
			for(int j=0;j<i;j++) {
				if(bdge[j].s<=bdge[j].s && dp[i]<dp[j]+1) {
				   dp[i] = dp[j]+1;
				   omax = Math.max(dp[i], omax);
				}
			}
		}
		
		return omax;
	}
}
