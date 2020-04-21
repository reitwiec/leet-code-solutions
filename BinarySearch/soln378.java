class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(); 
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                pQueue.add(matrix[i][j]);
            }
        }
        int val=0;
        while(k>0){
            k--;
            val=pQueue.poll();
        }
        
        return val;
    }
}
