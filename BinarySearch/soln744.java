class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        if(target >= letters[letters.length-1]) return letters[0];
        
        int lo=0,hi=letters.length-1;
        while(lo<hi){
            int mi = (hi+lo)/2;
            
            if(letters[mi]<=target){
                lo=mi+1;
            }else{
                hi=mi;
            }
        }
        
        return letters[lo];
    }
}
