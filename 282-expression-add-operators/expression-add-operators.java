
public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) return result;

        backtrack(result, new StringBuilder(), num, target, 0, 0, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder path, String num, int target,
                           int pos, long eval, long multed) {
        if (pos == num.length()) {
            if (eval == target) {
                result.add(path.toString());
            }
            return;
        }

        int len = path.length();  // Save current length for backtracking
        for (int i = pos; i < num.length(); i++) {
            // Skip numbers with leading zero
            if (i != pos && num.charAt(pos) == '0') break;

            String currStr = num.substring(pos, i + 1);
            long curr = Long.parseLong(currStr);

            if (pos == 0) {
                // First number: no operator
                path.append(currStr);
                backtrack(result, path, num, target, i + 1, curr, curr);
                path.setLength(len);  // Backtrack
            } else {
                // +
                path.append('+').append(currStr);
                backtrack(result, path, num, target, i + 1, eval + curr, curr);
                path.setLength(len);

                // -
                path.append('-').append(currStr);
                backtrack(result, path, num, target, i + 1, eval - curr, -curr);
                path.setLength(len);

                // *
                path.append('*').append(currStr);
                backtrack(result, path, num, target, i + 1, eval - multed + multed * curr, multed * curr);
                path.setLength(len);
            }
        }
    }
}
