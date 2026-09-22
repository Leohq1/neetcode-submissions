class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int length = beginWord.length();
        int result = 1;
        Deque<String> q = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        Set<String> list = new HashSet<>(wordList);
        q.addLast(beginWord);
        seen.add(beginWord);
        while(!q.isEmpty()){
            result++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                String temp = q.removeFirst();
                StringBuilder sb = new StringBuilder(temp);
                for(int c = 0; c < temp.length(); c++){
                    char dummy = sb.charAt(c);
                    for(char l = 'a'; l <= 'z'; l++){
                        sb.setCharAt(c, l);
                        String cur = sb.toString();
                        if(!seen.contains(cur) && list.contains(cur)){
                            if(cur.equals(endWord)) return result;
                            q.addLast(cur);
                            seen.add(cur);
                        }
                    }
                    sb.setCharAt(c, dummy);
                }
            }
        }
        return 0;
    }


}
