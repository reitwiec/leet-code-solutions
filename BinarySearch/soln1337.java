class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int rows = mat.length;
        int[] score = new int[rows];
        for(int i=0;i<mat.length;i++){
            int j= binarySearch(mat[i]);
            System.out.println(j);
            score[i]=(j*rows)+i;
        }
        
        Arrays.sort(score);
        for (int i = 0; i < score.length; i++) {
            score[i] = score[i] % rows;
        }

        return Arrays.copyOfRange(score, 0, k);
    
    }
    
    public int binarySearch(int[] A){
        int lo=0, hi=A.length-1;
        while(lo<hi){
            int mi=(hi+lo+1)/2;
            if(A[mi]>=1){
                lo=mi;
            }else{
                hi=mi-1;
            }
        }
        if(A[lo]==1){
            return lo+1;
        }
        else{
            return 0;
        }
    }
}
