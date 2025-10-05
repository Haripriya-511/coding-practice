package matrices;

public class SetMatrixesZero {

    //better
    public void setZeroesII(int[][] matrix) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        boolean rowCheck[]=new boolean[rows];
        boolean colCheck[]=new boolean[cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j]==0) {
                    rowCheck[i] = true;
                    colCheck[j] =true;
                }
            }
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(rowCheck[i] || colCheck[j])
                    matrix[i][j]=0;
            }
        }


    }
    //optimal
    public void setZeroes(int[][] matrix) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        boolean firstRow=false;
        boolean firstCol=false;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j]==0){
                    if(i==0) firstRow=true;
                    if(j==0) firstCol=true;

                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(firstCol){
            for(int i=0;i<rows;i++){
                matrix[i][0]=0;
            }
        }
        if(firstRow){
            for(int i=0;i<cols;i++){
                matrix[0][i]=0;
            }
        }


    }

    public static void main(String[] args) {

    }
}
