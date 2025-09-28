package problems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySumK {
    //Brute
    public int longestSubarray1(int[] nums, int k) {
        int n=nums.length;
        int max_len=0;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                if(sum==k){
                    max_len=Math.max(j-i+1,max_len);
                }
            }
        }
        return max_len;
    }
    // if only positives Sliding window
    public int longestSubarray2(int nums[],int k){
        int n=nums.length;
        int i=0,j=0;
        int sum=0;
        int max_len=0;
        while(j<n){
            sum += nums[j];

            while (sum > k ) {
                sum -= nums[i];
                i++;
            }

            if (sum == k) {
                max_len = Math.max(max_len, j - i + 1);
            }
            j++;
        }

        return max_len;

    }
    //optimal
    public int longestSubarray(int[] nums, int k) {
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int max_len=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(sum==k){
                max_len=i+1;
            }
            if(map.containsKey(sum-k)){
                max_len=Math.max(max_len,i-map.get(sum-k));
            }
            if(!map.containsKey(sum))
                map.put(sum,i);

        }
        return max_len;
    }

    public static void main(String[] args) {
       int res= new LongestSubArraySumK().longestSubarray2(new int[]{4, -1, 2, -2, 1},3);
        System.out.println(res);
    }
}
