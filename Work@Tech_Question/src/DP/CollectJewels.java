package DP;

public class CollectJewels {

	class JewelStone {
	    int weight, value;
	    JewelStone(int weight, int value) {
	        this.weight = weight;
	        this.value = value;
	    }
	}
	
	public static void main(String[] args) {
		
	}
	
	public int  getMaxValue (JewelStone[] stones, int capacity) {
		
		int[][] dp = new int[stones.length+1][capacity+1];
		
		for(int i=0;i<=stones.length;i++) {
			for(int j=0;j<=capacity;j++) {
				if(i==0 || j==0) {
				    dp[i][j] = 0;
				}else if(j-stones[i-1].weight>=0) {
					dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-stones[i-1].weight]+stones[i-1].value);
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		return dp[stones.length][capacity];
	}

}
