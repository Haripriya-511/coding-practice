package problems;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoko {
    // brute
    public boolean isValidSudoku(char[][] board) {
        //check rows
        for(int row=0;row<9;row++){
            Set<Character> set=new HashSet<>();
            for(int j=0;j<9;j++){
                if(board[row][j]=='.') continue;
                if(set.contains(board[row][j])) return false;

                set.add(board[row][j]);
            }
        }
        // check cols
        for(int col=0;col<9;col++){
            Set<Character> set=new HashSet<>();
            for(int j=0;j<9;j++){
                if(board[j][col]=='.') continue;
                if(set.contains(board[j][col])) return false;
                set.add(board[j][col]);
            }
        }
       // check 9*9 boards
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                if(!validateBoard(board,i,j)) return false;
            }
        }
        return true;

    }
    private boolean validateBoard(char[][] board,int i,int j){
        Set<Character> set=new HashSet<>();
        for(int row=i;row<i+3;row++){
            for(int col=j;col<j+3;col++){
                if(board[row][col]!='.'){
                    if(set.contains(board[row][col])) return false;
                    set.add(board[row][col]);
                }
            }
        }
        return true;
    }
    //better
    public boolean isValidSudoko1(char [][]board)
    {
        Set<Character>[] rows= new HashSet[9];
        Set<Character>[] cols= new HashSet[9];
        Set<Character>[] boards= new HashSet[9];
        for(int i=0;i<9;i++){
            rows[i]=(new HashSet<>());
            cols[i]=new HashSet<>();
            boards[i]=new HashSet<>();
        }
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                char ch=board[row][col];
                if(ch=='.') continue;
                int boxIndex= (row/3)*3 + (col/3);
                if(rows[row].contains(ch) || cols[col].contains(ch) || boards[boxIndex].contains(ch))
                    return false;
                rows[row].add(ch);
                cols[col].add(ch);
                boards[boxIndex].add(ch);

            }
        }
        return true;
    }

    //optimal
    public boolean isValidateSudoko2(char[][] board){

            int[] rows = new int[9];
            int[] cols = new int[9];
            int[] squares = new int[9];
            for(int row=0;row<9;row++){
                for(int col=0;col<9;col++){
                    char digit= board[row][col];
                    if(digit=='.') continue;
                    int bit= 1<<(digit-'1');
                    int boardIndex= ((row/3)*3) + (col/3);

                    if((rows[row]&bit)>0 || (cols[col]&bit)>0 || (squares[boardIndex]&bit)>0)
                        return false;

                    rows[row] |= bit;
                    cols[col] |= bit;
                    squares[boardIndex] |= bit;
                }
            }
            return true;


    }

    public static void main(String[] args) {

    }


}
