class Solution {    
public int findMin(int[] nums) {
    int start = 0;
    int end = nums.length - 1;

    while (start < end) {
        int mid = start + (end - start) / 2;

        // If mid element is greater than the last element, the minimum is in the right half
        if (nums[mid] > nums[end]) {
            start = mid + 1;
        } 
        // If mid element is less than or equal to the last element, the minimum is in the left half
        else {
            end = mid; // Include mid in the search as it might be the minimum
        }
    }

    // The start pointer will point to the minimum element
    return nums[start];
}

}
