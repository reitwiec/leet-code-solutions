import java.io.*;
import java.util.*;

public class soln1277 {

    public static int countSquares(int[][] mat) {
            int m= mat.length;
            int n = mat[0].length;

            int[][] dp = new int[m][n];

            for(int i=0;i<n;i++){
                dp[0][i]=mat[0][i];
            }

            for(int i=0;i<m;i++){
                dp[i][0]=mat[i][0];
            }

            for(int i=1;i<m;i++){
                for(int j=1;j<n;j++){
                    if(mat[i][j]==0){
                        dp[i][j]=0;
                    }
                    else if(mat[i][j]==1){
                        dp[i][j]= Math.min(dp[i][j-1],Math.min(dp[i-1][j-1],dp[i-1][j])) + mat[i][j];
                    }
                }
            }
        int sum=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                sum+=dp[i][j];
            }
        }
        return sum;
    }


    public static void main(String[] args){
        int [][] mat = new int[][]{{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        System.out.println(countSquares(mat));
    }
}
