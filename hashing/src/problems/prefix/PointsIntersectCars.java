package problems.prefix;
import java.util.*;
public class PointsIntersectCars {
    // brute
    public int numberOfPointsI(List<List<Integer>> nums) {
        boolean[] covered = new boolean[102]; // or bigger if max > 100
        for (List<Integer> interval : nums) {
            int start = interval.get(0);
            int end = interval.get(1);
            for (int i = start; i <= end; i++) {
                covered[i] = true;
            }
        }
        int count = 0;
        for (boolean b : covered) {
            if (b) count++;
        }
        return count;
    }
    //optimal
    public int numberOfPoints(List<List<Integer>> nums) {
        int []sweep=new int[102];
        int max=Integer.MIN_VALUE;
        for(List<Integer> l:nums){
            int start=l.get(0);
            int end=l.get(1);
            sweep[start]++;
            sweep[end+1]--;
            max=Math.max(max,end);
        }
        int cnt=0;
        for(int i=1;i<=max;i++){
            sweep[i]+=sweep[i-1];
            if(sweep[i]!=0)
                cnt++;

        }
        return cnt;

    }
    public static void main(String[] args) {
        List<List<Integer>> nums=List.of(List.of(3,6),List.of(1,5),List.of(4,7));
        List<List<Integer>> nums2=List.of(List.of(1,3),List.of(5,8));
        System.out.println(new PointsIntersectCars().numberOfPoints(nums));
        System.out.println(new PointsIntersectCars().numberOfPoints(nums2));
    }
}
