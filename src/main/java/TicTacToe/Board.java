package TicTacToe;

/*
Board ka task hai
- set the  symbol
- validate moves.
 */
public class Board {
    int size;
    listOfSymbols[][] board;
    int [] rows;
    int [] columns;
    int mainDia;
    int leftDia;
    Board( int size){
        this.size = size;
        board=new listOfSymbols[size][size];
        initializeBoard();
        rows=new int[size];
        columns=new int[size];
        mainDia=0;
        leftDia=0;

    }

    // initialize board
    void initializeBoard(){
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                board[i][j]= listOfSymbols.D;
            }
        }
    }
    // validate a move
    boolean validateMove(int x, int y){
        if(x<0 || x>=size || y<0 || y>=size)
            return false;

        if(board[x][y]!=listOfSymbols.D)
            return false;
        return true;
    }

    void setMove(int x,int y, listOfSymbols symbol)
    {
        board[x][y]=symbol;
    }

    // find if win or not
    //as of now there are only 2 players so we can do o(n) approach
    // if players increase, we will have to use o(n^2) approach, validating everytime.
    boolean findWinner(int x, int y,listOfSymbols symbol)
    {
        if(symbol==listOfSymbols.X)
        {
            rows[x]++;
            columns[y]++;
            if(x==y)
                mainDia++;
            if(size-1-x==y)
                leftDia++;

        }else
        {
            rows[x]--;
            columns[y]--;
            if(x==y)
                mainDia--;
            if(size-1-x==y)
                leftDia--;
        }
        if(Math.abs(rows[x])==size || Math.abs(columns[y])==size || Math.abs(mainDia)==size || Math.abs(leftDia)==size)
        return true;

        return false;
    }



}
