package fundamentals;

public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnesI(int[] nums) {
        int count=0;
        int max_count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1)
            {
                count++;
                max_count=Math.max(count,max_count);
            }
            else
                count=0;
        }
        return max_count;
    }
    public int findMaxConsecutiveOnesII(int[] nums)
    {
        int countOfZeroes=0;
        int l=0,r=0;
        int n=nums.length;
        int max_count=0;
        while(r<n){

            if(nums[r]==0)
                countOfZeroes++;

            while(countOfZeroes>1){
                if(nums[l]==0)
                {
                    countOfZeroes--;
                }
                l++;
            }

            max_count=Math.max(max_count,r-l+1);
            r++;

        }

        return max_count;

    }
    public int longestOnesIII(int[] nums, int k) {
        //your code goes here
        int zeroCount=0;
        int i=0,j=0;
        int n=nums.length;
        int max_len=0;

        while(j<n){
            if(nums[j]==0){
                zeroCount++;
            }
            while(zeroCount > k){
                if(nums[i]==0)
                    zeroCount--;
                i++;
            }
            max_len=Math.max(max_len,j-i+1);

            j++;
        }
        return max_len;
    }
    public static void main(String[] args) {
        int arr[]={1,1,0,0,1,1,0,0,1,1};
        new FindMaxConsecutiveOnes().findMaxConsecutiveOnesII(arr);
    }
}
