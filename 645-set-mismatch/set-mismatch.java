class Solution {
    public int[] findErrorNums(int[] nums) {
        int n= nums.length;
        int[] freq = new int[n+1];
        int mis = -1;
        int dou = -1;
        for(int num : nums){
            freq[num]++;
        }
        for(int i=1 ; i<=n ; i++){
            if(freq[i]==2) dou=i;
            if(freq[i]==0) mis=i;
        }
        return new int[]{dou, mis};
    }
}