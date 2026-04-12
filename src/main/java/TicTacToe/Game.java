package TicTacToe;
import java.util.Scanner;

public class Game {
    Scanner sc = new Scanner(System.in);
    Player player1;
    Player player2;
    int flag;
    Board board;
    Player currentPlayer;

    Game(){
        flag=0;
        currentPlayer=player1;
        board=new Board(3);
    }

    // set players
    void setPlayers()
    {
        System.out.println("Enter Player 1 name");
        String name1 = sc.next();
        System.out.println("Enter Player 1 symbol");
        listOfSymbols symbols1 = listOfSymbols.valueOf(sc.next()); // IMPORTANT
        player1=new Player(name1,symbols1);


        System.out.println("Enter Player 2 name");
        String name2 = sc.next();
        System.out.println("Enter Player 2 symbol");
        listOfSymbols symbols2 = listOfSymbols.valueOf(sc.next()); // IMPORTANT
        player2=new Player(name2,symbols2);

    }

    void startGame(){
        int i;
        // using default 9 here, otherwise it will be size*size
        for( i=0;i<9;i++){
            // extract coordinates
            currentPlayer = flag==0 ? player1 : player2;
            int x,y;
            System.out.println(currentPlayer.name + " your chance to play, enter your coordinates");
            while(true)
            {
                 x=sc.nextInt();
                 y=sc.nextInt();
                if(board.validateMove(x,y))
                    break;
                System.out.println("INVALID MOVE, please enter a new coordinate");
            }
            board.setMove(x,y,currentPlayer.symbol);
            if(board.findWinner(x,y,currentPlayer.symbol)){
                System.out.println(currentPlayer.name + " you WON THE MATCH");
                break;
            }
            flag = 1-flag;

        }
        if(i==9)
        System.out.println("DRAW");
    }
}
