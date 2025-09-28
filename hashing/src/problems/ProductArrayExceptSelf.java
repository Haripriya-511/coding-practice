package problems;

public class ProductArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int res[]=new int[n];
        for(int i=0;i<n;i++){
            int prod=1;
            for(int j=0;j<n;j++){
                if(j!=i)
                    prod*=nums[j];
            }
            res[i]=prod;

        }
        return res;

    }
    public int[] productExceptSelf2(int[] nums){
        int n=nums.length;
        if(n==0) return new int[0];
        if(n==1) return new int[]{nums[0]};
        int res[]=new int[n];

        res[0]=1;
        int suffix=1;
        for(int i=1;i<n;i++){
            res[i]=res[i-1]*nums[i-1];
        }
        for(int i=n-1;i>=0;i--){
          res[i]*=suffix;
          suffix*=nums[i];
        }

        for(int i:res)
            System.out.print(i+" ");
        return res;

    }
    public int[] productExceptSelf3(int[] nums){
        int zero_count=0;
        int n=nums.length;
        int res[]=new int[n];
        int prod=1;
        for(int i=0;i<n;i++){
            if(nums[i]==0)
                zero_count++;
            if(nums[i]!=0)
                prod*=nums[i];
        }
        if(zero_count>1)
        return new int[n];

        if(zero_count==0){
            for(int i=0;i<n;i++){
                res[i]= prod/nums[i];
            }
            return res;
        }

        for(int i=0;i<n;i++){
            if(nums[i]==0)
                res[i]=prod;
            else
                res[i]=0;
        }
        for(int i:res)
            System.out.print(i+" ");
        return res;
    }

    public static void main(String[] args) {
        int nums[]=new int[]{-1,1,0,-3,3};
        new ProductArrayExceptSelf().productExceptSelf2(nums);
    }
}
