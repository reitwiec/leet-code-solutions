class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int lo=Arrays.stream(weights).max().getAsInt(), hi= Arrays.stream(weights).sum();
        
        while(lo<hi){
            int wt=0;
            int days=1;
            int mid = lo +(hi-lo)/2;
            
            for(int weight:weights){
                if(wt+weight>mid){
                    wt=0;
                    days++;
                }
                wt+=weight;
            }
            
            if(days>D){
                lo=mid+1;
            }
            else{
                hi=mid;
            }
        }
        return lo;
    }
}
