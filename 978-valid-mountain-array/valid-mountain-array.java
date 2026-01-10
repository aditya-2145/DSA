class Solution {
    public boolean validMountainArray(int[] arr) {
        int i=1;
        int n=arr.length;
        if(n<3) return false;
        while(i<n && arr[i]>arr[i-1]){
            i++;
        }
        if (i == 1 || i == n|| arr[i] == arr[i - 1]) return false;
        while(i<n-1 && arr[i]>arr[i+1]){
            i++;
        }
        return i==n-1;
    }
}