class Solution {
    public int maxArea(int[] heights) {
        int max = -1;
        int left = 0;
        int right = heights.length - 1;
        while(left < right){
            int cur = Math.min(heights[left], heights[right]) * (right - left);
            if(cur > max){
                max = cur;
            }
            if(heights[left] < heights[right]){
                left++;
            } else if(heights[left] > heights[right]){
                right--;
            } else{
                left++;
                right--;
            }
        }
        return max;
    }
}
