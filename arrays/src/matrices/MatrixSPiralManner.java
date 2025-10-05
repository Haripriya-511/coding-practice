package matrices;

import java.util.*;
public class MatrixSPiralManner {
    public List<Integer> spiralOrder(int[][] matrix)
    {
        List<Integer> l=new ArrayList<>();
        int top=0;
        int bottom=matrix.length-1;
        int left=0;
        int right=matrix[0].length-1;

        while(top<=bottom && left<=right) {
            for (int i = left; i <= right; i++) {

                l.add(matrix[top][i]);

            }
            top++;
            for (int i = top; i <= bottom; i++) {
                l.add(matrix[i][right]);

            }
            right--;
            if(top<=bottom) {
                for (int i = right; i >= left; i--) {
                    l.add(matrix[bottom][i]);

                }
            }
            bottom--;
            if(left<=right) {
                for (int i = bottom; i >= top; i--) {
                    l.add(matrix[i][left]);

                }
            }
            left++;
        }

        return l;
    }
    public static void main(String[] args) {
        int[][] matrix={{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        int[][] matrix1={{1,2,3,4},{5,6,7,8}};
        int[][] matrix2={{1,2},{3,4,},{5,6},{7,8}};
        int matrix3[][]={{1,2,3,4}};
        int matrix4[][]={{1},{2},{3},{4}};

        System.out.println(new MatrixSPiralManner().spiralOrder(matrix));
        System.out.println(new MatrixSPiralManner().spiralOrder(matrix1));
        System.out.println(new MatrixSPiralManner().spiralOrder(matrix2));
        System.out.println(new MatrixSPiralManner().spiralOrder(matrix3));
        System.out.println(new MatrixSPiralManner().spiralOrder(matrix4));
    }
}
