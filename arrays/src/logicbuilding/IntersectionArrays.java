package logicbuilding;

import java.util.*;

public class IntersectionArrays {
    public int[] intersectionArrayI(int[] nums1, int[] nums2)
    {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums1) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }


        List<Integer> resultList = new ArrayList<>();
        for (int num : nums2) {
            if (freqMap.containsKey(num) && freqMap.get(num) > 0) {
                resultList.add(num);
                freqMap.put(num, freqMap.get(num) - 1); // decrease frequency
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
    public int[] intersectionArray(int[] nums1, int[] nums2)
    {

        List<Integer> l=new ArrayList<>();
        int n1=nums1.length;
        int n2=nums2.length;
        int i=0,j=0;
        while(i<n1 && j<n2){
            if(nums1[i]<nums2[j]){
                i++;
            }
            else if (nums2[j]<nums1[i]){
                j++;
            }
            else{
                l.add(nums1[i]);
                i++;
                j++;

            }

        }

        int res[]=new int[l.size()];
        for(int ind=0;ind<l.size();ind++)
            res[ind]=l.get(ind);
        return res;
    }
}
