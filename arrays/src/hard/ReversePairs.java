package hard;

public class ReversePairs {

    public int merge(int low,int mid,int high,int[] nums){
        int left=low;
        int temp[]=new int[high-low+1];
        int index=0;
        int right=mid+1;
        int count=0;
        while(left<=mid ){
            while(right<=high && nums[left]> 2L*nums[right])
                right++;
            left++;
            count+=(right-(mid+1));

        }

        left=low;right=mid+1;
        while(left<=mid && right<=high){
            if(nums[left]<=nums[right])
             temp[index++]=nums[left++];
            else temp[index++]=nums[right++];
        }
        while(left<=mid)  temp[index++]=nums[left++];
        while(right<=high) temp[index++]=nums[right++];
        for(int i=low;i<=high;i++){
            nums[i]=temp[i-low];
        }
        return count;
    }
    public int mergeSort(int low,int high,int nums[]){
        if(low>=high) return 0;
        int cnt=0;
        int mid=(low+high)/2;
        cnt+=mergeSort(low, mid, nums);
        cnt+=mergeSort(mid+1,high,nums);
        cnt+=merge(low,mid,high,nums);
        return cnt;

    }
    public int reversePairs(int[] nums) {
        int n=nums.length;
        return mergeSort(0,n-1,nums);
    }

    public static void main(String[] args) {
       int cnt= new ReversePairs().reversePairs(new int[]{6,4,1,2,7});
        System.out.println(cnt);
    }
}
