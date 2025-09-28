package medium;

public class WiggleSort {
    // my own code

    public int max3(int i,int j,int k,int[] nums){
        if(nums[i]>nums[j] && nums[i]>nums[k])
            return i;

        else if(nums[j]>nums[i] && nums[j]>nums[k])
            return j;

        else
            return k;
    }
    public int min3(int i,int j,int k,int[] nums){
        if(nums[i]<nums[j] && nums[i]<nums[k])
            return i;

        else if(nums[j]<nums[i] && nums[j]<nums[k])
            return j;

        else
            return k;
    }
    public void wiggleSort(int[] nums) {
        int n=nums.length;
        if(n==2){
            if(nums[1]<nums[0]){
                int temp=nums[0];
                nums[0]=nums[1];
                nums[1]=temp;
            }
            return;
        }
        for(int i=1;i<n-1;i++){
            if(i%2!=0){
                if(nums[i]>=nums[i-1] && nums[i]>=nums[i+1])
                    continue;
                int ind=max3(i,i-1,i+1,nums);

                int temp=nums[ind];
                nums[ind]=nums[i];
                nums[i]=temp;
            }
            else{
                if(nums[i]<=nums[i-1] && nums[i]<=nums[i+1])
                    continue;
                int ind=min3(i,i-1,i+1,nums);

                int temp=nums[ind];
                nums[ind]=nums[i];
                nums[i]=temp;

            }

        }
    }
    //optimized
    public void wiggleSortOptimal(int[] nums) {
        // Iterate through the array
        for (int i = 0; i < nums.length - 1; i++) {
            /* For even indices, ensure current
            element is less than next;For odd indices,
            ensure current element is greater than next */

            if (((i % 2 == 0) && nums[i] > nums[i + 1]) ||
                    ((i % 2 == 1) && nums[i] < nums[i + 1])) {
               int temp=nums[i];
               nums[i]=nums[i+1];
               nums[i+1]=temp;
            }
        }
    }
    public static void main(String[] args) {
        int arr[]={ 6,6,5,6,3,8};
        new WiggleSort().wiggleSort(arr);


    }
}
