class Solution {
    public int majorityElement(int[] nums) {
        int threshold = nums.length / 2;
        Map<Integer, Integer> hm = new HashMap<>();

        for (int val : nums) {
            if (hm.containsKey(val)) {
                hm.put(val, hm.get(val)+1);
            } else {
                hm.put(val, 1);
            }
        }

        for (int val : nums) {
            if (hm.get(val) > threshold) {
                return val;
            }
        }
        return 0;
    }
}