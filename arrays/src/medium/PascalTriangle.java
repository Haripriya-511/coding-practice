package medium;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public int pascalTriangleI(int r, int c) {
        r=r-1;
        c=c-1;
        int res=1;
        for(int i=c;i>=0;i--){
            res= res*r;
            res=res/i;
            r--;
        }
        return res;
    }

    /**
     * cleaner approach
     * res[0]=1;
     * for(int i=1;i<r;i++)
     * res[i]=(res[i-1]*(r-i))/i;
     */
    public int[] pascalTriangleII(int r) {
        int res[]=new int[r];
        res[0]=1;
        int i=1;

        while(r>1){
            res[i]=res[i-1]*(r-1);
            res[i]/=i;
            i++;
            r--;
        }

        for(int num:res)
            System.out.println(num);
        return res;
    }
    public List<List<Integer>> pascalTriangleIII(int n) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        for(int row=1;row<=n;row++){
            List<Integer> rowList=new ArrayList<>();
            rowList.add(1);
            for(int ind=1;ind<row;ind++){
                int prev= rowList.get(rowList.size()-1);
                rowList.add((prev*(row-ind))/ind);
            }
            pascalTriangle.add(rowList);
        }
        return pascalTriangle;


    }
    public static void main(String[] args) {
        System.out.println(new PascalTriangle().pascalTriangleIII(5));
    }
}
