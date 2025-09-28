package medium;

public class RearrangeBySign {
    public int[] rearrangeArrayII(int[] nums) {

        int n=nums.length;
        int pos=0;
        int neg=1;
        int res[]=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]<0){
                res[neg]=nums[i];
                neg+=2;
            }
            else{
                res[pos]=nums[i];
                pos+=2;
            }
        }
        return res;



    }
    public int[] rearrangeArrayI(int[] nums) {

        int n=nums.length;
        int pos[]=new int[n/2];
        int neg[]=new int[n/2];
        int posI=0,negI=0;
        for(int i=0;i<n;i++){
            if(nums[i]>0)
                pos[posI++]=nums[i];
            else
                neg[negI++]=nums[i];
        }
        int ind=0;
        for(int i=0;i<n;i+=2){
            nums[i]=pos[ind];
            nums[i+1]=neg[ind];
            ind++;
        }
        return nums;


    }

}
