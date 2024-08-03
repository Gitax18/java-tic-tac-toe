public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.printGrid();

        boolean isWin = game.checkWinner();
        boolean isGridEmpty = game.isCellAvailable();

        while(!isWin && !isGridEmpty){
            game.addToGrid();
            isWin = game.checkWinner();
            isGridEmpty = game.isCellAvailable();

        }
        if(game.checkWinner()){
            System.out.println("\t\t ***** Winner is "+game.winner + " *****");
        }else{
            System.out.println("\t\t ***** Game TIE *****");
        }

    }
}
