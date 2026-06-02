class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map <String, List<String>> result = new HashMap<>();

        for (String word: strs) {
        
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if(!result.containsKey(key)) {
                result.put(key, new ArrayList<>()); 
            } 
            result.get(key).add(word);
        } 

        return new ArrayList<>(result.values());
    }
}
