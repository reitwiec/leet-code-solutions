class Solution {
    static int m,n;
    
    
    public int getMaximumGold(int[][] grid1) {
        m = grid1.length;
        n = grid1[0].length;
        int res=0;
        
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int temp = findGold(grid1,i,j,0);
                res= Math.max(res,temp);
            }
        }
        
        return res;
    }
    
    public int findGold(int[][]grid, int x,int y,int currSum){
        if(x<0||x>=m || y<0 || y>=n){
            return currSum;
        }
        
        if(grid[x][y]==0 || grid[x][y]==-1){
            return currSum;
        }
        
        int copy = grid[x][y];
        grid[x][y]=-1;
        int temp = copy+currSum;
        
        int a = findGold(grid,x,y+1,temp);
        int b = findGold(grid,x,y-1,temp);
        int c = findGold(grid,x+1,y,temp);
        int d = findGold(grid,x-1,y,temp);
        
        grid[x][y]=copy;
        
        return Math.max(a,Math.max(b,Math.max(c,d)));
        
    }
}
