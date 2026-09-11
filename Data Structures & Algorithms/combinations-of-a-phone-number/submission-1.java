class Solution {
    List<String> result = new ArrayList<>();
    static Map<Integer, List<Character>> map = new HashMap<>();
    static {
        char cur = 'a';

        for (int i = 2; i <= 9; i++) {
            map.put(i, new ArrayList<>());

            int count = (i == 7 || i == 9) ? 4 : 3;

            for (int j = 0; j < count; j++) {
                map.get(i).add(cur);
                cur++;
            }
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return result;
        dfs(0, digits, new StringBuilder());
        return result;
    }

    private void dfs(int index, String digits, StringBuilder s){
        if(index == digits.length()){
            result.add(s.toString());
            return;
        }
        int cur = digits.charAt(index) - '0';
        List<Character> options = map.get(cur);
        for(char c : options){
            s.append(c);
            dfs(index + 1, digits, s);
            s.deleteCharAt(s.length() - 1);
        }
    }
}