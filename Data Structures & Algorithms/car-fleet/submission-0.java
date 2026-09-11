class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        // position -> speed
        int n = position.length;
        for(int i = 0; i < n; i++){
            map.put(position[i], speed[i]);
        }
        double min = -1;
        int result = 0;
        for(Map.Entry<Integer, Integer> entry : map.descendingMap().entrySet()){
            double cur = (double)(target - entry.getKey()) / entry.getValue();
            if(cur > min){
                min = cur;
                result++;
            }
        }
        return result;
    }
}