import java.util.*;

class Solution {
    public void moveZeroes(int[] nums) {
        int N = nums.length;
        int zeroIdx = 0;

        for (int i = 0 ; i < N ; i++) {
            if (nums[i] != 0) {
                nums[zeroIdx++] = nums[i];
            }
        }
        for (int j = zeroIdx ; j < N ; j++) {
            nums[j] = 0;
        }   
    }
}