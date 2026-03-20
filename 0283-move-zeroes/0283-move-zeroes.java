import java.util.*;

class Solution {
    public void moveZeroes(int[] nums) {
        int N = nums.length;
        List<Integer> arl = new ArrayList<>();
        for (int val : nums) {
            if (val == 0) continue;
            arl.add(val);
        }

        for (int i = 0 ; i < nums.length; i++) {
            if (arl.size() <= i) {
                nums[i] = 0;
                continue;
            }
            nums[i] = arl.get(i);
        }

        
    }
    public void swap(int[] nums, int src, int target) {
        int temp = nums[src];
        nums[src] = nums[target];
        nums[target] = temp;
        return;
    }

}