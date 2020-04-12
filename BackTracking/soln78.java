class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(nums.length==0|| nums == null){
            return ans;
        }
        
        for(int i=0; i<Math.pow(2,nums.length);i++){
            String res = Integer.toBinaryString(i);
            while(res.length()<nums.length) res = "0" + res;
            char[] bin = res.toCharArray();
            List<Integer> comp = new ArrayList<>();
            for(int j=0;j<nums.length;j++){
                if(bin[j]=='1'){
                    comp.add(nums[j]);
                }
            }
            ans.add(comp);
        }
        return ans;
    }
    
    
}
