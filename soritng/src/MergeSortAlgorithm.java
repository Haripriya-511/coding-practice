import java.util.*;
public class MergeSortAlgorithm {
    public void merge(int low,int mid,int high,int nums[]){
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



    }
    public void mergeSortHelper(int low,int high,int nums[]){
        if(low>=high){
            return;
        }
        int mid= (low+high)/2;
        mergeSortHelper(low,mid,nums);
        mergeSortHelper(mid+1,high,nums);
        merge(low,mid,high,nums);

    }

    public static void main(String[] args) {
        int nums[] = {5, 2, 9, 1, 6, 3};
        int n = nums.length;
        new MergeSortAlgorithm().mergeSortHelper(0,n-1,nums);
        for(int i:nums){
            System.out.print(i+" ");
        }
    }
}
