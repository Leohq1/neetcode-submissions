class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        Arrays.fill(result, 0);
        for(int i = 0; i < temperatures.length; i++){
            while(!dq.isEmpty() && temperatures[dq.getFirst()] < temperatures[i]){
                result[dq.getFirst()] = i - dq.removeFirst();
            }
            dq.addFirst(i);
        }
        return result;
    }
}