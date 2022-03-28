package DP;

public class BuyandSell_2 {

	public static void main(String[] args) {
		int[] prices = {6, 1, 4, 2, 5, 3};
		
		System.out.println(ProfitRec(prices,0,1));
	}
	

	public static int ProfitRec(int[] prices,int i,int buy) {
		
		if(i==prices.length)
			return 0;
		
		int profit = 0;
		
		if(buy==1) {
			profit = Math.max(-prices[i]+ProfitRec(prices, i+1, 0), ProfitRec(prices, i+1, 1));
		}else {
			profit = Math.max(prices[i]+ProfitRec(prices, i+1, 1),ProfitRec(prices, i+1, 0));
		}
		
		return profit;
	}
	
	public static int ProfitDP(int[] prices) {
		
		int n = prices.length;
		int[][] dp = new int[n+1][2];
		
		dp[n][0] = dp[n][1] = 0;
		
		for(int i=n-1;i>=0;i--) {
			for(int buy=0;buy<=1;buy++) {
				int profit = 0;
				if(buy==1) {
					profit = Math.max(-prices[i]+dp[i+1][0], dp[i+1][1]);
				}else {
					profit = Math.max(prices[i]+dp[i+1][1], dp[i+1][0]);
				}
				
				dp[i][buy]=profit;
			}
		}
		
		return dp[0][0];
		
		
	}
	
	public static int ProfitSO(int[] prices) {
		
		int aheadNotBuy=0,aheadBuy=0,curBuy=0,curNotBuy=0;
		
		//aheadBuy = aheadNotBuy = 0;
		
		int n = prices.length;
		
		for(int i=n-1;i>=0;i--) {
			
			curBuy = Math.max(-prices[i]+aheadNotBuy, aheadBuy);
			 
			curNotBuy = Math.max(prices[i]+aheadBuy, aheadNotBuy);
			
			aheadBuy = curBuy;
			
			aheadNotBuy = curNotBuy;
			
		}
		
		return curBuy;
		
	}
	
}
