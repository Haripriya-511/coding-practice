package problems.prefix;

public class NumMatrix {
    int prefixMatrix[][];
    public NumMatrix(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        prefixMatrix= new int[n][m];
        prefixMatrix[0][0]=matrix[0][0];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0)
                    prefixMatrix[i][j]=matrix[i][j];
               else if(i==0)
                {
                    if(j!=0) {
                        prefixMatrix[i][j] += prefixMatrix[i][j - 1];
                        prefixMatrix[i][j] += matrix[i][j];
                    }

                }
               else if(j==0){
                    if(i!=0) {
                        prefixMatrix[i][j]+= prefixMatrix[i - 1][j];
                        prefixMatrix[i][j]+=matrix[i][j];
                    }

                }
               else
                prefixMatrix[i][j]= (matrix[i][j]+prefixMatrix[i-1][j]+prefixMatrix[i][j-1])-prefixMatrix[i-1][j-1];
            }
        }
    }


    public int sumRegion(int row1, int col1, int row2, int col2) {
int total= prefixMatrix[row2][col2];
if(row1>0)
    total-= prefixMatrix[row1-1][col2];
if(col1>0)
    total-= prefixMatrix[row2][col1-1];
if(row1>0 && col1>0)
    total+= prefixMatrix[row1-1][col1-1];

return total;
    }

    public static void main(String[] args) {
        int[][] matrix={{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
       NumMatrix numMatrix= new NumMatrix(matrix);
       int res=numMatrix.sumRegion(2, 1, 4, 3);
        System.out.println(res);
    }
}
