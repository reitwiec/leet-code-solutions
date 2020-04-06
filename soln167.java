class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left=0; 
        int right = numbers.length-1;
        
        while(left<=right){
            int sum = numbers[left] + numbers[right];
            if(sum>target){
                right--;
            }
            if(sum<target){
                left++;
            }
            if(sum ==target){
                return new int[]{left+1,right+1};
            }
        }
        return new int[]{left+1,right+1};
    }
}
