class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res=strs[0];
        for(int i=0;i<strs.length;i++){
            StringBuilder sb = new StringBuilder();
            int j=0;
            while(j<strs[i].length() && j<res.length() && res.charAt(j)==strs[i].charAt(j)){
                sb.append(res.charAt(j++));
            }
            res=sb.toString();
        }
        return res;
    }
}