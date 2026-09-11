class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i : piles){
            max = Math.max(max, i);
        }
        int min = 1;
        int result = -1;
        while(min <= max){
            int mid = min + (max - min) / 2;
            if(time(piles, mid) <= h){
                result = mid;
                max = mid - 1;
            } else{
                min = mid + 1;
            }
        }
        return result;
    }

    private int time(int[] piles, int speed){
        int sum = 0;
        for(int pile : piles){
            sum += Math.ceil((double)pile / speed);
        }
        return sum;
    }
}
