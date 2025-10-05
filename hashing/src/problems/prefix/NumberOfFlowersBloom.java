package problems.prefix;

import java.util.Map;
import java.util.TreeMap;

public class NumberOfFlowersBloom {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n=people.length;
        int res[]=new int[n];
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int i=0;i<flowers.length;i++){
            int start=flowers[i][0];
            int end=flowers[i][1];
            map.put(start,map.getOrDefault(start,0)+1);
            map.put(end+1,map.getOrDefault(end+1,0)-1);
        }
        int ongoing=0;
        for(Map.Entry<Integer,Integer> flower:map.entrySet()){
            int key=flower.getKey();
            int val=flower.getValue();
           ongoing+=val;
            map.put(key,ongoing);
        }
        for(int i=0;i<people.length;i++){
            Integer r=map.floorKey(people[i]);
            if(r!=null)
            res[i]=map.get(r);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] flowers={{1,6},{3,7},{9,12},{4,13}};
        int p[]={2,3,7,11};
        int[][] flowers2={{1,10},{3,3}};
        int[] p2={3,3,2};

       int res[]= new NumberOfFlowersBloom().fullBloomFlowers(flowers,p);
       for(int i:res)
           System.out.print(i+" ");
        System.out.println();
       int []res1=new NumberOfFlowersBloom().fullBloomFlowers(flowers2,p2);
       for (int i:res1)
           System.out.print(i+" ");
    }

}
