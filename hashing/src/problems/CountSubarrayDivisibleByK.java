package problems;
import java.util.*;
public class CountSubarrayDivisibleByK {

        public int subarraySumDivisbleByK(int[] nums, int k) {
            int count=0;
            int sum=0;
            Map<Integer,Integer> map=new HashMap<>();
            map.put(0,1);
            for(int i=0;i<nums.length;i++){
                sum+=nums[i];
                int mod= ((sum%k)+k)%k;
                if(map.containsKey(mod))
                    count+=map.get(mod);

                map.put(mod,map.getOrDefault(mod,0)+1);
            }
            return count;

        }

    public static void main(String[] args) {
        int []arr=new int[]{3, 1, -2, 5, -3, 0, 4};
        int cnt=new CountSubarrayDivisibleByK().subarraySumDivisbleByK(arr,4);
        System.out.println(cnt);
    }
    }

