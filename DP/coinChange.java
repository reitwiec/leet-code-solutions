import java.util.*;
import java.io.*;


public class coinChange {
	
	public static int findChange(int n, int[] denom,int startIndex, int k, int[][]dp) {
		
		if(n==0) {
			return 1;
		}
		if(n<0) {
			return 0;
		}
		if(k==0) {
			return 0;
		}
		
		if(dp[n][k]>=0) {
			return dp[n][k];
		}
		
		int option1 = findChange(n-denom[0+startIndex],denom,0,k,dp);
		int option2 = findChange(n,denom,startIndex+1,k-1,dp);
		
		dp[n][k]= option1+option2;
		
		return dp[n][k];
	}

	public static void main(String[] args) {
		int n = 4;
	
		int[] denom = new int[] {1,2};
		int[][] array = new int[n+1][denom.length+1];
		for(int[]row:array) {
			Arrays.fill(row, -1);
		}
		System.out.println(findChange(n,denom,0,denom.length,array));
	}
}
