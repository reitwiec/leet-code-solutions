class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        if(S == null || S.length() == 0) {
            result.add(S);
            return result;
        }
        
        char[] str = S.toCharArray();
        findPermutations(result, str, 0);
        return result;
    }
    
    public void findPermutations(List<String> result, char[] str, int index){       
        result.add(new String(str));
        
        for(int i = index; i < str.length; i++){
            if(!Character.isDigit(str[i])){
                char temp = str[i];                   
                str[i] = (Character.isLowerCase(str[i])) ? Character.toUpperCase(str[i]) : Character.toLowerCase(str[i]);
                findPermutations(result, str, i + 1);
                str[i] = temp;
            }
        }        
    }
}
