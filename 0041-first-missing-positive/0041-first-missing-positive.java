class Solution {
    public int firstMissingPositive(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        if (max < 0) {
            max = 0;
        }
        Set<Integer> hs = new HashSet<>();
        for (int num : nums) {
            hs.add(num);
        }
        for (int i = 1 ; i <= max ; i++) {
            if (hs.contains(i)) continue;
            return i;
        }
        return max+1;
    }
}