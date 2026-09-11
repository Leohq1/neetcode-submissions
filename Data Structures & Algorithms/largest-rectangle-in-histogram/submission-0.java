class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>(); // startIndex, height
        int max = 0;
        for(int i = 0; i < heights.length; i++){
            int[] cur = new int[]{i, heights[i]};
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]){
                int[] temp = stack.pop();
                cur[0] = temp[0];
                max = Math.max(max, (i - temp[0]) * temp[1]);
            }
            stack.push(cur);
        }
        while(!stack.isEmpty()){
            int[] temp = stack.pop();
            max = Math.max(max, (heights.length - temp[0]) * temp[1]);
        }
        return max;
    }
}
