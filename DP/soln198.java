class Solution {
    public int rob(int[] nums) {
        int l=nums.length;
        if(l==0) return 0;
        if(l==1) return nums[0];
        if(l==2) return Math.max(nums[0],nums[1]);
        
        int[] dp = new int[l];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = dp[0]+nums[2];
        int max = Math.max(dp[1],dp[2]);
        
        for(int i=3;i<l;i++){
            int sum = Math.max(dp[i-2],dp[i-3])+nums[i];
            dp[i]=sum;
            max= Math.max(sum,max);
        }
        
        return max;
            
    }
}
