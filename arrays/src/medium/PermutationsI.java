package medium;
import java.util.*;
public class PermutationsI {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        permutate(result,new ArrayList<>(),nums,new boolean[nums.length]);
        return result;

    }
    public void permutate( List<List<Integer>> result, List<Integer> tempList,int[] nums,boolean[] used) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i=0;i< nums.length;i++) {
            if(used[i])
                continue;
            used[i]=true;
            tempList.add(nums[i]);
            permutate(result, tempList, nums,used);
            used[i]=false;
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        PermutationsI permutationsI=new PermutationsI();
        System.out.println(permutationsI.permute(new int[]{1,2,1}));
    }
}
