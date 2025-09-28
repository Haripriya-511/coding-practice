package hard;

public class FindRepeatingMissing {
    public int[] findMissingRepeatingNumbersBetter(int[] nums) {
        int n=nums.length;
        int hash[]=new int[n+1];
        for(int num:nums){
            hash[num]++;
        }
        int res[]=new int[2];
        for(int i=1;i<hash.length;i++){
            if(hash[i]==2){
                res[0]=i;
            }
            if(hash[i]==0) res[1]=i;

            if(res[0]!=0 && res[1]!=0) break;

        }
        return res;

    }
    public int[] findMissingRepeatingNumbersOptimal(int[] nums) {
        int n = nums.length;
        long S = (long)n * (n + 1) / 2;
        long P = (long)n * (n + 1) * (2L * n + 1) / 6;

        long S2 = 0, P2 = 0;
        for (int num : nums) {
            S2 += num;
            P2 += (long) num * num;
        }

        long diff = S2 - S;          // y - x
        long diffSq = P2 - P;        // y^2 - x^2 = (y - x)(y + x)

        long sum = diffSq / diff;    // y + x

        long y = (diff + sum) / 2;   // repeating
        long x = y - diff;           // missing

        return new int[]{(int)y, (int)x};

    }
    public int[] findMissingRepeatingNumbers(int[] nums) {
        int n=nums.length;
        int i=0;
        while(i<n){
            int index=nums[i]-1;
            if(nums[index]!=nums[i]){
                int temp=nums[i];
                nums[i]=nums[index];
                nums[index]=temp;
            }
            else i++;
        }
        int res[]=new int[2];
        for(int j=0;j<n;j++){
            if(nums[j]-1!=j){
                res[0]=nums[j];
                res[1]=j+1;
                return res;
            }
        }
        System.out.println(res[0]+" "+res[1]);
     return res;
    }
    public static void main(String[] args) {
        new FindRepeatingMissing().findMissingRepeatingNumbers(new int[]{6, 5, 7, 1, 8, 6, 4, 3, 2});
    }
}
