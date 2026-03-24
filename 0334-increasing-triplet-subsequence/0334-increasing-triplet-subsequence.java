class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        int third = Integer.MAX_VALUE;

        for (int i = 0 ; i < nums.length ; i++) {
            if (first > nums[i]) {
                first = nums[i];
                continue;
            }
            if (first < nums[i] && second > nums[i]) {
                second = nums[i];
                continue;
            }
            if (first < nums[i] && second < nums[i] && third >= nums[i]) {
                return true;
            }
        }
        return false;
    }
}