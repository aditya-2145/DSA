class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        int max = 0;
        for (int j = 0; j < n; j++) {
            while (i <= j && nums[j] > (long) nums[i] * k) {
                i++;
            }
            max = Math.max(max, j - i + 1);
        }
        return n - max;
    }
}