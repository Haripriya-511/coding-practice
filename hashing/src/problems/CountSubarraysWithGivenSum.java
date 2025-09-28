package problems;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithGivenSum {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                if(sum==k)
                count++;
            }
        }
        return count;
    }
    /*
    🔹 Algorithm (your code does this)

Keep running prefix sum sum.

Maintain a map<sumValue, frequency> → how many times each prefix sum has appeared.

At each index:

Check if (sum - k) exists in the map. If yes, add its frequency to the count.

Add/update current sum in the map.
     */
    public int subarraySumOptimal(int[] nums, int k) {
        int max_count=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];

            if(map.containsKey(sum-k)){
                max_count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return max_count;
    }
    public int subarraySumBetter(int[] nums,int k){
        int n=nums.length;
        int i=0,j=0;
        int sum=0;
        int count=0;
        while(j<n){
            sum += nums[j];

            while (sum > k ) {
                sum -= nums[i];
                i++;
            }

            if (sum == k) {
                count++;
            }
            j++;
        }

        return count;
    }

    public static void main(String[] args) {

    }
}
