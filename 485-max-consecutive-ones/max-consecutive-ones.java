class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int maxC=0;
        for(int i:nums){
            if(i==1) {
                count+=1;
                maxC=Math.max(maxC,count);
            }
            else{
                count=0;
            }
        }
        return maxC;
    }
}