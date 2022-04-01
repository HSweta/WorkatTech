package DP;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {
		
	}
	public static boolean workBreak(String s,String[] w) {
		Set<String> dic = new HashSet<>();
		for(String d:w)
			dic.add(d);
		int[] dp = new int[s.length()];
		
		for(int i=0;i<s.length();i++) {
			for(int j=0;j<=i;j++) {
				String w2check = s.substring(j,i+1);
				if(dic.contains(w2check)) {
					if(j>0) {
						dp[i]+=dp[j-1];
					}else {
						dp[i]+= 1;
					}
				}
			}
		}
		
		
		return dp[s.length()-1]>0;
			
		
	}
	

}
