package medium;

public class Sort012 {
    public void sortZeroOneTwoII(int[] nums) {
        int n=nums.length;
        int low=0;
        int mid=0;
        int high=n-1;
        while(mid<=high){
            if(nums[mid]==0){
                int temp=nums[mid];
                nums[mid]=nums[low];
                nums[low]=temp;
                low++;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else{
                int temp=nums[high];
                nums[high]=nums[mid];
                nums[mid]=temp;
                high--;
            }
        }

    }
    public void sortZeroOneTwoI(int[] nums) {
        int zero=0;
        int one=0;
        int two=0;
        for(int num:nums){
            if(num==0) zero++;
            else if(num==1) one++;
            else two++;
        }
        int ind=0;
        while(zero>0){
            nums[ind++]=0;
            zero--;
        }
        while(one>0){
            nums[ind++]=1;
            one--;
        }
        while(two>0){
            nums[ind++]=2;
            two--;
        }
    }
}
