class Solution {
    public boolean canWin(int N, Boolean[] cache){
        if(N==1){
            return false;
        }
        if(cache[N]!=null){
            return cache[N];
        }
        
        for(int x=1;x<=N/2;x++){
            if(N%x==0){
                if(!canWin(N-x,cache)){
                    cache[N]=true;
                    return true;
                }
            }
        }
        
        cache[N]=false;
        return false;
    }
    public boolean divisorGame(int N) {
       Boolean[] cache= new Boolean[N+1];
        return canWin(N,cache);
    }
}
