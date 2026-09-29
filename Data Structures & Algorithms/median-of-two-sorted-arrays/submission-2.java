class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] small = nums1.length <= nums2.length ? nums1 : nums2;
        int[] large = nums1.length > nums2.length ? nums1 : nums2;

        int total = nums1.length + nums2.length;

        int l = 0;
        int r = small.length;

        while (l <= r) {

            // Number of elements taken from small
            int i = (l + r) / 2;

            // Number of elements taken from large
            int j = (total + 1) / 2 - i;

            int small_left =
                    i > 0 ? small[i - 1] : Integer.MIN_VALUE;

            int small_right =
                    i < small.length ? small[i] : Integer.MAX_VALUE;

            int large_left =
                    j > 0 ? large[j - 1] : Integer.MIN_VALUE;

            int large_right =
                    j < large.length ? large[j] : Integer.MAX_VALUE;

            // Correct partition
            if (small_left <= large_right &&
                large_left <= small_right) {

                if (total % 2 == 1) {

                    return Math.max(small_left, large_left);

                } else {

                    return (Math.max(small_left, large_left)
                            + Math.min(small_right, large_right)) / 2.0;
                }

            } else if (small_left > large_right) {

                // Too many elements taken from small
                r = i - 1;

            } else {

                // Too few elements taken from small
                l = i + 1;
            }
        }

        return 0.0;
    }
}