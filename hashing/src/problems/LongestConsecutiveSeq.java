package problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSeq {
  public  boolean linearSearch(int []nums,int target){
        for(int num:nums){
            if(target==num) return true;
        }
        return false;

    }
    // brute
    public int longestConsecutive1(int nums[]){
        int max_len=1;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int count=1;
            int ele=nums[i];
            while(linearSearch(nums,ele+1)){
                ele++;
                count++;
            }
            max_len=Math.max(max_len,count);

        }
        return max_len;
    }
    // better
    public int longestConsecutive2(int[] nums) {
        Arrays.sort(nums);
                int long_len=1;
        int count=1;
        int n=nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1])
                continue;

           else if(nums[i]==(nums[i-1]+1)){
                count++;
                long_len=Math.max(long_len,count);
            }
            else{
                count=1;
            }

        }
        return long_len;


    }
    // optimal
    public int longestConsecutive3(int[] a){
        int n = a.length;
        if (n == 0)
            return 0;
        int longest=1;
        Set<Integer> set=new HashSet<>();
        for(int i:a)
            set.add(i);
        for(int it:set){
            if(!set.contains(it-1)){
                int cnt=1;
                while(set.contains(it+1)){
                    cnt++;
                    it++;
                }
                longest=Math.max(longest,cnt);
            }
        }
        return longest;


    }
    public static void main(String[] args) {
        int[] nums={17,12,-8,-11,14,-19,9,-4,-11,-12,-8,5,15,14,9,-19,12,5,0,18,13,-1,3,19,16,-13,-11,9};
        System.out.println(new LongestConsecutiveSeq().longestConsecutive3(nums));
    }
}
