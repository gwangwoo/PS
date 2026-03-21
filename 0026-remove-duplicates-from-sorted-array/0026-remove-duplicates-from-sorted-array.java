class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> ts = new TreeSet<>();
        int j = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            if (!ts.contains(nums[i])) {
                ts.add(nums[i]);
                swap(nums, i, j);
                j++;
                continue;
            }
        }
        return ts.size();
    }
    public void swap(int[] nums, int src, int target) {
        int temp = nums[src];
        nums[src] = nums[target];
        nums[target] = temp;
    }
}