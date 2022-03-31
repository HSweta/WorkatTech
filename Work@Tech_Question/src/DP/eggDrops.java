package DP;

public class eggDrops {
   public static void main(String[] args) {
	
  }
   
   public static int minEggsDropsRec(int eggs,int floors) {
	   if(floors<=1 || eggs==1) {
		   return floors;
	   }
	   int minimum = Integer.MAX_VALUE,result;
	   
	   for(int i=1;i<=floors;i++) {
		   result = Math.max(minEggsDropsRec(eggs-1, i-1),minEggsDropsRec(eggs, floors-i));
	       minimum = Math.min(result, minimum);
	   }
	   
	   return minimum+1;
   }
   
   
   public static int minEggsDropsDP(int eggs,int floors) {
	   
	   int[][] dp = new int[eggs+1][floors+1];
	   
	   for(int i=1;i<=eggs;i++) {
		   for(int j=1;j<=floors;j++) {
			   if(i==1) {
				   dp[i][j] = j;
			   }else if(j==1) {
				   dp[i][j]=1;
			   }else {
				   int min = Integer.MAX_VALUE;
				   for(int mj=j-1,pj=0;mj>=0;mj--,pj++) {
					   int v1 = dp[i][mj];
					   int v2 = dp[i-1][pj];
					   int val = Math.max(v1, v2);
					   min = Math.min(val,min);
				   }
				   dp[i][j] = min+1;
			   }
		   }
	   }
	   
	   return dp[eggs][floors];
   }
}
