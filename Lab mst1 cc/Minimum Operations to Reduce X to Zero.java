class Solution {
    public int minOperations(int[] nums, int x) {

        int n = nums.length;

        Map<Integer,Integer> rightMap = new HashMap<>();
        int sum = 0;

        rightMap.put(0,0);

        for(int i=n-1;i>=0;i--){
            sum += nums[i];
            rightMap.put(sum, n-i);
        }

        int ans = Integer.MAX_VALUE;
        sum = 0;

        for(int i=0;i<n;i++){

            if(rightMap.containsKey(x - sum))
                ans = Math.min(ans, i + rightMap.get(x - sum));

            sum += nums[i];

            if(sum == x)
                ans = Math.min(ans, i+1);
        }

        if(rightMap.containsKey(x))
            ans = Math.min(ans, rightMap.get(x));

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}