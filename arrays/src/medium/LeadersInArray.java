package medium;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersInArray {
    public ArrayList<Integer> leaders(int[] nums) {
        ArrayList<Integer> res=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            boolean isGreater=true;
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]<=nums[j])
                {
                    isGreater=false;
                    break;
                }
            }
            if(isGreater)
                res.add(nums[i]);
        }
        return res;

    }
    public ArrayList<Integer> leadersII(int[] nums)
    {
        ArrayList<Integer> res=new ArrayList<>();

        int n=nums.length;
        if(n==0)
            return res;
        res.add(nums[n-1]);
        int greater=nums[n-1];
        for(int i=n-2;i>=0;i--){
            if(nums[i]>greater){
                res.add(nums[i]);
                greater=nums[i];
            }
        }
        Collections.reverse(res);
        return res;

    }
    public static void main(String[] args) {

    }
}
