package hard;
import java.util.*;
public class MajorityElementII {
    public List<Integer> majorityElementTwo(int[] nums) {
        int n=nums.length;
        List<Integer>  l=new ArrayList<>();

        for(int i=0;i<n;i++){

            if(l.size()==0 || l.get(0)!=nums[i]){
                int cnt=0;
                for(int j=0;j<n;j++){
                    if(nums[i]==nums[j])
                        cnt++;
                }
                if(cnt>n/3)
                    l.add(nums[i]);
            }
            if(l.size()==2)
                break;

        }
        return l;
    }
    public List<Integer> majorityElementTwoII(int[] nums) {
        int n=nums.length;
        List<Integer>  l=new ArrayList<>();

        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue()>n/3)
                l.add(entry.getKey());
        }
        return l;

    }
    public List<Integer> majorityElementTwoOPtiamal(int[] nums) {
        int n = nums.length;
        List<Integer> l = new ArrayList<>();
        int cnt1 = 0, cnt2 = 0;
        Integer ele1 = null, ele2 = null;

        for (int num : nums) {
            if (ele1 != null && num == ele1) {
                cnt1++;
            } else if (ele2 != null && num == ele2) {
                cnt2++;
            } else if (cnt1 == 0) {
                ele1 = num;
                cnt1 = 1;
            } else if (cnt2 == 0) {
                ele2 = num;
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        // Second pass: Verify candidates
        cnt1 = 0; cnt2 = 0;
        for (int num : nums) {
            if (ele1 != null && num == ele1) cnt1++;
            if (ele2 != null && num == ele2) cnt2++;
        }

        if (cnt1 > n/3) l.add(ele1);
        if (cnt2 > n/3 ) l.add(ele2);

        return l;
    }
}
