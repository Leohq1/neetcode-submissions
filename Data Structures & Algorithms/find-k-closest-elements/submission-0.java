class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;
        // size = right - left + 1
        while(right - left + 1 > k){
            int aDist = Math.abs(x - arr[left]);
            int bDist = Math.abs(x - arr[right]);
            if(aDist > bDist){
                left++;
            } else{
                right--;
            }
        }
        List<Integer> result = new ArrayList<>();
        while(left <= right){
            result.add(arr[left]);
            left++;
        }
        return result;
    }
}