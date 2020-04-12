class Solution {
    
    public int costCalc(int i, int[]cost, int[]dp){
        if(i>=cost.length) return 0;
        if(dp[i]!=-1){
            return dp[i];
        }
        int ans = cost[i] + Math.min(costCalc(i+1,cost,dp),costCalc(i+2,cost,dp));
        dp[i]=ans;
        return ans;
    }
    
    public int minCostClimbingStairs(int[] cost) {
        int[] cache = new int[cost.length+1];
        Arrays.fill(cache,-1);
        return Math.min(costCalc(0,cost,cache),costCalc(1,cost,cache));
    }
}
