package DP;

public class Buy_Sell_III {

	public static void main(String[] args) {
		
		
	}
	
	public int maxProfit(int[] prices,int n) {
		
		int[][][] dp = new int[n+1][2][3];
		
		for(int i=n-1;i>=0;i--) {
			for(int buy=0;buy<=1;buy++) {
				for(int cap=1;cap<=2;cap++) {
					if(buy==1) {
					dp[i][buy][cap] =  Math.max(-prices[i]+dp[i+1][0][cap], dp[i+1][1][cap]);
				}else {
					dp[i][buy][cap] =  Math.max(prices[i]+dp[i+1][1][cap-1], dp[i+1][0][cap]);
						
				}
			}
		 }
		}
		
		return dp[0][1][2];
	}
	
	public int maxProfitSO(int[] prices,int n) {
		
		int[][] after = new int[2][3];
		int[][] cur = new int[2][3];
		
		for(int i=n-1;i>=0;i--) {
			for(int buy=0;buy<=1;buy++) {
				for(int cap=1;cap<=2;cap++) {
					if(buy==1) {
						cur[buy][cap] = Math.max(-prices[i]+after[0][cap], after[1][cap]);
					}else {
						cur[buy][cap] = Math.max(prices[i]+after[1][cap-1],after[0][cap]);
					}
				}
			}
			
			after = cur;
		}
		
		
		return after[1][2];
	}
	
	
	public int maxProfitTO(int[] prices,int n,int k) {
		
		int[][] dp = new int[n+1][2*k+1];
		
		for(int i=n-1;i>=0;i--) {
			for(int t=2*k-1;t>=0;t--) {
				if(t%2==0) {
					dp[i][t] = Math.max(-prices[i]+dp[i+1][t+1], dp[i+1][t]);
				}else {
					dp[i][t] = Math.max(prices[i]+dp[i+1][t+1], dp[i+1][t]);
				}
			}
		}
	
	
	return dp[0][0];
}
}