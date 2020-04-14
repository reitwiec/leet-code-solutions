class Solution {
     public static int stoneDFS(int l, int r, int[][] dp, int[] piles){
        if(dp[l][r]!=0){
            return dp[l][r];
        }

        if(l>r){
            return 0;
        }

        if(l==r){
            return piles[l];
        }

        int ans1 = piles[l] - stoneDFS(l+1,r,dp,piles);
        int ans2 = piles[r] - stoneDFS(l,r-1,dp,piles);

        return dp[l][r]=Math.max(ans1,ans2);
    }

    public static boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];

        return stoneDFS(0,n-1,dp,piles)>0;
    }
}
