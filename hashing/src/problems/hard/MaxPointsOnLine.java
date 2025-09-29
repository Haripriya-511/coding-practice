package problems.hard;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnLine {
    //brute
    public int maxPoints(int[][] points) {
        int n=points.length;
        if(n==1) return 1;
        int max_points=0;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int count=2;
                int dy=(points[j][1]-points[i][1]);
                int dx=( points[j][0]-points[i][0]);
                for(int k=j+1;k<n;k++){
                    int inner_dy=(points[k][1]-points[i][1]);
                    int inner_dx=(points[k][0]-points[i][0]);
                    if((inner_dy * dx) == (dy * inner_dx)) {
                         count++;
                    }
                }
                max_points=Math.max(count,max_points);
            }

        }
        return max_points;

}
public int maxPointsOptimal(int[][] points){
        int n=points.length;
        if(n<=2) return n;
        int result=0;
        for(int i=0;i<n;i++){
            Map<String,Integer> map=new HashMap<>();
            int longest=0;
            for(int j=i+1;j<n;j++){

                int dx= points[j][0]-points[i][0];
                int dy=points[j][1]-points[i][1];
                int g=gcd(dx,dy);
                dx/=g;
                dy/=g;
                if(dx<0){
                    dx=-dx;
                    dy=-dy;
                }
                else if(dx==0)
                    dy=1;

                else if(dy==0) dx=1;

                String slope= dx+","+dy;
                map.put(slope,map.getOrDefault(slope,0)+1);
                longest=Math.max(longest,map.get(slope));
            }
            result=Math.max(result,longest+1);
        }
        return result;
}
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    public static void main(String[] args) {
        int[][] input={{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        int [][]input1={{1,1},{2,2},{3,3}};
       System.out.println(new MaxPointsOnLine().maxPointsOptimal(input));
        System.out.println(new MaxPointsOnLine().maxPointsOptimal(input1));
    }
}
