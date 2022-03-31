package DP;

import java.util.Arrays;

public class CoinChange {

	 public static void main(String[] args) {
		
		 int arr[] = {5, 2, 4};
		 System.out.println(numberOfCombinations(arr, 13));
	}
	 

		
	public static int numberOfCombinations(int[] A, int target) {
		    // add you logic here
			
			int[] dp = new int[target+1];
			int n = dp.length;
			Arrays.sort(A);
			Arrays.fill(dp,0);
			dp[0] = 1;
			
		 for (int i=0; i<n; i++) {
	            for (int j=A[i]; j<=target; j++) {
	                dp[j] += dp[j-A[i]];}
	 
		 }
			return dp[target];
		}
}
