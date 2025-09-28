package logicbuilding;

public class MissingNumber {

    public boolean search(int ele,int arr[]){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==ele)
                return true;
        }
        return false;

    }
    public int missingNumberI(int[] nums) {
        for(int i=0;i<=nums.length;i++){
            if(!search(i,nums)) return i;
        }
        return -1;
    }
    public int missingNumberII(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        int nSum=n*(n+1)/2;
        return nSum-sum;
    }
    public int missingNumberIII(int[] nums) {
        int arr[]=new int[nums.length+1];
        for(int i:nums){
            arr[i]=1;
        }
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==0)
                return i;
        }
        return -1;

    }

    // sum

    public int missingNumberIV(int[] nums) {

        int xor=0;
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            xor^=nums[i];
            xor^=i;

        }

        xor=xor^n;
        return xor;


    }
    public void swap(int i,int j,int arr[]){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;

    }
    public int missingNumberV(int[] nums) {

        int n=nums.length;
        for(int i=0;i<n;i++){
            while (nums[i] != n && nums[i] != i) {
                swap(i, nums[i], nums);
            }
        }
        for(int i=0;i<n;i++){
            if(i!=nums[i])
                return i;
        }
        return n;


    }
    public static void main(String[] args) {

    }
}
