import java.util.ArrayList;
import java.util.List;

public class CyclicSort {
    public int findDuplicate(int[] nums){
        int n=nums.length;
        int i=0;
        while(i<n){
            int correct=nums[i]-1;
            if(nums[i]!=nums[correct])
            {
                int temp=nums[i];
                nums[i]=nums[correct];
                nums[correct]=temp;
            }else i++;

        }
        return nums[n-1];
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> l=new ArrayList<>();
        int i=0;
        int n=nums.length;
        while(i<n){
            int correct=nums[i]-1;
            if(nums[i]!=nums[correct])
            {
                int temp=nums[i];
                nums[i]=nums[correct];
                nums[correct]=temp;
            }
            else i++;
        }
        for(int ind=0;ind<n;ind++){
            if(nums[ind]-1!=(ind))
                l.add(ind+1);
        }
        return l;

    }
    public int missingNumber(int[] nums) {
        int i=0;
        int n=nums.length;
        while(i<n){
            int correct=nums[i];
            if(nums[i]<nums.length && nums[i]!=nums[correct])
                swap(nums,i,correct);
            else i++;
        }
        for(int k=0;k<n;k++){
            if(nums[k]!=k)
                return k;
        }
        return n;
    }
    void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    void sort(int arr[]){
        int n=arr.length;
        int i=0;
        while(i<n){
            int correct= arr[i]-1;
            if(arr[correct]!=arr[i]){
                swap(arr,i,correct);
            }
            else i++;
        }
    }

    public static void main(String[] args) {
        int arr[]=new int[]{3,5,2,1,4};
        new CyclicSort().sort(arr);
        for(int i:arr)
        System.out.println(i);

      int num=  new CyclicSort().missingNumber(new int[]{4,0,1,2});
        System.out.println(num);
        List<Integer> disappearedNumbers = new CyclicSort().findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        System.out.println(disappearedNumbers);
    }
}
