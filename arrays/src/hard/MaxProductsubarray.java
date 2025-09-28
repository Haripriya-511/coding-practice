package hard;

public class MaxProductsubarray {
    public int maxProduct(int[] nums){
        int prod=Integer.MIN_VALUE;
        int  n=nums.length;
        for(int i=0;i<n;i++){
            int currProd=1;
            for(int j=i;j<n;j++){
                currProd*=nums[j];
                prod=Math.max(prod,currProd);

            }
        }
        return prod;
    }
    public int maxProductOptimal(int[] nums) {

        int  n=nums.length;
        int res=nums[0];
        int leftProd=1;
        int rightProd=1;
        for(int i=0;i<n;i++){
            leftProd= leftProd==0?1:leftProd;
            rightProd= rightProd==0?1:rightProd;
            leftProd*=nums[i];
            rightProd*=nums[n-i-1];

            res=Math.max(res,Math.max(leftProd,rightProd));
        }
        return res;

    }

    public static void main(String[] args) {
        new MaxProductsubarray().maxProductOptimal(new int[]{1,2,3,4,5});
        new MaxProductsubarray().maxProduct(new int[]{1,2,3,4,5});
    }
}
