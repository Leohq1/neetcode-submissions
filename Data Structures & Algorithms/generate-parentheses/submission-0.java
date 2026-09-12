class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(2 * n, 0, 0, new StringBuilder());
        return result;
    }

    private void backtrack(int target, int size, int par, StringBuilder cur){
        if(size == target){
            if(par == 0){
                result.add(cur.toString());
            }
            return;
        }
        cur.append("(");
        backtrack(target, size + 1, par + 1, cur);
        cur.deleteCharAt(cur.length() - 1);

        if(par > 0){
            cur.append(")");
            backtrack(target, size + 1, par - 1, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}