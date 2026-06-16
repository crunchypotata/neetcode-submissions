class Solution {
    public boolean isValid(String s) {

        Deque<Character> temp = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (current == '(' || current == '{' || current == '[') {
                temp.push(current);
                
            } else {

                if (temp.isEmpty()) {
                    return false;
                }

                char top = temp.pop();

                if ((current == ')' && top !='(') || 
                    (current == '}' && top != '{') ||
                    (current == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return temp.isEmpty();   
    }
}
