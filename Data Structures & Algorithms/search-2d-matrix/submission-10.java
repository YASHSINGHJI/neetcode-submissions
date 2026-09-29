class Solution {
 public boolean searchMatrix(int[][] matrix, int target) {

        int s = 0, e = matrix[0].length-1;
        while(s<=matrix.length-1) {
            if(target<=matrix[s][matrix[0].length-1]){  
                int start=0;
                int end=e;                         
                while (start <= end) {
                    int mid = (start + end) / 2;
                    if (matrix[s][mid] == target)
                        return true;
                    else if (matrix[s][mid] > target)
                        end = end - 1;
                    else
                        start = start + 1;
                }
            }
            s++;
        }
        return false;
    }
}