class Solution {
   public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list1 = Arrays.stream(nums1)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        List<Integer> list2 = Arrays.stream(nums2)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        list1.addAll(list2);
        Collections.sort(list1);
        int n = list1.size();

    if (n % 2 == 0) {
        return (list1.get(n / 2 - 1) + list1.get(n / 2)) / 2.0;
    }

    return list1.get(n / 2);
}
}

