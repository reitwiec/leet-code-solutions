class Solution {
    public static int minCost(int l, int r,int[][]dp,int[][]A){
        
        if(l<0 || l>=A.length || r<0 || r>=A.length){
            return Integer.MAX_VALUE;
        }

        if(dp[l][r]!=0){
            System.out.println(dp[l][r]);
            return dp[l][r];
        }

        return dp[l][r]=A[l][r]+ Math.min(minCost(l+1,r+1,dp,A),Math.min(minCost(l+1,r-1,dp,A),minCost(l+1,r,dp,A)));
    }

    public static int minFallingPathSum(int[][] A) {
        int n = A.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            dp[n-1][i]= A[n-1][i];
        }

        int min= Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            min = Math.min(min,minCost(0,i,dp,A));
        }

        return min;
    }
}
