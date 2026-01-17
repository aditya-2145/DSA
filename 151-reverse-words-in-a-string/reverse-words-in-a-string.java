class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder result = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
            // skip spaces
            while (i >= 0 && s.charAt(i) == ' ') i--;

            int j = i;
            // move till start of word
            while (i >= 0 && s.charAt(i) != ' ') i--;

            // append word
            result.append(s.substring(i + 1, j + 1)).append(" ");
        }

        return result.toString().trim();
    }
}
