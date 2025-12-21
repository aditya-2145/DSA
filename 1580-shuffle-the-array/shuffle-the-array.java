class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans=new int[nums.length];
        int a=0;
        int b=1;
        for(int i=0;i<n;i++){
            ans[a]=nums[i];
            ans[b]=nums[n+i];
            a+=2;
            b+=2;
        }
        return ans;
    }
}