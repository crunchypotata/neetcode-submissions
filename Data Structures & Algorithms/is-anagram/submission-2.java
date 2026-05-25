class Solution {
    public boolean isAnagram(String s, String t) {

        int[] count = new int[26];

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a'; 
            count[index]++;
        }

        for (int j = 0; j < t.length(); j++) {
            char c = t.charAt(j);
            int index = c - 'a';
            if(count[index] == 0) {
                return false;
            }
            count[index]--;
        }

        return true;

    }
}
