class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> m1 = new HashMap<>();
        HashMap<Integer,Integer> m2 = new HashMap<>();

        
        for(Integer i:nums1){
            if(m1.containsKey(i)){
                m1.put(i,m1.get(i)+1);
            }else{
                m1.put(i,1);
            }
        }
        
        for(Integer i:nums2){
            if(m1.containsKey(i) && m1.get(i)>0){
                if(m2.containsKey(i)){
                    m2.put(i,m2.get(i)+1);
                }else{
                    m2.put(i,1);
                }
                m1.put(i,m1.get(i)-1);
            }
        }
        ArrayList<Integer> ans1 = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : m2.entrySet()){
            for(int i=0;i<entry.getValue();i++){
                ans1.add(entry.getKey());
            }
        }
        
        return ans1.stream().mapToInt(i->i).toArray();
    }
}
