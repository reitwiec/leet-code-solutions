class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];
        L[0]=1;
        R[nums.length-1]=1;
        
        for(int i=1;i<nums.length;i++){
            L[i]=nums[i-1]*L[i-1];
        }
        for(int i=nums.length-2;i>=0;i--){
            R[i]=nums[i+1]*R[i+1];
        }

        int[] ans = new int[nums.length];
        
        for(int i=0;i<nums.length;i++){
            ans[i]=L[i]*R[i];
        }
        
        return ans;
    }
}
