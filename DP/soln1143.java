class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] cache = new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<cache[0].length;i++){
            cache[0][i]=0;
        }
        
        for(int i=0;i<cache.length;i++){
            cache[i][0]=0;
        }
        
        for(int i=1;i<cache.length;i++){
            for(int j=1;j<cache[0].length;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    cache[i][j]=1+ cache[i-1][j-1];
                }else{
                    cache[i][j]=Math.max(cache[i-1][j],cache[i][j-1]);
                }
            }

        }
        

        
        return cache[text1.length()][text2.length()];
    }
}
