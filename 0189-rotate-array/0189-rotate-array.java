class Solution {
    public void rotate(int[] nums, int k) {
        int N = nums.length;
        k %= N;
        int[] tempArr = new int[N];
        for (int i = 0 ; i < N ; i++) {
            tempArr[i] = nums[i];
        }
        for (int i = 0 ; i < N ; i++) {
            nums[i] = tempArr[(i + (N - k)) % N];
        }
    }
}