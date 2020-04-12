class Solution {
    public int countWays(int n,int[] cache){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(cache[n]!=0){
            return cache[n];
        }
        
        cache[n]=countWays(n-1,cache)+countWays(n-2,cache);
        
        return cache[n];
    }
    
    
    public int climbStairs(int n) {
        int[] array = new int[n+1];
        Arrays.fill(array,0);
        return countWays(n,array);

    }
}
