class Solution {
   public boolean searchMatrix(int[][] nums, int target) {
        int row = 0;
        int col = nums[0].length - 1;
        while (row < nums.length && col >= 0) {
            if (nums[row][col] == target) {
                return true;
            } else if (nums[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
        
      
       
    }


}
