class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < s.length() ; i++) {
            char ch = s.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                sb.append(ch);
            }
        }
        boolean flag = true;
        int N = sb.length();
        for (int i = 0 ; i < N / 2 ; i++) {
            if (sb.charAt(i) != sb.charAt(N-i-1)) {
                flag = false;
                break;
            }
        }

        return flag;
    }
}