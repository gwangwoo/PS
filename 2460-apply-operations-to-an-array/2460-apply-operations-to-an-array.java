class Solution {
    public int[] applyOperations(int[] nums) {
        // multiple
        int N = nums.length;
        for (int i = 0 ; i < N-1 ; i++) {
            if (nums[i] == 0) continue;
            if (nums[i] == nums[i+1]) {
                nums[i] *=2;
                nums[i+1] = 0;
            }
        }

        int zeroIdx = 0;
        for (int i = 0 ; i < N ; i++) {
            if (nums[i] != 0) {
                nums[zeroIdx++] = nums[i];
            }
        }
        while (zeroIdx < N) {
            nums[zeroIdx++] = 0;
        }
        return nums;
    }
}