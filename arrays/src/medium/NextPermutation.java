package medium;
import java.util.*;
public class NextPermutation {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        int[] dummy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(dummy);
        permutate(result,new ArrayList<>(),dummy,new boolean[nums.length]);
        return result;

    }
    public void permutate( List<List<Integer>> result, List<Integer> tempList,int[] nums,boolean[] used){
        if(tempList.size()==nums.length){
            result.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i])
                continue;
            if(i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;
            used[i]=true;
            tempList.add(nums[i]);
            permutate(result,tempList,nums,used);
            used[i]=false;
            tempList.remove(tempList.size()-1);
        }
    }
    public void nextPermutation(int[] nums) {
        List<List<Integer>> lists = permuteUnique(nums);
        List<Integer> target=new ArrayList<>();
        for(int i:nums) target.add(i);

        int idx = -1;
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).equals(target)) {
                idx = i;
                break;
            }
        }

        List<Integer> next = idx==lists.size()-1? lists.get(0): lists.get(idx+1);

        for(int i=0;i<nums.length;i++){
            nums[i]=next.get(i);
        }
    }
    public void reverse(int i,int j,int nums[]){
        while(i<=j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
    public void nextPermutationOptimal(int[] nums) {
        int index=-1;
        int n=nums.length;
        if(n==1) return;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1])
            {
                index=i;
                break;
            }
        }
        if(index==-1){
            reverse(0,n-1,nums); return;
        }

        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]>nums[index]){
                int temp=nums[index];
                nums[index]=nums[i];
                nums[i]=temp;
                break;
            }
        }
        for(int i:nums) System.out.print(i+" ");
        reverse(index+1,n-1,nums);

    }
    public static void main(String[] args) {
        new NextPermutation().nextPermutationOptimal(new int[]{1,3,2});
    }
}
