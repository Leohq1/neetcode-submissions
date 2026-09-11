class Solution {
    public boolean isPalindrome(String s) {
        String clean = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        //System.out.println(clean);
        int front = 0;
        int back = clean.length() - 1;
        while(!(front >= back)){
            if(clean.charAt(front) != clean.charAt(back)){
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
}
