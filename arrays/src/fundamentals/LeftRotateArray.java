package fundamentals;

public class LeftRotateArray {
    public void reverse(int []nums,int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
    public void rotateArray(int[] nums, int k) {
        int n=nums.length;
        k= k%n;
        reverse(nums,0,n-1);
        reverse(nums,0,n-k-1);
        reverse(nums,n-k,n-1);

    }
    public void rotateArrayBrute(int[] nums, int k) {
        int n=nums.length;
        k= k%n;
        int temp[]=new int[k];
        for(int i=0;i<k;i++){
            temp[i]=nums[i];
        }

        for(int i=k;i<n;i++){
            nums[i-k]=nums[i];
        }

        for(int i=(n-k);i<n;i++){
            nums[i]=temp[i-(n-k)];
        }

    }
    public void rotateArrayByOne(int[] nums) {
        int n=nums.length;
        if(n==0 || n==1)
            return;

        int ele=nums[0];
        for(int i=1;i<n;i++){
            nums[i-1]=nums[i];
        }
        nums[n-1]=ele;
    }
}
