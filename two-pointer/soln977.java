class Solution {
    public int[] sortedSquares(int[] A) {
        int[] output = new int[A.length];
        int len = A.length-1;
        int lo=0;
        int hi=A.length-1;
        int count =0;
        while(lo<hi){
            int a = Math.abs(A[lo]);
            int b = Math.abs(A[hi]);
            if(a<b){

                output[len]= b*b;
                len--;
                hi--;
                count++;
            }else if(a==b){
                lo++;
                hi--;
                output[len]= b*b;
                len--;
                output[len]= b*b;
                len--;
                count++;
            }else{
                output[len]= a*a;
                len--;
                lo++;
                count++;
            }
        }
        
        if(count!=A.length){
            output[0]= A[lo]*A[lo];
        }
        
        return output;
    }
}
