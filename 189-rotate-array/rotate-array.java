class Solution {
    public void rotate(int[] nums, int k) {
        if(k>nums.length) k%=nums.length;
        rev(nums,0,nums.length-1);
        rev(nums,0,k-1);
        rev(nums,k,nums.length-1);
        

    }
    void rev(int[] nums,int s,int e){
        while(s<e){
            int temp=nums[s];
            nums[s]=nums[e];
            nums[e]=temp;
            s++;
            e--;
        }
    }
}