class Solution {
    public int majorityElement(int[] nums) {
        int m=0;
        int res=0;
        for(int n:nums){
            if(m==0) res=n;
            m+=n==res?1:-1;
        }
        return res;
    }
}