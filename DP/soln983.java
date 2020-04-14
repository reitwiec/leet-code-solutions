class Solution {
    public static int dp(int i,int[] dp,int[] costs,HashSet<Integer> dayset){
        if(i>dp.length-1){
            return 0;
        }
        int ans;
        if(dp[i]!=0) return dp[i];

        if(dayset.contains(i)){
            ans = Math.min(costs[0]+dp(i+1,dp,costs,dayset),costs[1]+dp(i+7,dp,costs,dayset));
            ans = Math.min(costs[2]+dp(i+30,dp,costs,dayset),ans);
        }else{
            ans= dp(i+1,dp,costs,dayset);
        }

        dp[i]=ans;
        return ans;
    }

    public static int mincostTickets(int[] days, int[] costs) {
        int[]dp = new int[days[days.length-1]+1];
        HashSet<Integer> dayset = new HashSet();
        for(int i:days) dayset.add(i);
        for(int i:dp){
            i=0;
        }

        return dp(1,dp,costs,dayset);
    }
}
