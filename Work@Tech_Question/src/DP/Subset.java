package DP;

public class Subset {

	public boolean hasValidSubset(int[] A, int sum) {
		
		boolean[][] dp = new boolean[A.length+1][sum+1];
		
		for(int i=0;i<=A.length;i++)
			dp[i][0] = true;
		
		for(int i=1;i<=sum;i++)
			dp[0][i] = false;
		
		for(int i=1;i<=A.length;i++) {
			for(int j=1;j<=sum;j++) {
				dp[i][j] = dp[i-1][j];
				
				if(A[i-1]<=j) {
					dp[i][j] = dp[i-1][j] || dp[i-1][j-A[i-1]];
				}
				
			}
		}
		
		return dp[A.length][sum];
		
	}
}
