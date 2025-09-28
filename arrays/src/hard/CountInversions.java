package hard;

import java.util.*;

public class CountInversions {

    public long merge(int low,int mid,int high,int nums[]){
        long cnt=0;
        int left=low;
        int right=mid+1;
        List<Integer> l = new ArrayList<>();
        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
                l.add(nums[left]);
                left++;
            }
            else{
                l.add(nums[right]);
                right++;
                cnt+=(mid-left+1);
            }

        }
        while(left<=mid){
            l.add(nums[left]);
            left++;
        }
        while(right<=high){
            l.add(nums[right]);
            right++;
        }
        for(int i=low;i<=high;i++){
            nums[i]=l.get(i-low);
        }
        return cnt;
    }
    public long mergeSort(int low,int high,int nums[]){
        long cnt=0;
        if(low>=high){
            return 0;
        }
        int mid= (low+high)/2;
        cnt+= mergeSort(low,mid,nums);
        cnt+=mergeSort(mid+1,high,nums);
        cnt+=merge(low,mid,high,nums);
        return cnt;

    }


    public long numberOfInversions(int[] nums) {
        int n=nums.length;
        return  mergeSort(0,n-1,nums);

    }
}
