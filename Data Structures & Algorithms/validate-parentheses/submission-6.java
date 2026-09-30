class Solution {

    private static final Map<Character, Character> pairs = Map.of(')', '(', '}', '{', ']','[');
    
    public boolean isValid(String s) {

        if (s.length() % 2 != 0) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();
        

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);


            if (curr == '(' || curr == '{' || curr == '[') {
                stack.push(curr);

            } else if (pairs.containsKey(curr)) {

                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if (top != pairs.get(curr)) {
                    return false;
                }

            } else {
               return false; 
            }

        }

        return stack.isEmpty();
        
    }
}
