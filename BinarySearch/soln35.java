class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo=0,hi=nums.length-1;
        
        while(lo<hi){
            int mid=lo + (hi-lo)/2;
            if(nums[mid]>=target){
                hi=mid;
            }
            else{
                lo=mid+1;
            }
        }
        if(lo == nums.length-1){
            if(target>nums[nums.length-1]){
                return lo+1;
            }
        }
            return lo;

        
    }
}
