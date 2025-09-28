package medium;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> l=new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(nums[i]+nums[j]+nums[k]==0)
                    {
                        List<Integer> ll=new ArrayList<>();
                        ll.add(nums[i]);
                        ll.add(nums[j]);
                        ll.add(nums[k]);
                        Collections.sort(ll);
                        l.add(ll);

                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(l);
        return ans;
    }
    public List<List<Integer>> threeSumII(int[] nums) {
        Set<List<Integer>> l=new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int target=-nums[i];
            Map<Integer,Integer> map=new HashMap<>();
            for(int j=i+1;j<n;j++){
                int complement=target-nums[j];
                if(map.containsKey(complement) )
                {

                    List<Integer> ll = new ArrayList<>();
                    ll.add(nums[i]);
                    ll.add(nums[j]);
                    ll.add(complement);
                    Collections.sort(ll);
                    l.add(ll);
                }
                map.put(nums[j],j);
            }

        }
        List<List<Integer>> ans = new ArrayList<>(l);
        return ans;
    }

    public List<List<Integer>> threeSumIII(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int j=i+1;
            int k=n-1;
            while(j<k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> ll = new ArrayList<>();
                    ll.add(nums[i]);
                    ll.add(nums[j]);
                    ll.add(nums[k]);

                    ans.add(ll);
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(j<k && nums[k]==nums[k+1]) k--;
                }
                else if(sum<0){
                   j++;
                }
                else{
                    k--;
                }
            }

        }

        return ans;
    }
    public static void main(String[] args) {
        int arr[]={2, -2, 0, 3, -3, 5};
        System.out.println(new ThreeSum().threeSumIII(arr));
    }
}
