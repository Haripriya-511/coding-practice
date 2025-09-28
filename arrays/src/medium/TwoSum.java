package medium;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]+nums[j]==target)
                    return new int[]{i,j};
            }
        }
        return new int[0];
    }
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        int res=-1;
        while(i<j){
            int sum=nums[i]+nums[j];
            if(sum<k ){
                res=Math.max(res,sum);
                i++;
            }//10 15 20 35 40
            else{
                j--;

            }
        }
        return res;
    }
    public int[] twoSumSortedVersion(int nums[],int target){
       int n=nums.length;
       int dummy[][]=new int[n][2];
       for(int i=0;i<nums.length;i++){
           dummy[i][0]=nums[i];
           dummy[i][1]=i;
       }
        Arrays.sort(dummy, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
       int left=0,right=n-1;
       while(left<right){
           int sum=dummy[left][0]+dummy[right][0];
           if(sum==target)
               return new int[]{dummy[left][1],dummy[right][1]};
           else if(sum<target) left++;
           else right--;
       }
       return new int[]{-1,-1};

    }
    public int[] twoSumII(int[] nums, int target) {
       Map<Integer,Integer> map=new HashMap<>();
       int n=nums.length;
       for(int i=0;i<n;i++){
           int complement=target-nums[i];
           if(map.containsKey(complement)){
               return new int[]{map.get(complement),i};
           }
           map.put(nums[i],i);
       }
        return new int[0];
    }

    public static void main(String[] args) {
        int []arr={20, 15, 35, 40, 10};
        int k=50;
        new TwoSum().twoSumLessThanK(arr,k);

    }
}
