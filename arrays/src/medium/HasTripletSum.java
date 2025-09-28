package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HasTripletSum {
    public boolean hasTripletSum(int nums[], int target) {
        // code Here
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n;i++){

            int j= i+1;
            int k= n-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==target)
                    return true;
                if(sum<target)
                    j++;
                else
                    k--;
            }
        }
        return false;

    }
    public boolean hasTripletSumII(int nums[], int target) {
        // code Here

        int n=nums.length;
        for(int i=0;i<n;i++){
            int required= target-nums[i];
            // need two numbers whose sum is equa to required
            Set<Integer> set=new HashSet<>();
            for(int j=i+1;j<n;j++){
                int complement=required-nums[j];
                if(set.contains(complement)){
                    return true;
                }
                set.add(nums[j]);
            }
        }
        return false;

    }
}
