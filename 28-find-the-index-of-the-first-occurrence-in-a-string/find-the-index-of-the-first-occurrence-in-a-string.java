class Solution {
    public int strStr(String a, String b) {
        if(b.length()==0) return 0;
        for(int i=0;i<=a.length()-b.length();i++){
            int j=0;
            while(j<b.length() && a.charAt(i+j)==b.charAt(j)) j++;
            if(j==b.length()) return i;
        }
        return -1;
    }
}