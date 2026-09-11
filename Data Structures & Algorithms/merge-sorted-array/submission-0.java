class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0){
            for(int i = 0; i < nums1.length; i++){
                nums1[i] = nums2[i];
            }
            return;
        }
        int one = m - 1;
        int two = n - 1;
        int end = nums1.length - 1;
        while(one >= 0 && two >= 0){
            if(nums1[one] > nums2[two]){
                nums1[end] = nums1[one];
                end--;
                one--;
            }else{
                nums1[end] = nums2[two];
                end--;
                two--;
            }
        }
        if(one == two) return;
        else if(one == -1){
            while(two >= 0){
                nums1[end] = nums2[two];
                end--;
                two--;
            }
        } else{
            while(one >= 0){
                nums1[end] = nums1[one];
                end--;
                one--;
            }
        }
    }
}