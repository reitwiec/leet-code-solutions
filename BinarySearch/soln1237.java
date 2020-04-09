/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */

class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int i=1;
        while(i<1000){
            int j = binarySearch(customfunction,i,z);
            if(customfunction.f(i,j)==z){
                ans.add(Arrays.asList(new Integer[]{i, j}));
            }
            
            i++;
        }

        return ans;
    }
    public int binarySearch(CustomFunction customfunction,int k,int a){
        int lo=1,hi=1000;
        while(lo<hi){
            int mi=lo + (hi-lo)/2;
            if(customfunction.f(k,mi)>=a){
                hi=mi;
            }else{
                lo=mi+1;
            }
        }
        return lo;
    }
}
