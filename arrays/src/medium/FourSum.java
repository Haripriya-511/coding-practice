package medium;
import java.util.*;
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;
            for(int j=i+1;j<n;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int k= j+1;
                int l=n-1;
                while(k<l){
                    int sum=nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum==target){
                        List<Integer> ll = new ArrayList<>();
                        ll.add(nums[i]);
                        ll.add(nums[j]);
                        ll.add(nums[k]);
                        ll.add(nums[l]);
                        ans.add(ll);
                        k++;
                        l--;
                        while(k<l && nums[k]==nums[k-1]) k++;
                        while(k<l && nums[l]==nums[l+1])l--;
                    }
                    else if(sum<target) k++;
                    else l--;
                }
            }
        }
        return ans;
    }
    public List<List<Integer>> fourSumI(int[] nums, int target){
        Set<List<Integer>> ans = new HashSet<>();
       int n=nums.length;
       for(int i=0;i<n;i++){
           for(int j=i+1;j<n;j++){
               int req=target-( nums[i]+nums[j]);
               Set<Integer> set=new HashSet<>();
               for(int k=j+1;k<n;k++){
                   int complement= req-nums[k];
                   if(set.contains(complement)){
                       List<Integer> ll = new ArrayList<>();
                       ll.add(nums[i]);
                       ll.add(nums[j]);
                       ll.add(nums[k]);
                       ll.add(complement);
                       Collections.sort(ll);
                       ans.add(ll);
                   }
                   set.add(nums[k]);
               }
           }
       }

        return new ArrayList<>(ans);
    }
    public static void main(String[] args) {

    }
}

