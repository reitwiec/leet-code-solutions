public static int Solution(int n){
int[] array = new int[n+1];
        array[1]=0;
        for(int i=2;i<=n;i++){
            int ans = 1 + array[i-1];
            
            if(i%2==0){
                ans = Math.min(ans,1 + array[n/2]);
            }
           
            if(i%3==0){
                ans = Math.min(ans,1 + array[n/3]);
            }
            
            array[i]=ans;
        }
        
        return array[n];
        }
