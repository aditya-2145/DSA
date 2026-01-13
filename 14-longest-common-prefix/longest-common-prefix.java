class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String res = strs[0];

        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            String cur = strs[i];

            while (j < res.length() && j < cur.length()
                    && res.charAt(j) == cur.charAt(j)) {
                j++;
            }

            res = res.substring(0, j);
            if (res.isEmpty()) return "";
        }
        return res;
    }
}
