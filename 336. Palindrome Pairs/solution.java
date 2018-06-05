class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        
        Map <String,Integer> memo = new HashMap<String,Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        for(int i = 0;i < words.length;i++) memo.put(words[i],i); 
        
        for(String s : words){
            for(int threshold = 0;threshold <= s.length(); threshold++){
                String left = s.substring(0,threshold);
                String right = s.substring(threshold,s.length());
                String reverse = "";
                
                if(isPal(left)){
                    reverse = new StringBuilder(right).reverse().toString();
                    if(memo.get(reverse) != null){
                        int l = memo.get(reverse);
                        int r = memo.get(s);
                        List <Integer> buffer = Arrays.asList(l,r);
                        if (l != r && !result.contains(buffer))      result.add(buffer);
                    }
                }
                
                if(isPal(right)){
                    reverse = new StringBuilder(left).reverse().toString();
                    if(memo.get(reverse) != null){
                        int r = memo.get(reverse);
                        int l = memo.get(s);
                        List <Integer> buffer = Arrays.asList(l,r);
                        if (l != r && !result.contains(buffer))      result.add(buffer);
                    }
                }
            }
        }
        
        return result;
        
    }
    
    public boolean isPal(String input){
        if(input.length() == 0) return true;
        
        for(int i = 0;i <= input.length() / 2;i++){
            if(input.charAt(i) != input.charAt(input.length()-1 - i))
                return false;
        }
        return true;
    }
}