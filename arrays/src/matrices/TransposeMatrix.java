package matrices;

public class TransposeMatrix {
    // only if m==n
    public int[][] transpose(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        return matrix;

    }
    // if m!=n
    public int[][] transposeII(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int [][]res=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                res[i][j]=matrix[j][i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int [][]matrix={{1,2,3},{4,5,6}};
        int res[][]=new TransposeMatrix().transposeII(matrix);
        for(int[] i:res)
        {
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
