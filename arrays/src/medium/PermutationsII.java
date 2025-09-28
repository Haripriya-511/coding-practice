package medium;
import java.util.*;
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        permutate(result,new ArrayList<>(),nums,new boolean[nums.length]);
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

    public static void main(String[] args) {
        System.out.println(new PermutationsII().permuteUnique(new int[]{1,1,2}));
    }

}
