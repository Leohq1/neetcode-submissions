class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for(String token : tokens){
            if(token.equals("+")) stack.addFirst(stack.removeFirst() + stack.removeFirst());
            else if(token.equals("-")) stack.addFirst(-1 * stack.removeFirst() + stack.removeFirst());
            else if(token.equals("*")) stack.addFirst(stack.removeFirst() * stack.removeFirst());
            else if(token.equals("/")){
                int d = stack.removeFirst();
                stack.addFirst(stack.removeFirst() / d);
            } else{
                stack.addFirst(Integer.parseInt(token));
            }
        }
        return stack.removeFirst();
    }
}
