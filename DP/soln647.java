class Solution {
    public static int countSubstrings(String s) {
        if(s.isEmpty()){
            return 0;
        }
        char[]str = s.toCharArray();
        boolean[][] dp = new boolean[str.length][str.length];
        int count=0;
        for(int i =0;i<str.length;i++){
            count++;
            dp[i][i]= true;
        }

        for(int i=0;i<str.length-1;i++){
            if(str[i]==str[i+1]){
                count++;
                dp[i][i+1]=true;
            }
        }

        for(int ln=3;ln<=str.length;ln++){
            for(int i=0;i<str.length-ln+1;i++){
                int j= i+ln-1;
                if(dp[i+1][j-1]&& str[i]==str[j]){
                    count++;
                    dp[i][j]=true;
                }
            }
        }
        return count;
    }
}
