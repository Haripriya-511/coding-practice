package hard;

import java.util.HashMap;
import java.util.Map;

public class MajorityElementI {
    public int majorityElementI(int[] nums) {
        int n=nums.length;

        int req= n/2;
        for(int i=0;i<n;i++){
            int cnt=0;
            for(int j=0;j<n;j++){
                if(nums[i]==nums[j])
                    cnt++;
            }
            if(cnt>n/2)
                return nums[i];

        }
        return -1;
    }
    public int majorityElementII(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue()>n/2)
                return entry.getKey();
        }
        return -1;
    }
    public int majorityElement(int[] nums) {
        int ele=nums[0];
        int count=1;

        for(int i=1;i<nums.length;i++){
            if(count==0)
            {
                ele=nums[i];
            }
            if(nums[i]==ele){
                count++;
            }
            else{
                count--;
            }

        }
        return ele;
    }
}
