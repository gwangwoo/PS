class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int answer = 0;
        for (String str : patterns) {
            answer = word.contains(str) ? answer + 1 : answer;
        }
        return answer;
    }
}