package logicbuilding;

import java.util.*;

public class RemoveDuplicatesSortedArray {
    public int removeDuplicateBruute(int []nums){
        int n=nums.length;
        Set<Integer> set=new LinkedHashSet<>();
        for(int num:nums)
            set.add(num);
        Iterator<Integer> iterator = set.iterator();
        int i=0;
        while (iterator.hasNext()) {
        nums[i++]=iterator.next();
        }
        return i;

    }
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int i=1,ind=0;
        while(i<n){
        if(nums[i]!=nums[ind]){
            ind++;
            nums[ind]=nums[i];
        }
        i++;
        }
        return ind;
    }
    public static void main(String[] args) {
        int arr[]=new int[]{0,0,3,3,5,6};
        int len=new RemoveDuplicatesSortedArray().removeDuplicates(arr);
        for(int i=0;i<len+1;i++)
            System.out.println(arr[i]);
    }
}
