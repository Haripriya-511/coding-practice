package logicbuilding;

public class ZeroesTEnd {
    public void moveZeroes(int[] nums) {

        int n=nums.length;
        int ind=0,i=0;
        while(i<n){
            if(nums[i]!=0){
                nums[ind++]=nums[i];
            }
          i++;
        }
        while(ind<n){
            nums[ind++]=0;
        }
    }
    public void moveZeroesII(int[] nums) {

        int n=nums.length;
        int ind=0,i=0;
        while(i<n){
            if(nums[i]!=0){
               int temp=nums[i];
               nums[i]=nums[ind];
               nums[ind]=temp;
               ind++;
            }
            i++;
        }

    }
public static void main(String[] args) {
    int arr[]={0, 20, 0, -20, 0, 20};
    new ZeroesTEnd().moveZeroes(arr);
    for(int i:arr)
        System.out.println(i);

}
}