class Solution {
    public int trap(int[] height) {
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        while(left < right){
            if(height[left] > leftMax){
                leftMax = height[left];
            }
            if(height[right] > rightMax){
                rightMax = height[right];
            }
            if(leftMax > rightMax){
                int water = rightMax - height[right];
                if(water > 0){
                    result += water;
                }
                right--;
            } else /*if(leftMax < rightMax)*/{
                int water = leftMax - height[left];
                if(water > 0){
                    result += water;
                }
                left++;
            // } else{
            //     int waterL = leftMax - height[left];
            //     int waterR = rightMax - height[right];
            //     if(waterL > 0){
            //         result += waterL;
            //     }
            //     if(waterR > 0){
            //         result += waterR;
            //     }
            //     left++;
            //     right--;
            }
        }
        return result;
    }
}
