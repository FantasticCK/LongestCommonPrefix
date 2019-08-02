package com.CK;

public class Main {

    public static void main(String[] args) {
//        String[] strs = {"flower", "flow", "flight"};
        String[] strs = {"dog", "racecar", "car"};
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(strs));
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            if (i >= strs[0].length()) break;
            sb.append(strs[0].charAt(i));
            boolean match = true;
            for (String s : strs) {
                if (!s.startsWith(sb.toString())) {
                    match = false;
                    break;
                }
            }
            if (match) i++;
            else {
                if (sb.length() != 0) sb.deleteCharAt(sb.length() - 1);
                break;
            }
        }
        return sb.toString();
    }
}

class Solution2 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String pre = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(pre) != 0)
                pre = pre.substring(0, pre.length() - 1);
            i++;
        }
        return pre;
    }
}