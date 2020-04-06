class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        
        List<List<Integer>> pascal = new ArrayList<>();
        
        if(numRows==0) return pascal;
        
        List<Integer> firstRow= new ArrayList<>();
        firstRow.add(1);
        pascal.add(firstRow);
        
        for(int i=1;i<numRows;i++){
            List<Integer> prevRow = pascal.get(i-1);
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j=1;j<i;j++){
                row.add(prevRow.get(j)+prevRow.get(j-1));
            }
            row.add(1);
            pascal.add(row);
        }
        
        return pascal;
    }
}
