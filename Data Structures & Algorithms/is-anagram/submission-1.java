class Solution {
    public boolean isAnagram(String s, String t) {

        Map<Character,Integer> counts = new HashMap<>();

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            counts.put(c, counts.getOrDefault(c, 0) +1);
        }

        for (int j = 0; j < t.length(); j++) {
            char c = t.charAt(j);

            if(counts.getOrDefault(c, 0) == 0) {
                return false;
            }

            counts.put(c, counts.getOrDefault(c, 0) -1);
        }

        return true;

    }
}
