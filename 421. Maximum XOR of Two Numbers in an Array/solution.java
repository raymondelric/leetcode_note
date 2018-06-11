class Solution {
    public int findMaximumXOR(int[] nums) {
        
        Set <Integer> memo = new HashSet<Integer>();
        int max = 0;
        int mask = 0;
        
        for(int k = 31;k >= 0;k--){
            
            mask = mask | (1 << k);
            int tmp = max | (1 << k);
            
            for(int i = 0;i < nums.length;i++)
                memo.add(nums[i] & mask); // prefix
            
            for(int i = 0;i < nums.length;i++){
                if(memo.contains(tmp ^ (nums[i] & mask))){
                    max = tmp;
                    break;   
                }
            }
            memo.clear();            
        }
        return max;
    }
}