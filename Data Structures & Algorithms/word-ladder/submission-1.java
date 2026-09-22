class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int length = beginWord.length();
        int result = 1;
        Deque<String> q = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        q.addLast(beginWord);
        seen.add(beginWord);
        while(!q.isEmpty()){
            result++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                String temp = q.removeFirst();
                for(String s : wordList){
                    if(canSwitch(temp, s) && !seen.contains(s)){
                        if(s.equals(endWord)) return result;
                        q.addLast(s);
                        seen.add(s);
                    }
                }
            }
        }
        return 0;
    }


    private boolean canSwitch(String from, String to){
        int dif = 0;
        for(int i = 0; i < from.length(); i++){
            if(from.charAt(i) != to.charAt(i)) dif++;
        }
        return dif == 1;
    }
}
