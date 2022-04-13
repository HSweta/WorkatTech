package DP;

import java.util.Arrays;

public class LIS {
	static int ans = 0;
public static void main(String[] args) {
	
}
  public static int LISRec(int[] arr,int n) {
	  if(n==1)
		  return 1;
	  
	  int res,max_ending = 1;
	  
	  for(int i=1;i<n;i++) {
		  res = LISRec(arr, i);
		  if(arr[i-1]<arr[n-1] && res+1>max_ending) {
			  max_ending = res+1;
		  }
		  
	  }
	  
	  if(ans<max_ending)
		  ans = max_ending;
	  
	  return max_ending;
  }
  
  
  public static int LISDP(int[] arr) {
	  
	  int max = Integer.MIN_VALUE;
	  int[] strg = new int[arr.length];
	  Arrays.fill(strg,1);
	  
	  for(int i=0;i<arr.length;i++) {
		  for(int j=0;j<i;j++) {
			  if(arr[j]<arr[i]) {
				  strg[i] = Math.max(strg[i], strg[j]+1);
				  max = Math.max(max, strg[i]);
			  }
		  }
	  }
	  
	  return max;
  }
  
  public static int LISBU(int[] arr) {
	  int[] le = new int[arr.length];
	  le[0] = arr[0];
	  int len = 1;
	  
	  for(int i=1;i<arr.length;i++) {
		if(arr[i]>le[len-1]) {
			le[len] = arr[i];
			len++;
		}else {
			int idx = binarySearch(arr, 0, len-1, arr[i]);
			le[idx] = arr[i];
		}
	  }
	  
	  
	  return len;
  }
  
  public static int binarySearch(int[] arr,int si,int ei,int item) {
	  int low = si;
	  int high= ei;
	  
	  while(low<=high) {
		  
		  int mid = (low+high)/2;
		  
		  if(item<arr[mid])
			  low=mid+1;
		  else
			  high=mid-1;
	  }
	  return low;
  }
  
 
}
