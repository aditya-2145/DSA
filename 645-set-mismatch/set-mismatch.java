class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n=nums.length;
        int oldSum=n*(n+1)/2;
        int newSum=0;
        int doub=0;
        for(int i:nums){
            newSum+=i;
            if(set.contains(i)) doub=i;
            else set.add(i);
        }
        int missing=oldSum-newSum+doub;
        return new int[]{doub,missing};
    }
}