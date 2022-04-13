package DP;

import java.util.Arrays;

public class Longest_Biotonic {
public static void main(String[] args) {
	
}

  public static int LBDP(int[] arr) {
	 
	 int n = arr.length; 
	 int[] lis = new int[n];
	 Arrays.fill(lis, 1);
	 
	 
	 for(int i=1;i<n;i++) {
		 for(int j=0;j<i;j++) {
			 if(arr[i]>arr[j] && lis[i]<lis[j]+1)
				 lis[i] = lis[j]+1;
		 }
	 }
	 
	 int[] lds = new int[n];
	 Arrays.fill(lds,1);
	 
	 for(int i=n-2;i>=0;i--) {
		 for(int j=n-1;j>i;j--) {
			 if(arr[i]>arr[j] && lds[i]<lds[j]+1)
				 lds[i] = lds[j]+1;
		 }
	 }
	 
	 int max = lis[0]+lds[0]-1;
	 for(int i=1;i<n;i++) {
		 if(lis[i]+lds[i]-1>max)
			 max = lis[i]+lds[i]-1;
	 }
	 
	 return max;
		
  }
}
