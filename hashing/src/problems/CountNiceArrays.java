package problems;

public class CountNiceArrays {
    //brute
    public int numberOfSubarrays(int[] nums, int k) {
        int count=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int odd_count=0;
            for(int j=i;j<n;j++){
                if(nums[j]%2==1)
                    odd_count++;
                if(odd_count==k){
                    count++;
                }
                if(odd_count>k) break;

            }

        }
        return count;
    }
    public int numberOfSubarraysII(int[] nums,int k){
        int count=0;
        int n=nums.length;
        int l=0,r=0;
        int odd_count=0;
        while (r<n){
            if(nums[r]%2==1)
                odd_count++;
                while(odd_count>k){
                    if(nums[l]%2==1){
                        odd_count--;
                    }
                    l++;
                }
            if(odd_count==k){
                count++;
            }
            r++;

        }
        return count;
    }
    public static void main(String[] args) {
        int arr[]={1,1,2,1,1};
        int k=3;
        System.out.println(new CountNiceArrays().numberOfSubarraysII(arr,k));

    }
}
