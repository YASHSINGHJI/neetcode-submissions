class Solution {
       public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix[0].length - 1;
        while (start <= matrix.length - 1) {
            if (target <= matrix[start][end]) {
                int st=0;
                int en=end;
                while (st <= en) {
                    int mid = (st + en) / 2;
                    if (matrix[start][mid] == target) {
                        return true;
                    } else if (matrix[start][mid] < target) {
                        st = mid + 1;
                    } else {
                        en = mid - 1;
                    }
                }
            }
            start++;
        }
        return false;

    }
}
