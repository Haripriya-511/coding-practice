package matrices;


import java.util.*;

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int sum=(i+j);
                map.computeIfAbsent(sum,k->new ArrayList<>()).add(mat[i][j]);
            }
        }
        int res[]=new int[m*n];
        int ind=0;
        for(Map.Entry<Integer,List<Integer>> entry:map.entrySet()){
            int key=entry.getKey();
            List<Integer> l= entry.getValue();
            if(key%2==0){
                Collections.reverse(l);
            }
            for(int i:l)
                res[ind++]=i;
        }
        return res;
    }
    //optimal
    public int[] findDiagonalOrderI(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int res[]=new int[m*n];
        int ind=0;
        for(int d=0;d<(m+n-1);d++)
        {
            if(d%2==0){
                // right-up
                int r=(d<m)?d:m-1;
                int c=d-r;
                while(r>=0 && c<n){
                    res[ind++]=mat[r--][c++];
                }

            }
            else{
                //down left
                int c= (d<n)?d:n-1;
                int r=d-c;
                while(c>=0 && r<m){
                    res[ind++]=mat[r++][c--];
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        new DiagonalTraverse().findDiagonalOrder(matrix);
    }
}
