package medium;

public class KadaneAlgorihtm {
    public int maxSubArrayI(int[] nums) {
        int maxSum=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
           int sum=0;
           for(int j=i;j<nums.length;j++){
               sum+=nums[j];
               maxSum=Math.max(maxSum,sum);
           }


        }
        return maxSum;
    }
    public int maxSubArrayII(int[] nums) {
        int currSum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            currSum+=nums[i];


            maxSum=Math.max(currSum,maxSum);
            if(currSum<0)
                currSum=0;


        }
        return maxSum;
    }
    public void maxSubArrayIII(int[] nums) {
        int currSum=0;
        int maxSum=Integer.MIN_VALUE;
        int start=-1;int end=-1;
        int tempStart=0;
        for(int i=0;i<nums.length;i++){
            currSum+=nums[i];

            if(currSum> maxSum){
            maxSum=currSum;
            start=tempStart;
            end=i;
            }

            if(currSum<0)
            {
                currSum=0;
                tempStart=i+1;
            }



        }

    }
}
