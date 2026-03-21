class Solution {
    public int[] productExceptSelf(int[] nums) {
        long totalSum = 1l;
        boolean haveZero = false;

        int zeroCnt = 0;
        for (int val : nums) {
            if (val == 0) zeroCnt++;
        }
        if (zeroCnt >= 2) {
            int N = nums.length;
            return new int[N];
        }
        for (int val : nums) {
            if (val == 0) {
                haveZero = true;
                continue;
            }
            totalSum *= val;
        }
        int[] answer = new int[nums.length];
        if (haveZero) {
            for (int i = 0 ; i < nums.length ; i++) {
                if (nums[i] == 0) {
                    answer[i] = (int)totalSum;
                }
            }
        } else {
            for (int i = 0 ; i < nums.length; i++) {
                answer[i] = (int)(totalSum / nums[i]);
            }
        }
        return answer;
    }
}