class Solution {
    public boolean isValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> pairs = Map.of(')', '(', '}', '{', ']','[');

        for (char c: s.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);

            } else if (pairs.containsKey(c)) {

                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if (top != pairs.get(c)) {
                    return false;
                }

            } else {
               return false; 
            }

        }

        return stack.isEmpty();
        
    }
}
