class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Make nums1 the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int total = nums1.length + nums2.length;
        int half = (total + 1) / 2;

        int left = 0;
        int right = nums1.length;

        while (left <= right) {
            int partition1 = (left + right) / 2;
            int partition2 = half - partition1;

            int left1 = partition1 == 0
                    ? Integer.MIN_VALUE
                    : nums1[partition1 - 1];

            int right1 = partition1 == nums1.length
                    ? Integer.MAX_VALUE
                    : nums1[partition1];

            int left2 = partition2 == 0
                    ? Integer.MIN_VALUE
                    : nums2[partition2 - 1];

            int right2 = partition2 == nums2.length
                    ? Integer.MAX_VALUE
                    : nums2[partition2];

            if (left1 <= right2 && left2 <= right1) {
                if (total % 2 == 1) {
                    return Math.max(left1, left2);
                }

                return ((double) Math.max(left1, left2)
                        + Math.min(right1, right2)) / 2;
            }

            if (left1 > right2) {
                right = partition1 - 1;
            } else {
                left = partition1 + 1;
            }
        }

        return -1;
    }
}