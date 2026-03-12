class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return count(nums,right) - count(nums,left-1);
    }
    public int count(int[] nums, int b){
        int result=0;
        int length=0;

        for(int num : nums){
            if(num<=b)
                length++;
            else
                length = 0;
        
        result += length;
        }
        return result;
    }
}