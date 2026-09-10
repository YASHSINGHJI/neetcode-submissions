class Solution {
    public int maxProduct(int[] nums) {

        int max = nums[0];
        int min = nums[0];
        int answer = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int x = nums[i];

            int oldMax = max;
            int oldMin = min;

            max = Math.max(
                x,
                Math.max(oldMax * x, oldMin * x)
            );

            min = Math.min(
                x,
                Math.min(oldMax * x, oldMin * x)
            );

            answer = Math.max(answer, max);
        }

        return answer;
    }
}