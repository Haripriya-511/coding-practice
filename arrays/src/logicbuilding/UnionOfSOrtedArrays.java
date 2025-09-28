package logicbuilding;

import java.util.*;

public class UnionOfSOrtedArrays {
    public int[] unionArrayI(int[] nums1, int[] nums2) {
        Set<Integer> set=new TreeSet<>();
        for(int i:nums1)
            set.add(i);
        for(int i:nums2)
            set.add(i);
        int[] res = new int[set.size()];
        int ind=0;
        for (int i:set)
            res[ind++] = i;
        return res;
    }
    public int[] unionArray(int[] nums1, int[] nums2) {
        List<Integer> l = new ArrayList<>();
        int n1 = nums1.length, n2 = nums2.length;
        int i = 0, j = 0;

        while (i < n1 && j < n2) {
            int val;
            if (nums1[i] < nums2[j]) {
                val = nums1[i++];
            } else if (nums2[j] < nums1[i]) {
                val = nums2[j++];
            } else { // both equal
                val = nums1[i];
                i++;
                j++;
            }
            // add only if different from last added
            if (l.isEmpty() || l.get(l.size() - 1) != val) {
                l.add(val);
            }
        }

        while (i < n1) {
            if (l.isEmpty() || l.get(l.size() - 1) != nums1[i]) {
                l.add(nums1[i]);
            }
            i++;
        }

        while (j < n2) {
            if (l.isEmpty() || l.get(l.size() - 1) != nums2[j]) {
                l.add(nums2[j]);
            }
            j++;
        }

        int[] res = new int[l.size()];
        for (int ind = 0; ind < l.size(); ind++) res[ind] = l.get(ind);
        return res;
    }
    public static void main(String[] args) {
      int[]  nums1 = {1,1,8,11,12,12,14,15,17,21,23,25,29,34,35,39,40,42,42,43,45};
      int []nums2 = {4,8,22,25,29};
      int res[]=new UnionOfSOrtedArrays().unionArray(nums1,nums2);
      for(int i:res)
          System.out.println(i);
    }
}
