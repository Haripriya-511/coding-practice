package problems.prefix;

public class IncrementSubMatricesBy1 {
    //brute
    //O(q * n²)
    public void fillMatrices(int[][] matrices,int r1,int c1,int r2,int c2)
    {
        for(int i=r1;i<=r2;i++){
            for(int j=c1;j<=c2;j++){
                matrices[i][j]+=1;
            }
        }
    }
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int res[][] = new int[n][n];
        int ql = queries.length;
        for (int i = 0; i < ql; i++) {
            fillMatrices(res,queries[i][0],queries[i][1],queries[i][2],queries[i][3]);
        }
        return res;
    }
    //optimal
    //O(n² + q)
    public int[][] rangeAddQueries2(int n, int[][] queries) {
        int res[][] = new int[n][n];
        int prefixMatrix[][]=new int[n][n];
        int ql = queries.length;
        for (int[] q : queries) {
            int r1 = q[0], c1 = q[1], r2 = q[2], c2 = q[3];
            res[r1][c1]++;
            if((c2+1) < n)
                res[r1][c2+1]--;
            if((r2+1)<n)
                res[r2+1][c1]--;
            if((r2+1)<n && (c2+1)<n)
                res[r2+1][c2+1]++;

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                prefixMatrix[i][j] = res[i][j];
                if (i > 0) prefixMatrix[i][j] += prefixMatrix[i - 1][j];
                if (j > 0) prefixMatrix[i][j] += prefixMatrix[i][j - 1];
                if (i > 0 && j > 0) prefixMatrix[i][j] -= prefixMatrix[i - 1][j - 1];
            }
        }

        return prefixMatrix;

    }

    public static void main(String[] args) {
    int[][] mat={{1,1,2,2},{0,0,1,1}};
   int res[][]= new IncrementSubMatricesBy1().rangeAddQueries2(3,mat);
   for(int[] r:res) {
       for (int i : r) {
           System.out.print(i + " ");
       }
       System.out.println();
   }

    }
}
