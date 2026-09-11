class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while(left < right - 1){
            mid = (left + right) / 2;
            if(arr[mid] == x){
                left = mid;
                right = mid;
                break;
            }
            if(arr[mid] > x){
                right = mid;
            } else{
                left = mid;
            }
        }
        int close = (Math.abs(x - arr[right]) < Math.abs(x - arr[left])) ? right : left;
        int lo = close;
        int hi = close;
        while(hi - lo + 1 < k){
            if(lo == 0) hi++;
            else if(hi == arr.length - 1) lo--;
            else if(arr[hi + 1] - x < x - arr[lo - 1]) hi++;
            else lo--;
        }
        List<Integer> result =  new ArrayList<>();
        while(lo <= hi){
            result.add(arr[lo]);
            lo++;
        }
        return result;
    }
}