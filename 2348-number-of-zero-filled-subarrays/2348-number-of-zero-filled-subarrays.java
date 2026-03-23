class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long[] preVal = new long[100001];
        for (int i = 1 ; i <= 100000 ; i++) {
            preVal[i] = preVal[i-1] + (long)i;
        }

        long answer = 0;
        boolean flag = false;
        int zeroCnt = 0;
        for (int val : nums) {
            if (!flag && val == 0) {
                flag = true;
                zeroCnt++;
                continue;
            }
            if (flag && val == 0) {
                zeroCnt++;
                continue;
            }
            if (flag && val != 0) {
                System.out.println(zeroCnt + " " + preVal[zeroCnt]);
                answer += preVal[zeroCnt];
                zeroCnt = 0;
                flag = false;
                continue;
            }
        }
        if (flag && zeroCnt != 0) {
            answer += preVal[zeroCnt];
        }
        return answer;
    }
}